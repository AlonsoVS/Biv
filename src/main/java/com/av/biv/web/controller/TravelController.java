package com.av.biv.web.controller;

import com.av.biv.domain.Travel;
import com.av.biv.domain.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelController {
  @Autowired
  private TravelService travelService;

  @GetMapping("/all")
  public ResponseEntity<List<Travel>> getAll() {
    return new ResponseEntity<>(travelService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<Travel>> getUserTravels(@PathVariable("id") int userId) {
    return travelService.getUserTravels(userId)
            .map(travels -> new ResponseEntity<>(travels, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Travel> getTravel(@PathVariable("id") int travelId){
    return travelService.getTravel(travelId)
            .map(travel -> new ResponseEntity<>(travel, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/uuid_id/{id}")
  public ResponseEntity<List<Travel>> getTravelsByUserUUIDId(@PathVariable("id") String id) {
    return travelService.getTravelsByUserUUIDId(id)
            .map(travels -> new ResponseEntity<>(travels, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/entity_type/{type}")
  public ResponseEntity<List<Travel>> getTravelsByEntityType(@PathVariable("type") String type) {
    return travelService.getTravelsByEntityType(type)
            .map(travels -> new ResponseEntity<>(travels, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @PostMapping("/save")
  public ResponseEntity<Travel> save(@RequestBody Travel travel) {
    return new ResponseEntity<>(travelService.save(travel), HttpStatus.OK);
  }

  @PostMapping("/update")
  public ResponseEntity<Travel> update(@RequestBody Travel travelModified) {
    return travelService.update(travelModified)
            .map(travel -> new ResponseEntity<>(travel, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.FORBIDDEN));
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int travelId) {
    if (travelService.delete(travelId)) return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
