package com.cleanwaters.cleanwatersmainapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "media")
public class Media {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 500)
  private String objectKey;

  @Column(nullable = false, length = 255)
  private String bucketName;

  @Column(nullable = false, length = 45)
  private String mimeType;

  @Column(nullable = false)
  private Timestamp createdAt;

//  @ManyToMany(mappedBy = "media")
//  private List<Pollution> pollutions;

  @ManyToMany(mappedBy = "media")
  private List<PickUpPoint> pickUpPoints;

  @ManyToMany(mappedBy = "media")
  private List<Bird> birds;
}