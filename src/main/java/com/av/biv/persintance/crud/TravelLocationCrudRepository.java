package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.TravelLocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TravelLocationCrudRepository extends CrudRepository<TravelLocationEntity, Integer> {
  Optional<List<TravelLocationEntity>> findByTravelId(Integer travelId);
  Optional<List<TravelLocationEntity>> findByUserId(int userId);
  Optional<List<TravelLocationEntity>> findByStatus(Boolean state);
  Optional<TravelLocationEntity> findByEntryDate(Date entryDate);
  Optional<TravelLocationEntity> findByDepartureDate(Date departureDate);
  Optional<TravelLocationEntity> findByAddress(String address);
  Optional<List<TravelLocationEntity>> findByEntityType(String entityType);
}
