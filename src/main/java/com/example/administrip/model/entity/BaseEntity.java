package com.example.administrip.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
//lắng nghe sự kiện liên quan đến đối tg BaseEntity .
// AuditingEntityListener sẽ tự động điền các giá trị cho các trường như ngày tạo và ngày cập nhật của User.
public abstract class BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;
  //được sử dụng để xác định phiên bản của một lớp đối tượng trong quá trình serialization/deserialization
  @JsonIgnore  //khi chuyển đổi đối tượng sang json thì sẽ không xuất hiện trường này trong chuỗi json
  @Transient   //đánh dấu để ORM bỏ qua không ánh xạ mapping đối tượng vào csdl
  protected Map<String, String> attributes = new HashMap();

  @Column(
      name = "is_deleted"
  )
  @ApiModelProperty(  //tự tạo tài liệu API tự động và hidden chỉ thuộc tính này không xuất hiện trong tài liệu
      hidden = true
  )
  @JsonIgnore
  private boolean isDeleted = false;

  @Column(
      name = "created_by"
  )
  @ApiModelProperty(
      hidden = true
  )
  @JsonIgnore
  private Long createdBy;


  @CreatedDate
  @Column(
      name = "created_at", columnDefinition = "datetime(6)"
  )
  @ApiModelProperty(    //sử duụng thư viện swagger để mô tả các thuộc tính API
      hidden = true
  )
  private Date createdAt;


  @Column(
      name = "updated_by"
  )
  @ApiModelProperty(
      hidden = true
  )
  @JsonIgnore
  private Long updatedBy;

  @LastModifiedDate
  @Column(
      name = "updated_at", columnDefinition = "datetime(6)"
  )
  @ApiModelProperty(
      hidden = true
  )
  private Date updatedAt;

  public BaseEntity() {
  }

  public Map<String, String> getAttributes() {
    this.setAttributes();
    return this.attributes;
  }

  public void setAttributes() {
  }

  public boolean isDeleted() {
    return this.isDeleted;
  }

  public Long getCreatedBy() {
    return this.createdBy;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public Long getUpdatedBy() {
    return this.updatedBy;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  @JsonIgnore
  public void setAttributes(final Map<String, String> attributes) {
    this.attributes = attributes;
  }

  @JsonIgnore
  public void setDeleted(final boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  @JsonIgnore
  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  @JsonFormat(
      shape = Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
      timezone = "Asia/Ho_Chi_Minh"
  )
  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  @JsonIgnore
  public void setUpdatedBy(final Long updatedBy) {
    this.updatedBy = updatedBy;
  }

  @JsonFormat(
      shape = Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
      timezone = "Asia/Ho_Chi_Minh"
  )
  public void setUpdatedAt(final Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}

