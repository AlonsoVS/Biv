package com.av.biv.domain.service;

import com.av.biv.domain.TravelLocation;
import com.av.biv.domain.repository.TravelLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TravelLocationService {
  @Autowired
  private TravelLocationRepository locationRepository;

  public List<TravelLocation> getAll() {
    return locationRepository.getAll();
  }

  public Optional<List<TravelLocation>> getUserLocations(int userId) {
    return locationRepository.getUserTravelLocations(userId);
  }

  public Optional<List<TravelLocation>> getTravelLocations(Integer travelId) {
    return locationRepository.getTravelLocations(travelId);
  }

  public Optional<TravelLocation> getLocation(int locationId) {
    return locationRepository.getLocation(locationId);
  }

  public Optional<List<TravelLocation>> getActived() {
    return locationRepository.getByState(true);
  }

  public Optional<List<TravelLocation>> getDisabled() {
    return locationRepository.getByState(false);
  }

  public Optional<TravelLocation> getByEntryDate(Date entryDate) {
    return locationRepository.getByEntryDate(entryDate);
  }

  public Optional<TravelLocation> getByDepartureDate(Date departureDate) {
    return locationRepository.getByDepartureDate(departureDate);
  }

  public Optional<TravelLocation> getByAddress(String address) {
    return locationRepository.getByAddress(address);
  }

  public Optional<TravelLocation> getByLocationId(int locationId) {
    return locationRepository.getByLocationId(locationId);
  }

  public TravelLocation save(TravelLocation travelLocation) {
    return locationRepository.save(travelLocation);
  }

  public boolean delete(int locationId) {
    return getLocation(locationId).map(location -> {
      locationRepository.delete(locationId);
      return true;
    }).orElse(false);
  }
}
