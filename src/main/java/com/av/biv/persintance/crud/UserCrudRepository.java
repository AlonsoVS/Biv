package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {

  Optional<List<UserEntity>> findByName(String name);

  Optional<UserEntity> findByEmail(String email);

  Optional<UserEntity> findByEntityType(String entityType);

  Optional<UserEntity> findByUuidId(UUID id);
}
