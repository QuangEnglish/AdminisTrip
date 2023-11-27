package com.example.administrip.service;

import java.util.Collection;
import java.util.List;
public interface BaseService<T, ID>{

  List<T> getAll();
  T getById(ID id);

  List<T> getByIds(Collection<ID> ids);

  T creatOrUpdate(ID id, T t);

  boolean deleteById(ID id);
}
