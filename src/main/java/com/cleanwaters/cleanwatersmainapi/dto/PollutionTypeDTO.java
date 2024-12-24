package com.cleanwaters.cleanwatersmainapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PollutionTypeDTO implements BaseDTO {
  private Long id;
  private String name;
}