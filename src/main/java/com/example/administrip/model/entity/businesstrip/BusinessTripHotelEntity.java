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
@Table(name = "business_trip_hotel_service")
public class BusinessTripHotelEntity extends BaseEntity {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "business_trip_id")
  @NotNull(message = "Bắt buộc nhập")
  private Long businessTripId; // Id chuyến công tác

  @Column(name = "hotel_id")
  private Long hotelId; // Id khách sạn

  @Column(name = "province_id")
  private Long provinceId; // Id tỉnh

  @Column(name = "district_id")
  private Long districtId; // Id quận huyện

  @Column(name = "address")
  private String address; // Id địa chỉ cụ thể

  @Column(name = "check_in_time")
  @Temporal(TemporalType.TIMESTAMP)  //đánh dấu trường lưu thời gian c giờ phút giây
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date checkInTime; // Ngày bắt đầu

  @Column(name = "check_out_time")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date checkOutTime; // Ngày kết thúc

  @Column(name = "stay_duration")
  private String stayDuration; // thời gian lưu trú

  @Column(name = "number_of_room")
  private Integer numberOfRoom; // số lượng phòng

  @Column(name = "room_type_id")
  private Long roomTypeId; // id loại phòng

  @Column(name = "note")
  private String note; // note

  @Column(name = "room_number")
  private String roomNumber; // số phòng

  @Column(name = "total_cost")
  private Long totalCost; // tổng số tiền

  @Column(name = "is_active")
  private boolean isActive = true; // Có bị vô hiệu hóa hay chưa

  @Column(name = "evaluate_star")
  private Integer evaluateStar; // Số sao đánh giá

  @Column(name = "evaluate_by_staff_id")
  private Long evaluateByStaffId; // Đánh giá bởi nhân viên nào

  @Column(name = "evaluate_content")
  private String evaluateContent; // Nội dung đánh giá

}
