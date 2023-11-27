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
@Table(name = "car")
public class CarEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "car_registration_number", length = 250)
  private String carRegistrationNumber;

  @Column(name = "car_type", length = 250)
  private String carType;

  @Column(name = "contact_email", length = 250)
  private String contactEmail;

  @Column(name = "driver_name", length = 250)
  private String driverName;

  @Column(name = "driver_phone_number", length = 250)
  private String driverPhoneNumber;
}
