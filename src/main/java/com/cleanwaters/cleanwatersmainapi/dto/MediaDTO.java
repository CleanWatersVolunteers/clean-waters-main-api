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
public class MediaDTO implements BaseDTO {
  private Long id;
  private String objectKey;
  private String bucketName;
  private String mimeType;
  private Timestamp createdAt;
}