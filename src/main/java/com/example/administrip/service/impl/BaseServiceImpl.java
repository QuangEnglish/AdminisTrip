package com.example.administrip.service.impl;

import com.example.administrip.model.entity.BaseEntity;
import com.example.administrip.service.BaseService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public class BaseServiceImpl<T extends BaseEntity, ID> implements BaseService<T, ID> {
  protected JpaRepository<T, ID> repository;

  public BaseServiceImpl(JpaRepository<T, ID> repository) {
    this.repository = repository;
  }

  @Override
  public List<T> getAll() {
    return repository.findAll();
  }

  @Override
  public T getById(ID id) {
    T t = repository.findById(id).orElse(null);
    return t == null || t.isDeleted() ? null : t;
  }

  @Override
  public List<T> getByIds(Collection<ID> ids) {
    return repository.findAllById(ids);
  }

  @Override
  @Transactional
  public T creatOrUpdate(ID id, T t) {
    if (id != null) {
      T e = this.getById(id);
      if (e != null) {
        // TODO: CURRENT ID
        // copyProperties(t, e, UserHrUtils.getCurrentUserId(), "id", "createdAt", "createdBy", "isDeleted");
        copyProperties(t, e, null, "id", "createdAt", "createdBy", "isDeleted");
        return repository.save(e);
      } else {
        return null;
      }
    }
    // TODO: CURRENT ID
    // copyProperties(t, t, UserHrUtils.getCurrentUserId(), "id", "createdAt", "createdBy", "isDeleted");
    copyProperties(t, t, null, "id", "createdAt", "createdBy", "isDeleted");

    return repository.save(t);
  }

  @Override
  public boolean deleteById(ID id) {
    try {
      T t = this.getById(id);
      t.setDeleted(true);
      repository.save(t);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static <S, T extends BaseEntity> void copyProperties(S s, T t, Long userId, String... ignoreProperties) {
    BeanUtils.copyProperties(s, t, ignoreProperties);
    if (t.getCreatedAt() == null) {
      t.setCreatedAt(new Date());
      t.setCreatedBy(userId);
    }
    t.setUpdatedAt(new Date());
    t.setUpdatedBy(userId);
  }

//  public KeycloakSecurityContext getContext() {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (authentication != null) {
//      Object principal = authentication.getPrincipal();
//      if (principal instanceof KeycloakPrincipal) {
//        return ((KeycloakPrincipal) principal).getKeycloakSecurityContext();
//      }
//    }
//    return null;
//  }
}
