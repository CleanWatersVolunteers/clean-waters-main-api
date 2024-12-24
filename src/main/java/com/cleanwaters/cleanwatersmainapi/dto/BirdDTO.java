package com.cleanwaters.cleanwatersmainapi.dto;

import java.sql.Timestamp;
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
  private Timestamp discoveredAt;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private Timestamp deletedAt;
  private Long pollutionId;
}