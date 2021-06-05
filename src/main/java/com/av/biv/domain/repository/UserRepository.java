package com.av.biv.domain.repository;

import com.av.biv.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  List<User> getAll();

  Optional<User> getUser(int userId);

  Optional<List<User>> getByName(String name);

  Optional<User> getByEmail(String email);

  Optional<User> getByEntityType(String entityType);

  User save(User user);

  void delete(int userId);
}
