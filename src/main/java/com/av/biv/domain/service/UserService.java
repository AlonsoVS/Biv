package com.av.biv.domain.service;

import com.av.biv.domain.User;
import com.av.biv.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAll() {
    return userRepository.getAll();
  }

  public Optional<User> getUser(int userId) {
    return userRepository.getUser(userId);
  }

  public Optional<User> getUserByUUID(String userId) {
    return userRepository.getUserByUUID(UUID.fromString(userId));
  }

  public Optional<List<User>> getByName(String name) {
    return userRepository.getByName(name);
  }

  public Optional<User> getByEmail(String email) {
    return userRepository.getByEmail(email);
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public Optional<User> update(User userModified) {
    boolean userFound = userRepository.getUser(userModified.getId()).map(User -> true).orElse(false);
    if (userFound) {
      return Optional.ofNullable(userRepository.save(userModified));
    }
    return  Optional.empty();
  }

  public boolean delete(int userId) {
    return getUser(userId).map(user -> {
      userRepository.delete(userId);
      return true;
    }).orElse(false);
  }
}
