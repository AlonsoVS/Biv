package com.av.biv.web.controller;

import com.av.biv.domain.Travel;
import com.av.biv.domain.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travels")
public class TravelController {
  @Autowired
  private TravelService travelService;

  @GetMapping("/all")
  public List<Travel> getAll() {
    return travelService.getAll();
  }

  @GetMapping("/user/{id}")
  public List<Travel> getUserTravels(@PathVariable("id") int userId) {
    return travelService.getUserTravels(userId);
  }

  @GetMapping("/{id}")
  public Optional<Travel> getTravel(@PathVariable("id") int travelId){
    return travelService.getTravel(travelId);
  }

  @GetMapping("/uuid_id/{id}")
  public List<Travel> getTravelsByUserUUIDId(@PathVariable("id") String id) {
    return travelService.getTravelsByUserUUIDId(id);
  }

  @GetMapping("/entity_type/{type}")
  public List<Travel> getTravelsByEntityType(@PathVariable("type") String type) {
    return travelService.getTravelsByEntityType(type);
  }

  @PostMapping("/save")
  public Travel save(@RequestBody Travel travel) {
    return travelService.save(travel);
  }

  @PostMapping("/update")
  public Optional<Travel> update(@RequestBody Travel travelModified) {
    return travelService.update(travelModified);
  }

  @PostMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int travelId) {
    return travelService.delete(travelId);
  }
}
