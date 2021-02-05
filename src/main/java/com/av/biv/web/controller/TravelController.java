package com.av.biv.web.controller;

import com.av.biv.domain.Travel;
import com.av.biv.domain.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelController {
  @Autowired
  private TravelService travelService;

  @GetMapping("/all/{id}")
  public List<Travel> getUserTravels(@PathVariable("id") int userId) {
    return travelService.getUserTravels(userId);
  }
}
