package com.cleanwaters.cleanwatersmainapi.service;

import com.cleanwaters.cleanwatersmainapi.dto.BaseDTO;
import java.util.List;

public interface BaseService<E extends BaseDTO> {
  E findById(Long id);

  void delete(Long id);

  E update(Long id, E entity);

  E save(E entity);

  List<E> findAll();
}
