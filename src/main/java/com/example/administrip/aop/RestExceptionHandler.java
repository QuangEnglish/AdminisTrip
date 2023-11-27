package com.example.administrip.aop;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    String error = "Yêu cầu không đúng định dạng!";
    return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
  }


//  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//    ProblemDetail body = this.createProblemDetail(ex, status, "Failed to read request",
//        (String) null, (Object[]) null, request);
//    return this.handleExceptionInternal(ex, body, headers, status, request);
//  }

  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

}