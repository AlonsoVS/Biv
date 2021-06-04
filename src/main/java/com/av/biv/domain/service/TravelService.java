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

  @Autowired
  private UserService userService;

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

  public Optional<Travel> update(Travel travelModified) {
    boolean travelFound = travelRepository.getTravel(travelModified.getId()).map(User -> true).orElse(false);
    boolean userFound = userService.getUser(travelModified.getUserId()).map(User -> true).orElse(false);
    if (travelFound && userFound) {
      return Optional.ofNullable(travelRepository.save(travelModified));
    }
    return Optional.empty();
  }

  public boolean delete(int travelId) {
    return getTravel(travelId).map(travel -> {
      travelRepository.delete(travelId);
      return true;
    }).orElse(false);
  }
}
