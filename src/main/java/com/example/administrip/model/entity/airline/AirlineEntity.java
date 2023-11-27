package com.example.administrip.model.entity.airline;

import com.example.administrip.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.lang.reflect.GenericArrayType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airline")
public class AirlineEntity extends BaseEntity {


  @Id
  @Column(name= "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 250)
  private String name;

  @Column(name = "code", length = 250)
  private String code;

  @Column(name= "contact_email", length = 250)
  private String contactEmail;

}
