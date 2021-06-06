package com.av.biv.web.controller;

import com.av.biv.domain.TravelLocation;
import com.av.biv.domain.service.TravelLocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class TravelLocationController {
  @Autowired
  private TravelLocationService locationService;

  @GetMapping("/all")
  @ApiOperation("Get all Locations in the database")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<List<TravelLocation>> getAll() {
    return new ResponseEntity<>(locationService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  @ApiOperation("Search Location by Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "Location Not Found")
  })
  public ResponseEntity<TravelLocation> getLocation(@ApiParam(value = "Id of Location to search", required = true, example = "4")
                                                      @PathVariable("id") int locationId) {
    return locationService.getLocation(locationId)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/user/{id}")
  @ApiOperation("Search User Locations")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "User Bad Request")
  })
  public ResponseEntity<List<TravelLocation>> getUserLocations(@ApiParam(value = "Id of User to search Locations", required = true, example = "20")
                                                                 @PathVariable("id") int userId) {
    return locationService.getUserLocations(userId)
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/travel/{id}")
  @ApiOperation("Search Travel Locations")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Travel Bad Request")
  })
  public ResponseEntity<List<TravelLocation>> getTravelLocations(@ApiParam(value = "Id of Travel to search Locations", required = true, example = "7")
                                                                   @PathVariable("id") Integer travelId) {
    return locationService.getTravelLocations(travelId)
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/status/active")
  @ApiOperation("Search Active Locations")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Active Bad Request")
  })
  public ResponseEntity<List<TravelLocation>> getActive() {
    return locationService.getActive()
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/status/disabled")
  @ApiOperation("Search Disabled Locations")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Disabled Bad Request")
  })
  public ResponseEntity<List<TravelLocation>> getDisabled() {
    return locationService.getDisabled()
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/entry-date/{date}")
  @ApiOperation("Search Location by Entry Date")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "Location Not Found")
  })
  public ResponseEntity<TravelLocation> getByEntryDate(@ApiParam(value = "Entry Date of Location to search", required = true, example = "2006-05-01")
                                                         @PathVariable("date") Date entryDate) {
    return locationService.getByEntryDate(entryDate)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/departure-date")
  @ApiOperation("Search Location by Departure Date")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "Location Not Found")
  })
  public ResponseEntity<TravelLocation> getByDepartureDate(@ApiParam(value = "Departure Date of Location to search", required = true, example = "2006-05-06")
                                                             @PathVariable("date") Date departureDate) {
    return locationService.getByDepartureDate(departureDate)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/address/{address}")
  @ApiOperation("Search Location by Address")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "Location Not Found")
  })
  public ResponseEntity<TravelLocation> getByAddress(@ApiParam(value = "Address of Location to search", required = true)
                                                       @PathVariable("address") String address) {
    return locationService.getByAddress(address)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/entity-type/{type}")
  @ApiOperation("Search Locations by Entity Type")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Entity Type Bad Request")
  })
  public ResponseEntity<List<TravelLocation>> getByEntityType(@ApiParam(value = "Entity Type of Location to search", required = true, example = "location")
                                                                @PathVariable("type") String type) {
    return locationService.getByEntityType(type)
            .map(locations -> new ResponseEntity<>(locations, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  }

  @PostMapping("/save")
  @ApiOperation("Save a Location")
  @ApiResponse(code = 201, message = "Location Created")
  public ResponseEntity<TravelLocation> save(@ApiParam(value = "Location to Save Json Object", required = true,
                                                        example= "{" +
                                                                    "\"address\": \"string\"," +
                                                                    "\"departureDate\": \"string\"," +
                                                                    "\"entryDate\": \"string\"," +
                                                                    "\"name\": \"string\"," +
                                                                    "\"status\": true," +
                                                                    "\"travelId\": 0," +
                                                                    "\"userId\": 0" +
                                                                  "}")
                                               @RequestBody TravelLocation travelLocation) {
    return new ResponseEntity<>(locationService.save(travelLocation), HttpStatus.CREATED);
  }

  @PostMapping("/update")
  @ApiOperation("Edit a Location")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 403, message = "Edit Location Forbidden")
  })
  public ResponseEntity<TravelLocation> update(@ApiParam(value = "Location to Edit Json Object", required = true,
                                                          example= "{" +
                                                                  "\"address\": \"string\"," +
                                                                  "\"departureDate\": \"string\"," +
                                                                  "\"entryDate\": \"string\"," +
                                                                  "\"id\": 0," +
                                                                  "\"name\": \"string\"," +
                                                                  "\"status\": true," +
                                                                  "\"travelId\": 0," +
                                                                  "}")
                                                 @RequestBody TravelLocation locationModified) {
    return locationService.update(locationModified)
            .map(location -> new ResponseEntity<>(location, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.FORBIDDEN));
  }

  @PostMapping("/delete/{id}")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 403, message = "Delete Location Forbidden")
  })
  public ResponseEntity delete(@ApiParam(value = "Id of Location to Delete", required = true, example = "4")
                                 @PathVariable("id") int locationId) {
    if (locationService.delete(locationId)) return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
