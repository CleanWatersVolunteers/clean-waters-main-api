package com.cleanwaters.cleanwatersmainapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "bird")
public class Bird {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 45)
  private String longitude;

  @Column(nullable = false, length = 45)
  private String latitude;

  @Column(nullable = false, length = 45)
  private String status;

  @Column
  private Integer priority;

  @Column(nullable = false)
  private Boolean captured;

  @Column(nullable = false, length = 255)
  private String infoSource;

  @Column
  private Timestamp discoveredAt;

  @Column
  private Timestamp createdAt;

  @Column
  private Timestamp updatedAt;

  @Column
  private Timestamp deletedAt;

  @ManyToOne
  @JoinColumn(name = "pollution_id")
  private Pollution pollution;

  @ManyToMany
  @JoinTable(
      name = "bird_has_media",
      joinColumns = @JoinColumn(name = "bird_id"),
      inverseJoinColumns = @JoinColumn(name = "media_id")
  )
  private List<Media> media;
}