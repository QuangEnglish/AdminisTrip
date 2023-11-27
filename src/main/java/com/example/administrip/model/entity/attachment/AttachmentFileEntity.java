package com.example.administrip.model.entity.attachment;

import com.example.administrip.model.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "attachment_file")
@EqualsAndHashCode
public class AttachmentFileEntity extends BaseEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "file_content")
  private String fileContent;

  @Column(name = "file_extension")
  private String fileExtension;  //tên đuôi file .xls, .img, .png

  @Column(name = "file_name", length = 500)
  private String fileName;

  @Column(name = "file_path", length = 1000)
  private String filePath;

  @Column(name = "file_size")
  private Long fileSize;

  @Column(name = "folder_path", length = 500)
  private String folderPath;

  @Column(name = "real_name", length = 500)
  private String realName;

  @Column(name = "mo_file_path", length = 500)
  private String moFilePath;

  @Column(name = "status")
  private Integer status;

}
