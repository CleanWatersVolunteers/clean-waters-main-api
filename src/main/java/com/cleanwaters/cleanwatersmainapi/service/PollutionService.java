package com.cleanwaters.cleanwatersmainapi.service;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionCreateDTO;
import com.cleanwaters.cleanwatersmainapi.dto.pollution.PollutionDTO;
import com.cleanwaters.cleanwatersmainapi.dto.pollution.PollutionFilter;
import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import com.cleanwaters.cleanwatersmainapi.mapper.PollutionCreateMapper;
import com.cleanwaters.cleanwatersmainapi.mapper.PollutionMapper;
import com.cleanwaters.cleanwatersmainapi.repository.PollutionRepository;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@RequiredArgsConstructor
public class PollutionService {

  private final PollutionRepository pollutionRepository;
  private final PollutionMapper pollutionMapper;
  private final PollutionCreateMapper pollutionCreateMapper;

  @Transactional
  public PollutionDTO createPollution(PollutionCreateDTO pollutionCreateDTO) {
    Pollution entity = pollutionCreateMapper.toEntity(pollutionCreateDTO);
    Pollution saved = pollutionRepository.save(entity);
    return pollutionMapper.toDto(saved);
  }

  @Transactional(readOnly = true)
  public PollutionDTO getPollutionById(Long id) {
    Optional<Pollution> pollution = pollutionRepository.findById(id);
    return pollution.map(pollutionMapper::toDto)
        .orElseThrow(() -> new RuntimeException("Pollution not found with id " + id));
  }

  @Transactional(readOnly = true)
  public List<PollutionDTO> getAllPollutions(PollutionFilter filter) {

    var filters = getFilters(filter);

    return pollutionRepository.findAll(filters, Sort.by(DESC, Pollution.Fields.discoveredAt))
        .stream()
        .map(pollutionMapper::toDto)
        .collect(Collectors.toList());
  }

  private Specification<Pollution> getFilters(PollutionFilter filter) {
    Specification<Pollution> spec = Specification.where(null);

    if (filter.discoveredBefore() != null) {
      spec = spec.and((root, query, criteriaBuilder) ->
              criteriaBuilder.lessThan(root.get("discoveredAt"), filter.discoveredBefore()));
    }

    if (filter.discoveredAfter() != null) {
      spec = spec.and((root, query, criteriaBuilder) ->
              criteriaBuilder.greaterThanOrEqualTo(root.get("discoveredAt"), filter.discoveredAfter()));
    }

    if (filter.infoSource() != null) {
      spec = spec.and((root, query, criteriaBuilder) ->
              criteriaBuilder.equal(root.get("infoSource"), filter.infoSource()));
    }

    if (!CollectionUtils.isEmpty(filter.status())) {
      spec = spec.and((root, query, criteriaBuilder) -> {
        Set<String> normalizedStatuses = filter.status().stream()
                .flatMap(status -> {
                  if (status.equalsIgnoreCase("новый") || status.equalsIgnoreCase("новое")) {
                    return Stream.of("новый", "новое");
                  } else if (status.equalsIgnoreCase("собрано") || status.equalsIgnoreCase("собирается")) {
                    return Stream.of("собрано", "собирается");
                  }
                  return Stream.of(status);
                })
                .collect(Collectors.toSet());

        return criteriaBuilder.lower(root.get("status")).in(normalizedStatuses);
      });
    }

    if (!CollectionUtils.isEmpty(filter.surfaceType())) {
      spec = spec.and((root, query, criteriaBuilder) -> {
        List<String> lowerCaseSurfaceTypes = filter.surfaceType().stream()
                .map(String::toLowerCase)
                .toList();

        return criteriaBuilder.or(lowerCaseSurfaceTypes.stream()
                .map(type -> criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("surfaceType")),
                        "%" + type + "%"))
                .toArray(Predicate[]::new));
      });
    }
    return spec;
  }

  @Transactional
  public PollutionDTO updatePollution(Long id, PollutionDTO pollutionDTO) {
    return pollutionRepository.findById(id).map(existingPollution -> {
      pollutionMapper.updateEntityFromDto(pollutionDTO, existingPollution);
      Pollution savedPollution = pollutionRepository.save(existingPollution);
      return pollutionMapper.toDto(savedPollution);
    }).orElseThrow(() -> new RuntimeException("Pollution not found with id " + id));
  }

  @Transactional
  public void deletePollution(Long id) {
    if (pollutionRepository.existsById(id)) {
      pollutionRepository.deleteById(id);
    } else {
      throw new RuntimeException("Pollution not found with id " + id);
    }
  }

}
