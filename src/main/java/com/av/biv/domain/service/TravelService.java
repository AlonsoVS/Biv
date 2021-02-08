package com.av.biv.domain.service;

import com.av.biv.domain.Travel;
import com.av.biv.domain.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

  @Autowired
  private TravelRepository travelRepository;

  public List<Travel> getAll() {
    return travelRepository.getAll();
  };

  public List<Travel> getUserTravels(Integer userId) {
    return travelRepository.getUserTravels(userId);
  }

  public Optional<Travel> getTravel(int travelId){
    return travelRepository.getTravel(travelId);
  }

  public Travel save(Travel travel) {
    return travelRepository.save(travel);
  }

  public boolean delete(int travelId) {
    return getTravel(travelId).map(travel -> {
      travelRepository.delete(travelId);
      return true;
    }).orElse(false);
  }
}
