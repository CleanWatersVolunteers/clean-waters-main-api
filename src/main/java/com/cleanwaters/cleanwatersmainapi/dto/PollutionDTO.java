package com.cleanwaters.cleanwatersmainapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PollutionDTO implements BaseDTO {
  private Long id;
  private String longitude;
  private String latitude;
  private String comment;
  private String oldDataContainer;
  private String status;
  private String infoSource;
  private String discoveredAt;
  private String createdAt;
  private String updatedAt;
  private String deletedAt;
}