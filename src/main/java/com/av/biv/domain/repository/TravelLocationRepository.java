package com.av.biv.domain.repository;

import com.av.biv.domain.TravelLocation;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TravelLocationRepository {
  List<TravelLocation> getAll();
  Optional<List<TravelLocation>> getUserTravelLocations(int userId);
  Optional<List<TravelLocation>> getTravelLocations(Integer travelId);
  Optional<TravelLocation> getLocation(int travelLocationId);
  Optional<List<TravelLocation>> getByStatus(Boolean state);
  Optional<TravelLocation> getByEntryDate(Date entryDate);
  Optional<TravelLocation> getByDepartureDate(Date departureDate);
  Optional<TravelLocation> getByAddress(String address);
  TravelLocation save(TravelLocation travelLocation);
  void delete(int travelLocationId);
}
