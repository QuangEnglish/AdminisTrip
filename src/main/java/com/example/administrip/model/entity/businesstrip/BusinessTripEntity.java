package com.example.administrip.model.entity.businesstrip;

import com.example.administrip.enums.EBusinessTripStatus;
import com.example.administrip.model.entity.BaseEntity;
import com.example.administrip.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_trip")
@EqualsAndHashCode
public class BusinessTripEntity extends BaseEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "business_trip_name", nullable = false)
  private String businessTripName; // Tên chuyến công tác

  @Column(name = "leader_name")
  private String leaderName;

  @Column(name = "departure_time")
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date departureTime; // Ngày bắt đầu công tác

  @Column(name = "arrival_time", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN, timezone = DateUtils.TIME_ZONE)
  private Date arrivalTime; // Ngày kết thúc công tác

  @Column(name = "departure_location_id")
  private Long departureLocationId; // Id nơi xuất phát

  @Column(name = "arrival_location_id")
  private Long arrivalLocationId; // Id nơi đến

  @Column(name = "trip_description", columnDefinition = "TEXT(500)")
  private String tripDescription; // Nội dung chuyến công tác

  @Column(name = "attachment_type_id")
  private String attachmentTypeId;

  @Column(name = "business_type", columnDefinition = "VARCHAR(500)")
  private String businessType; // Loại chuyến công tác

  @Column(name = "airline_service_completed")
  private boolean airlineServiceCompleted = false;

  @Column(name = "hotel_service_completed")
  private boolean hotelServiceCompleted = false;

  @Column(name = "car_service_completed")
  private boolean carServiceCompleted = false;

  @Column(name = "has_airline_service")
  private boolean hasAirlineService = false;

  @Column(name = "has_hotel_service")
  private boolean hasHotelService = false;

  @Column(name = "has_car_service")
  private boolean hasCarService = false;

  @Column(name= "car_service_type")
  private Integer carServiceType;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private EBusinessTripStatus status = EBusinessTripStatus.INIT;

  @Column(name = "is_evaluated")
  private boolean isEvaluated = false;

  @Column(name = "is_provided")
  private boolean isProvided = false;

  @Column(name ="is_save_for")
  private boolean isSaveFor = false;

  @Column(name = "is_finished")
  private boolean isFinished = false;

  @Column(name = "business_type_code")
  private String businessTypeCode ;

}

