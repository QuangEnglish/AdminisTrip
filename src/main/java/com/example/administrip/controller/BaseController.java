package com.example.administrip.controller;

import com.example.administrip.responsehandler.ResponseHandler;
import com.example.administrip.service.BaseService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<T, ID> {
  protected BaseService<T, ID> baseService;

  public BaseController(BaseService<T, ID> baseService){
      this.baseService = baseService;
  }

  @GetMapping("/get-all")
  public ResponseEntity<Object> getAll(){
    return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.getAll());
  }

  @GetMapping("/get-by-id/{id}")
  public ResponseEntity<Object> getById(@PathVariable("id") ID id){
    return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.getById(id));
  }

  @PostMapping("/create")
  public ResponseEntity<Object> create(@Valid @RequestBody T t){
    return ResponseHandler.generateResponse(HttpStatus.CREATED, "", baseService.creatOrUpdate(null, t));
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Object>update(@PathVariable("id") ID id, @Valid @RequestBody T t){
    return ResponseHandler.generateResponse(HttpStatus.CREATED, "", baseService.creatOrUpdate(id, t));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object>delete(@PathVariable("id") ID id){
    return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "", baseService.deleteById(id));
  }

}
