package com.example.administrip.enums;

public enum EmployeeThresholdStatus {
  DaCoDinhMuc(1, "Đã có định mức"),
  ChuaCoDinhMuc(2, "Chưa có định mức");

  private int code;
  private String name;


  EmployeeThresholdStatus(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public static EmployeeThresholdStatus fromCode(int code) {
    if (code == DaCoDinhMuc.getCode()) {
      return DaCoDinhMuc;
    }
    return ChuaCoDinhMuc;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
