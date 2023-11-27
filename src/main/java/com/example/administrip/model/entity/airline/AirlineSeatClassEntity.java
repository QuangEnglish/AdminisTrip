package com.example.administrip.model.entity.airline;

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
@Table(name = "airline_seat_class")
public class AirlineSeatClassEntity extends BaseEntity{

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "seat_class_id", length = 8)
  private Long seatClassId; // id của hạng ghế

  @Column(name = "airline_id", length = 8)
  private Long airlineId; // id của hãng bay
}
