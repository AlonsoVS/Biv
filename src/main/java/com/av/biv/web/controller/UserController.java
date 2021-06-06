package com.av.biv.web.controller;

import com.av.biv.domain.User;
import com.av.biv.domain.service.UserService;
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
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/all")
  @ApiOperation("Get all Users in the database")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  };

  @GetMapping("/id/{id}")
  @ApiOperation("Search User by Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "User Not Found")
  })
  public ResponseEntity<User> getUser(@ApiParam(value = "Id of User to search", required = true, example = "20")
                                        @PathVariable("id") int userId) {
    return userService.getUser(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  };

  @GetMapping("/uuid/{id}")
  @ApiOperation("Search User by UUID")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "User Not Found")
  })
  public ResponseEntity<User> getUserByUUID(@ApiParam(value = "UUID of user to search", required = true,
                                                      example = "ed2973a9-829b-4d96-a855-3ba6e9215d36")
                                              @PathVariable("id") String userId) {
    return userService.getUserByUUID(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/name/{name}")
  @ApiOperation("Search User by name")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Name Bad Request")
  })
  public ResponseEntity<List<User>> getByName(@ApiParam(value = "Name of user to search", required = true,
                                                        example = "Jhon")
                                                @PathVariable String name) {
    return userService.getByName(name).map(users -> new ResponseEntity(users, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.BAD_REQUEST));
  };

  @GetMapping("/email/{email}")
  @ApiOperation("Search User by Email address")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "User Not Found")
  })
  public ResponseEntity<User> getByEmail(@ApiParam(value = "Email address of user to search", required = true,
                                                    example = "jhondoe@example.com")
                                         @PathVariable String email) {
    return userService.getByEmail(email).map(user -> new ResponseEntity(user, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  };

  @PostMapping("/save")
  @ApiOperation("Save a User")
  @ApiResponse(code = 201, message = "User Created")
  public ResponseEntity<User> save(@ApiParam(value = "User Json Object", required = true,
                                              example= "{" +
                                                      "\"birthDate\": \"string\"," +
                                                      "\"email\": \"string\"," +
                                                      "\"lastName\": \"string\"," +
                                                      "\"name\": \"string\"," +
                                                      "\"password\": \"string\"," +
                                                      "\"username\": \"string\"" +
                                                      "}")
                                     @RequestBody User user) {
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  };

  @PostMapping("/update")
  @ApiOperation("Edit a User")
  @ApiResponse(code = 304, message = "User Not Modified")
  public ResponseEntity<User> update(@ApiParam(value = "User Json Object", required = true,
                                                example= "{" +
                                                        "\"birthDate\": \"string\"," +
                                                        "\"id\": 0," +
                                                        "\"email\": \"string\"," +
                                                        "\"lastName\": \"string\"," +
                                                        "\"name\": \"string\"," +
                                                        "\"password\": \"string\"," +
                                                        "\"username\": \"string\"" +
                                                        "}")
                                       @RequestBody User userModified) {
    return userService.update(userModified).map(userUpdated -> new ResponseEntity(userUpdated, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_MODIFIED));
  };

  @PostMapping("/delete/{id}")
  @ApiOperation("Delete User with given Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 403, message = "Delete User Forbidden")
  })
  public ResponseEntity delete(@PathVariable("id") int userId) {
    if (userService.delete(userId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  };

}
