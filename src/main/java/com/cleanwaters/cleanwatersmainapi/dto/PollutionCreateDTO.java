package com.cleanwaters.cleanwatersmainapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PollutionCreateDTO implements BaseDTO {
  private String longitude;
  private String latitude;
  private String comment;
  private String oldDataContainer;
  private String status;
  private String infoSource;
  private LocalDateTime discoveredAt;
}