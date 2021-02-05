package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.TravelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelCrudRepository extends CrudRepository<TravelEntity, Integer> {

  List<TravelEntity> findByUserId(Integer userId);
}
