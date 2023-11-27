package com.example.administrip.model.entity.businesstrip;

import com.example.administrip.model.entity.BaseEntity;
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
@Table(name = "business_trip_attachment_type")
public class BusinessTripAttachmentTypeEntity extends BaseEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "business_trip_id")
  @NotNull(message = "Bắt buộc nhập id chuyến công tác")
  private Long businessTripId;

  @Column(name = "attachment_type_name")
  @NotNull(message = "Bắt buộc nhập tên loại hồ sơ")
  private String attachmentTypeName;

  @Column(name = "file_info_ids")
  private String fileInfoIds;

  @Column(name = "attachments_file_id")
  private String attachmentsFileId;

  @Column(name = "selected")
  private boolean selected;

  @Column(name = "is_default")
  private boolean isDefault = false;

  @Column(name = "attachment_type_id")
  private Long attachmentTypeId;

}