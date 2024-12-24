package com.cleanwaters.cleanwatersmainapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name = "pollution")
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

  @Column(nullable = false)
  private Timestamp discoveredAt;

  @Column(nullable = false)
  private Timestamp createdAt;

  @Column
  private Timestamp updatedAt;

  @Column
  private Timestamp deletedAt;

  @OneToMany(mappedBy = "pollution")
  private List<PickUpPoint> pickUpPoints;

  @OneToMany(mappedBy = "pollution")
  private List<Bird> birds;

  @ManyToMany
  @JoinTable(
      name = "pollution_type_pollution",
      joinColumns = @JoinColumn(name = "pollution_id"),
      inverseJoinColumns = @JoinColumn(name = "pollution_type_id")
  )
  private List<PollutionType> pollutionTypes;

  @ManyToMany
  @JoinTable(
      name = "pollution_media",
      joinColumns = @JoinColumn(name = "pollution_id"),
      inverseJoinColumns = @JoinColumn(name = "media_id")
  )
  private List<Media> media;
}
