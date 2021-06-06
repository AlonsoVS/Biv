package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.TravelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TravelCrudRepository extends CrudRepository<TravelEntity, Integer> {

  Optional<List<TravelEntity>> findByUserId(Integer userId);
  Optional<List<TravelEntity>> findByUserUUIDId(UUID userId);
  Optional<List<TravelEntity>> findByEntityType(String entityType);
}
