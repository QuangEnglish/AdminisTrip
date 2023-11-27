package com.example.administrip.aop;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {
  private HttpStatus status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timeStamp;
  private String message;
  private String debugMessage;
  private List<ApiSubError> subErrors;

  private ApiError() {
    timeStamp = LocalDateTime.now();
  }

  ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  ApiError(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.message = "Unexpected error";
    this.debugMessage = ex.getLocalizedMessage();
  }

  ApiError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }

}
