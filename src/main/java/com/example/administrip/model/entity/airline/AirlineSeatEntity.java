package com.example.administrip.model.entity.airline;

import com.example.administrip.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airline_seat")
public class AirlineSeatEntity extends BaseEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 250)
  @Size(max = 250, message = "Vượt quá số ký tự cho phép")
  private String name; // tên hạng ghế

  @Column(name = "english_name",  length = 250)
  @Size(max = 250, message = "Vượt quá số ký tự cho phép")
  private String englishName; // tên hạng ghê bằng tiếng anh @.@
}
