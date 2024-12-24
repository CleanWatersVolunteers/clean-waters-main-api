package com.cleanwaters.cleanwatersmainapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BirdDTO implements BaseDTO {
  private Long id;
  private String longitude;
  private String latitude;
  private String status;
  private Integer priority;
  private Boolean captured;
  private String infoSource;
  private String discoveredAt;
  private String createdAt;
  private String updatedAt;
  private String deletedAt;
  private Long pollutionId;
}