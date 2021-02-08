package com.av.biv.web.controller;

import com.av.biv.domain.User;
import com.av.biv.domain.service.UserService;
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
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  };

  @GetMapping("/id/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
    return userService.getUser(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  };

  @GetMapping("/name/{name}")
  public ResponseEntity<List<User>> getByName(@PathVariable String name) {
    return userService.getByName(name).map(users -> new ResponseEntity(users, HttpStatus.OK))
            .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  };

  @GetMapping("/email/{email}")
  public ResponseEntity<User> getByEmail(@PathVariable String email) {
    return userService.getByEmail(email).map(user -> new ResponseEntity(user, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  };

  @PostMapping("/save")
  public ResponseEntity<User> save(@RequestBody User user) {
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  };

  @PostMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int userId) {
    if (userService.delete(userId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  };

}
