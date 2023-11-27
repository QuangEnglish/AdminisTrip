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
@Table(name = "hotel")
public class HotelEntity extends BaseEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "province_id")
  private Long provinceId;

  @Column(name = "district_id")
  private Long districtId;

  @Column(name = "address")
  private String address;

  @Column(name = "hotel_room_type_id")
  private Long hotelRoomTypeId;

  @Column(name = "contact_email")
  private String contactEmail;

}

