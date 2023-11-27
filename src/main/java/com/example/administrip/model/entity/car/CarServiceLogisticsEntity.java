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
@Table(name = "car_service_logistics")
public class CarServiceLogisticsEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "amount_employee")
  private Long amountEmployee;

  @Column(name = "license_plates")
  private String licensePlates;

  @Column(name = "driver_name")
  private String driverName;

  @Column(name = "driver_phone_number")
  private String driverPhoneNumber;

  @Column(name = "departure")
  private Long departure;

  @Column(name = "destination")
  private Long destination;

  @Column(name = "note")
  private String note;
}
