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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_trip_airline_service")
public class BusinessTripAirlineEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "business_trip_id")
  private Long businessTripId; // Id chuyến công tác

  @Column(name = "airline_id")
  private Long airlineId; // Id chuyến công tác

  @Column(name = "departure_time")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date departureTime; // Ngày bắt đầu

  @Column(name = "arrival_time")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date arrivalTime; // ngày kết thúc

  @Column(name = "departure_location_id")
  private Long departureLocationId; // Id nơi xuất phát

  @Column(name = "arrival_location_id")
  private Long arrivalLocationId; // Id nơi đến

  @Column(name = "seat_class_id")
  private Long seatClassId; // Id nơi đến

  @Column(name = "seat_info")
  private String seatInfo;  //thông tin đặt chỗ

  @Column(name = "note", columnDefinition = "VARCHAR(255)")
  private String note; // Nội dung ghi chú

  @Column(name = "cost")
  private Long cost; // chi phí

  @Column(name = "reservation_file_ids")
  private String reservationFileIds; // Ids file thông tin

  @Column(name = "is_active")
  private boolean isActive = true; // Có bị vô hiệu hóa hay chưa

  @Column(name = "evaluate_star")
  private Integer evaluate_star; // Số sao đánh giá

  @Column(name = "evaluate_by_staff_id")
  private Long evaluateByStaffId; // Đánh giá bởi nhân viên nào

  @Column(name = "evaluate_content")
  private String evaluateContent; // Nội dung đánh giá


}
