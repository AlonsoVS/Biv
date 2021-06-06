package com.av.biv.web.controller;

import com.av.biv.domain.TravelLocation;
import com.av.biv.domain.service.TravelLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<TravelLocation>> getAll() {
    return new ResponseEntity<>(locationService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<TravelLocation>> getUserLocations(@PathVariable("id") int userId) {
    return locationService.getUserLocations(userId)
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/travel/{id}")
  public ResponseEntity<List<TravelLocation>> getTravelLocations(@PathVariable("id") Integer travelId) {
    return locationService.getTravelLocations(travelId)
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<TravelLocation> getLocation(@PathVariable("id") int locationId) {
    return locationService.getLocation(locationId)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/status/actived")
  public ResponseEntity<List<TravelLocation>> getActived() {
    return locationService.getActived()
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/status/disabled")
  public ResponseEntity<List<TravelLocation>> getDisabled() {
    return locationService.getDisabled()
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/entry_date/{date}")
  public ResponseEntity<TravelLocation> getByEntryDate(@PathVariable("date") Date entryDate) {
    return locationService.getByEntryDate(entryDate)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/departure_date")
  public ResponseEntity<TravelLocation> getByDepartureDate(@PathVariable("date") Date departureDate) {
    return locationService.getByDepartureDate(departureDate)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/address/{address}")
  public ResponseEntity<TravelLocation> getByAddress(@PathVariable("address") String address) {
    return locationService.getByAddress(address)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/entity_type/{type}")
  public ResponseEntity<List<TravelLocation>> getByEntityType(@PathVariable("type") String type) {
    return locationService.getByEntityType(type)
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @PostMapping("/save")
  public ResponseEntity<TravelLocation> save(@RequestBody TravelLocation travelLocation) {
    return new ResponseEntity<>(locationService.save(travelLocation), HttpStatus.CREATED);
  }

  @PostMapping("/update")
  public ResponseEntity<TravelLocation> update(@RequestBody TravelLocation locationModified) {
    return locationService.update(locationModified)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.FORBIDDEN));
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int locationId) {
    if (locationService.delete(locationId)) return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
