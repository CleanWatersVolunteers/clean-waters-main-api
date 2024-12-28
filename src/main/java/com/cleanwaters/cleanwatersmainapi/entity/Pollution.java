package com.cleanwaters.cleanwatersmainapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pollution")
@FieldNameConstants
public class Pollution {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 45)
  private String longitude;

  @Column(nullable = false, length = 45)
  private String latitude;

  @Column
  private String comment;

  @Column
  private String oldDataContainer;

  @Column(nullable = false, length = 45)
  private String status;

  @Column(nullable = false, length = 255)
  private String infoSource;

  private String surfaceType;

  @Column
  private LocalDateTime discoveredAt;

  @CreationTimestamp
  @Column
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column
  private LocalDateTime updatedAt;

  @Column
  private LocalDateTime deletedAt;
}
