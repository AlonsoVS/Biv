package com.av.biv.domain.repository;

import com.av.biv.domain.Travel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TravelRepository {
  List<Travel> getAll();

  List<Travel> getUserTravels(int userId);

  List<Travel> getTravelsByUserUUIDid(UUID userId);

  Optional<Travel> getTravel(int travelId);

  Travel save(Travel travel);

  void delete(int travelId);
}
