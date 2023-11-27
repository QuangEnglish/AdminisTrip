package com.example.administrip.model.entity.businesstrip;

import com.example.administrip.model.entity.BaseEntity;
import com.example.administrip.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
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
@Table(name = "business_trip_car_service")
public class BusinessTripCarEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "business_trip_id")
  @NotNull(message = "Bắt buộc nhập")
  private Long businessTripId; // Id chuyến công tác

  @Column(name = "departure_location")
  private String departure; // điểm đi

  @Column(name = "arrival_location")
  private String arrival; // điểm đến

  @Column(name = "departure_time")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date departureTime; // Thời gian

  @Column(name = "arrival_time")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date arrivalTime; // khoảng kết thúc (vì thời gian xuất phát có thể là 1 khoảng)

  @Column(name = "driver_id")
  private Long driverId; // Tên tài xế

  @Column(name = "driver_name")
  private String driverName; // Tên tài xế

  @Column(name = "driver_phone_number")
  private String driverPhoneNumber; // Sđt tài xế

  @Column(name = "car_registration_number")
  private String carRegistrationNumber; // Biển số xe

  @Column(name = "amount_employee")
  private Long amountEmployee; // Số lượng nhân sự

  @Column(name = "note")
  private String note; // Nội dung ghi chú

  @Column(name = "is_active")
  private boolean isActive = true; // Có bị vô hiệu hóa hay chưa

  @Column(name = "evaluate_star")
  private Integer evaluateStar; // Số sao đánh giá

  @Column(name = "evaluate_by_staff_id")
  private Long evaluateByStaffId; // Đánh giá bởi nhân viên nào

  @Column(name = "evaluate_content")
  private String evaluateContent; // Nội dung đánh giá

  @Column(name = "cost")
  private Long cost;
}
