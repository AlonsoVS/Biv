package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.TravelEntity;
import com.av.biv.persintance.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TravelCrudRepository extends CrudRepository<TravelEntity, Integer> {

  List<TravelEntity> findByUserId(Integer userId);
}
