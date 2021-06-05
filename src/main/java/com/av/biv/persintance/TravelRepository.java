package com.av.biv.persintance;

import com.av.biv.domain.Travel;
import com.av.biv.persintance.crud.TravelCrudRepository;
import com.av.biv.persintance.entity.TravelEntity;
import com.av.biv.persintance.mapper.TravelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TravelRepository implements com.av.biv.domain.repository.TravelRepository {

  @Autowired
  private TravelMapper travelMapper;
  @Autowired
  private TravelCrudRepository travelCrudRepository;

  @Override
  public List<Travel> getAll() {
    return travelMapper.toTravels((List<TravelEntity>) travelCrudRepository.findAll());
  }

  @Override
  public List<Travel> getUserTravels(int userId) {
    List<TravelEntity> userTravels = travelCrudRepository.findByUserId(userId);
    return travelMapper.toTravels(userTravels);
  }

  @Override
  public List<Travel> getTravelsByUserUUIDid(UUID userId) {
    return travelMapper.toTravels(travelCrudRepository.findByUserUUIDId(userId));
  }

  @Override
  public List<Travel> getTravelsByEntityType(String entityType) {
    return travelMapper.toTravels(travelCrudRepository.findByEntityType(entityType));
  }

  @Override
  public Optional<Travel> getTravel(int travelId) {
    return travelCrudRepository.findById(travelId).map(travel -> travelMapper.toTravel(travel));
  }

  @Override
  public Travel save(Travel travel) {
    TravelEntity savedTravel = travelCrudRepository.save(travelMapper.toTravelEntity(travel));
    return travelMapper.toTravel(savedTravel);
  }

  @Override
  public void delete(int travelId) {
    travelCrudRepository.deleteById(travelId);
  }
}
