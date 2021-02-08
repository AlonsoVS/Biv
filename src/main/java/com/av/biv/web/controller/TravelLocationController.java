package com.av.biv.web.controller;

import com.av.biv.domain.TravelLocation;
import com.av.biv.domain.service.TravelLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class TravelLocationController {
  @Autowired
  private TravelLocationService locationService;

  @GetMapping("/all")
  public List<TravelLocation> getAll() {
    return locationService.getAll();
  }

  @GetMapping("/user/{id}")
  public Optional<List<TravelLocation>> getUserLocations(@PathVariable("id") int userId) {
    return locationService.getUserLocations(userId);
  }

  @GetMapping("/travel/{id}")
  public Optional<List<TravelLocation>> getTravelLocations(@PathVariable("id") Integer travelId) {
    return locationService.getTravelLocations(travelId);
  }

  @GetMapping("/id/{id}")
  public Optional<TravelLocation> getLocation(@PathVariable("id") int locationId) {
    return locationService.getLocation(locationId);
  }

  @GetMapping("/state/actived")
  public Optional<List<TravelLocation>> getActived() {
    return locationService.getActived();
  }

  @GetMapping("/state/disabled")
  public Optional<List<TravelLocation>> getDisabled() {
    return locationService.getDisabled();
  }

  @GetMapping("/entry/{date}")
  public Optional<TravelLocation> getByEntryDate(@PathVariable("date") Date entryDate) {
    return locationService.getByEntryDate(entryDate);
  }

  @GetMapping("/departure/{date}")
  public Optional<TravelLocation> getByDepartureDate(@PathVariable("date") Date departureDate) {
    return locationService.getByDepartureDate(departureDate);
  }

  @GetMapping("/address/{address}")
  public Optional<TravelLocation> getByAddress(@PathVariable("address") String address) {
    return locationService.getByAddress(address);
  }

  @PostMapping("/save")
  public TravelLocation save(@RequestBody TravelLocation travelLocation) {
    return locationService.save(travelLocation);
  }

  @PostMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int locationId) {
    return getLocation(locationId).map(location -> {
      locationService.delete(locationId);
      return true;
    }).orElse(false);
  }
}
