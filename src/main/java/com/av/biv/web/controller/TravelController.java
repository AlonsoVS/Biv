package com.av.biv.web.controller;

import com.av.biv.domain.Travel;
import com.av.biv.domain.service.TravelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
  @ApiOperation("Get all Travels in the database")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<List<Travel>> getAll() {
    return new ResponseEntity<>(travelService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  @ApiOperation("Search Travel by Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "Travel Not Found")
  })
  public ResponseEntity<Travel> getTravel(@ApiParam(value = "Id of Travel to search", required = true, example = "7")
                                            @PathVariable("id") int travelId){
    return travelService.getTravel(travelId)
            .map(travel -> new ResponseEntity<>(travel, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/user/{id}")
  @ApiOperation("Search Travels of User by User Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "User Bad Request")
  })
  public ResponseEntity<List<Travel>> getUserTravels(@ApiParam(value = "Id of User to search Travels", required = true, example = "20")
                                                       @PathVariable("id") int userId) {
    return travelService.getUserTravels(userId)
            .map(travels -> new ResponseEntity<>(travels, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/user/uuid_id/{id}")
  @ApiOperation("Search Travels of User by User UUID")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "User Bad Request")
  })
  public ResponseEntity<List<Travel>> getTravelsByUserUUIDId(@ApiParam(value = "UUID of User to search Travels", required = true,
                                                                        example = "ed2973a9-829b-4d96-a855-3ba6e9215d36")
                                                               @PathVariable("id") String id) {
    return travelService.getTravelsByUserUUIDId(id)
            .map(travels -> new ResponseEntity<>(travels, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/entity-type/{type}")
  @ApiOperation("Search Travels by Entity Type")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Entity Bad Request")
  })
  public ResponseEntity<List<Travel>> getTravelsByEntityType(@ApiParam(value = "Travel Entity Type", required = true, example = "travel")
                                                               @PathVariable("type") String type) {
    return travelService.getTravelsByEntityType(type)
            .map(travels -> new ResponseEntity<>(travels, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @PostMapping("/save")
  @ApiOperation("Save a Travel")
  @ApiResponse(code = 201, message = "Travel Created")
  public ResponseEntity<Travel> save(@ApiParam(value = "Travel to Save Json Object", required = true,
                                                example= "{" +
                                                            "\"description\": \"string\"," +
                                                            "\"generalLocation\": \"string\"," +
                                                            "\"status\": true," +
                                                            "\"userId\": 0," +
                                                            "\"userUUIDId\": string" +
                                                          "}")
                                       @RequestBody Travel travel) {
    return new ResponseEntity<>(travelService.save(travel), HttpStatus.CREATED);
  }

  @PostMapping("/update")
  @ApiOperation("Edit a Travel")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 403, message = "Edit Travel Forbidden")
  })
  public ResponseEntity<Travel> update(@ApiParam(value = "Travel Edited Json Object", required = true,
                                                  example= "{" +
                                                          "\"description\": \"string\"," +
                                                          "\"generalLocation\": \"string\"," +
                                                          "\"id\": 0," +
                                                          "\"status\": true," +
                                                          "\"userId\": 0," +
                                                          "\"userUUIDId\": string" +
                                                          "}")
                                         @RequestBody Travel travelModified) {
    return travelService.update(travelModified)
            .map(travel -> new ResponseEntity<>(travel, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.FORBIDDEN));
  }

  @PostMapping("/delete/{id}")
  @ApiOperation("Edit a Travel")
  @ApiResponses({
          @ApiResponse(code = 200, message = "Travel Created"),
          @ApiResponse(code = 403, message = "Delete Travel Forbidden")
  })
  public ResponseEntity delete(@ApiParam(value = "Travel Id to Delete", required = true, example = "7") @PathVariable("id") int travelId) {
    if (travelService.delete(travelId)) return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
