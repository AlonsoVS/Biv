package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.TravelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TravelCrudRepository extends CrudRepository<TravelEntity, Integer> {

  List<TravelEntity> findByUserId(Integer userId);
  List<TravelEntity> findByUserUUIDId(UUID userId);
  List<TravelEntity> findByEntityType(String entityType);
}
