package com.example.administrip.model.entity.airline;

import com.example.administrip.model.entity.BaseEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airline_service_staff")
public class AirlineServiceStaffEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "business_trip_staff_id")
  @NotNull(message = "Bắt buộc nhập id nhân viên tham gia chuyến công tác")
  private Long businessTripStaffId;

  @Column(name = "staff_id")
  @NotNull(message = "Bắt buộc nhập id nhân viên")
  private Long staffId;

  @Column(name = "airline_service_id")
  @NotNull(message = "Bắt buộc nhập id dịch vụ máy bay")
  private Long airlineServiceId;

  @Column(name = "ticket")
  @Nullable
  private Long ticketId;

  @Column(name = "cost")
  @Nullable
  private Long cost;

}
