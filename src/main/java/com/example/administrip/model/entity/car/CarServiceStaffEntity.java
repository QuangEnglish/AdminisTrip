package com.example.administrip.model.entity.car;

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
@Table(name = "car_service_staff")
public class CarServiceStaffEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "car_service_id")
  private Long carServiceId;

  @Column(name = "business_trip_staff_id")
  private Long businessTripStaffId;

  @Column(name = "driver_id")
  private Long driverId;
}
