package com.example.administrip.model.entity.hotel;

import com.example.administrip.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel_service_evaluation")
public class HotelServiceEvaluationEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "evaluate_by_staff_id")
  private Long evaluateByStaffId;

  @Column(name = "evaluate_content")
  private String evaluateContent;

  @Column(name = "evaluate_star")
  private Integer evaluateStar;

  @Column(name = "hotel_service_id")
  private Long hotelServiceId;
}
