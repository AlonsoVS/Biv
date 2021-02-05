package com.av.biv.domain.repository;

import com.av.biv.domain.Travel;

import java.util.List;
import java.util.Optional;

public interface TravelRepository {
  List<Travel> getUserTravels(int userId);

  Optional<Travel> getTravel(int travelId);

  Travel save(Travel travel);

  void delete(int travelId);
}
