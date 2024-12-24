package com.cleanwaters.cleanwatersmainapi.controller;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionCreateDTO;
import com.cleanwaters.cleanwatersmainapi.dto.PollutionDTO;
import com.cleanwaters.cleanwatersmainapi.service.PollutionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<List<PollutionDTO>> getAllPollutions() {
    List<PollutionDTO> pollutions = pollutionService.getAllPollutions();
    return ResponseEntity.ok(pollutions);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PollutionDTO> updatePollution(@PathVariable Long id, @RequestBody PollutionDTO pollutionDTO) {
    PollutionDTO updatedPollution = pollutionService.updatePollution(id, pollutionDTO);
    return ResponseEntity.ok(updatedPollution);
  }
}