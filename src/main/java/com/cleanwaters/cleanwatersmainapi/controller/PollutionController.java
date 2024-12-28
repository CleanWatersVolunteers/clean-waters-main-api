package com.cleanwaters.cleanwatersmainapi.controller;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionCreateDTO;
import com.cleanwaters.cleanwatersmainapi.dto.pollution.PollutionDTO;
import com.cleanwaters.cleanwatersmainapi.dto.pollution.PollutionFilter;
import com.cleanwaters.cleanwatersmainapi.service.PollutionService;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pollution")
public class PollutionController {

  private final PollutionService pollutionService;

  public PollutionController(PollutionService pollutionService) {
    this.pollutionService = pollutionService;
  }

  @PostMapping
  public ResponseEntity<PollutionDTO> createPollution(@RequestBody PollutionCreateDTO pollutionCreateDTO) {
    PollutionDTO createdPollution = pollutionService.createPollution(pollutionCreateDTO);
    return new ResponseEntity<>(createdPollution, HttpStatus.CREATED);
  }
  @GetMapping("/{id}")
  public ResponseEntity<PollutionDTO> getPollutionById(@PathVariable Long id) {
    PollutionDTO pollutionDTO = pollutionService.getPollutionById(id);
    return ResponseEntity.ok(pollutionDTO);
  }

  @GetMapping
  @Operation(summary = "Получить все загрязнения из базы по заданным фильтрам")
  public ResponseEntity<List<PollutionDTO>> getAllPollutions(
          @Parameter(description = "Статус загрязнения (в любом регистре, можно неск значений)", example = "собрано")
          @RequestParam(required = false) List<String> status,
          @Parameter(description = "Обнаружено до", example = "2024-12-24T00:00:00")
          @RequestParam(required = false) LocalDateTime discoveredBefore,
          @Parameter(description = "Обнаружено после", example = "2024-12-24T00:00:00")
          @RequestParam(required = false) LocalDateTime discoveredAfter,
          @Parameter(description = "Логин или ссылка на пост")
          @RequestParam(required = false) String infoSource,
          @Parameter(description = "Тип поверхности (в любом регистре, можно неск значений", example = "песок, море, галька, растительность")
          @RequestParam(required = false) List<String> surfaceType
          ) {
    var pollutionFilter = PollutionFilter.builder()
            .status(status)
            .discoveredBefore(discoveredBefore)
            .discoveredAfter(discoveredAfter)
            .infoSource(infoSource)
            .surfaceType(surfaceType)
            .build();
    var pollutions = pollutionService.getAllPollutions(pollutionFilter);
    return ResponseEntity.ok(pollutions);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PollutionDTO> updatePollution(@PathVariable Long id, @RequestBody PollutionDTO pollutionDTO) {
    PollutionDTO updatedPollution = pollutionService.updatePollution(id, pollutionDTO);
    return ResponseEntity.ok(updatedPollution);
  }
}