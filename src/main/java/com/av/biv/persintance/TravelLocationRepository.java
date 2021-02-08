package com.av.biv.persintance;

import com.av.biv.domain.TravelLocation;
import com.av.biv.persintance.crud.TravelLocationCrudRepository;
import com.av.biv.persintance.entity.TravelLocationEntity;
import com.av.biv.persintance.mapper.TravelLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TravelLocationRepository implements com.av.biv.domain.repository.TravelLocationRepository {
  @Autowired
  private TravelLocationMapper travelLocationMapper;
  @Autowired
  private TravelLocationCrudRepository travelLocationCrudRepository;

  @Override
  public List<TravelLocation> getAll() {
    List<TravelLocationEntity> travelLocations = (List<TravelLocationEntity>) travelLocationCrudRepository.findAll();
    return travelLocationMapper.toTravelLocations(travelLocations);
  }

  @Override
  public Optional<List<TravelLocation>> getUserTravelLocations(int userId) {
    return travelLocationCrudRepository.findByUserId(userId).map(locations -> travelLocationMapper.toTravelLocations(locations));
  }

  @Override
  public Optional<List<TravelLocation>> getTravelLocations(Integer travelId) {
    return travelLocationCrudRepository.findByTravelId(travelId).map(locations -> travelLocationMapper.toTravelLocations(locations));
  }

  @Override
  public Optional<TravelLocation> getLocation(int travelLocationId) {
    Optional<TravelLocationEntity> travelLocation = travelLocationCrudRepository.findById(travelLocationId);
    return travelLocation.map(location -> travelLocationMapper.toTravelLocation(location));
  }

  @Override
  public Optional<List<TravelLocation>> getByStatus(Boolean state) {
    return travelLocationCrudRepository.findByStatus(state).map(locations -> travelLocationMapper.toTravelLocations(locations));
  }

  @Override
  public Optional<TravelLocation> getByEntryDate(Date entryDate) {
    return travelLocationCrudRepository.findByEntryDate(entryDate).map(location -> travelLocationMapper.toTravelLocation(location));
  }

  @Override
  public Optional<TravelLocation> getByDepartureDate(Date departureDate) {
    return travelLocationCrudRepository.findByDepartureDate(departureDate).map(location -> travelLocationMapper.toTravelLocation(location));
  }

  @Override
  public Optional<TravelLocation> getByAddress(String address) {
    return travelLocationCrudRepository.findByAddress(address).map(location -> travelLocationMapper.toTravelLocation(location));
  }

  @Override
  public TravelLocation save(TravelLocation travelLocation) {
    TravelLocationEntity locationEntity = travelLocationMapper.toTravelLocationEntity(travelLocation);
    return travelLocationMapper.toTravelLocation(travelLocationCrudRepository.save(locationEntity));
  }

  @Override
  public void delete(int travelLocationId) {
    travelLocationCrudRepository.deleteById(travelLocationId);
  }

}
