package com.av.biv.web.controller;

import com.av.biv.domain.User;
import com.av.biv.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public List<User> getAllUsers() {
    return userService.getAll();
  };

  @GetMapping("/id/{id}")
  public Optional<User> getUser(@PathVariable("id") int userId) {
    return userService.getUser(userId);
  };

  @GetMapping("/name/{name}")
  public Optional<List<User>> getByName(@PathVariable String name) {
    return userService.getByName(name);
  };

  @GetMapping("/email/{email}")
  public Optional<User> getByEmail(@PathVariable String email) {
    return userService.getByEmail(email);
  };

  @PostMapping("/save")
  public User save(@RequestBody User user) {
    return userService.save(user);
  };

  @PostMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int userId) {
    return userService.delete(userId);
  };

}
