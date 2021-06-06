package com.av.biv.domain.repository;

import com.av.biv.domain.Travel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TravelRepository {
  List<Travel> getAll();

  Optional<List<Travel>> getUserTravels(int userId);

  Optional<List<Travel>> getTravelsByUserUUIDid(UUID userId);

  Optional<List<Travel>> getTravelsByEntityType(String entityType);

  Optional<Travel> getTravel(int travelId);

  Travel save(Travel travel);

  void delete(int travelId);
}
