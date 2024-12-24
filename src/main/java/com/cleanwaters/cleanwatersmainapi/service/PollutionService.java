package com.cleanwaters.cleanwatersmainapi.service;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionCreateDTO;
import com.cleanwaters.cleanwatersmainapi.dto.PollutionDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import com.cleanwaters.cleanwatersmainapi.mapper.PollutionCreateMapper;
import com.cleanwaters.cleanwatersmainapi.mapper.PollutionMapper;
import com.cleanwaters.cleanwatersmainapi.repository.PollutionRepository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PollutionService {
  private final PollutionRepository pollutionRepository;
  private final PollutionMapper pollutionMapper;
  private final PollutionCreateMapper pollutionCreateMapper;

  public PollutionService(PollutionRepository pollutionRepository, PollutionMapper pollutionMapper, PollutionCreateMapper pollutionCreateMapper) {
    this.pollutionRepository = pollutionRepository;
    this.pollutionMapper = pollutionMapper;
    this.pollutionCreateMapper = pollutionCreateMapper;
  }

  @Transactional
  public PollutionDTO createPollution(PollutionCreateDTO pollutionCreateDTO) {
    Pollution entity = pollutionCreateMapper.toEntity(pollutionCreateDTO);
    entity.setCreatedAt(new Timestamp(System.currentTimeMillis())); // Устанавливаем текущую дату/время
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
  public List<PollutionDTO> getAllPollutions() {
    return pollutionRepository.findAll()
        .stream()
        .map(pollutionMapper::toDto)
        .collect(Collectors.toList());
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
