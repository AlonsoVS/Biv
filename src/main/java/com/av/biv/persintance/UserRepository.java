package com.av.biv.persintance;

import com.av.biv.domain.User;
import com.av.biv.persintance.crud.UserCrudRepository;
import com.av.biv.persintance.entity.UserEntity;
import com.av.biv.persintance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements com.av.biv.domain.repository.UserRepository {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private UserCrudRepository userCrudRepository;

  @Override
  public List<User> getAll() {
    List<UserEntity> users = (List<UserEntity>) userCrudRepository.findAll();
    return userMapper.toUsers(users);
  }

  @Override
  public Optional<User> getUser(int userId) {
    return userCrudRepository.findById(userId).map(user -> userMapper.toUser(user));
  }

  @Override
  public Optional<List<User>> getByName(String name) {
    Optional<List<UserEntity>> users = userCrudRepository.findByName(name);
    return users.map(userList -> userMapper.toUsers(userList));
  }

  @Override
  public Optional<User> getByEmail(String email) {
    return userCrudRepository.findByEmail(email).map(user -> userMapper.toUser(user));
  }

  @Override
  public User save(User user) {
    UserEntity savedUser = userMapper.toUserEntity(user);
    return userMapper.toUser(userCrudRepository.save(savedUser));
  }

  @Override
  public void delete(int userId) {
    userCrudRepository.deleteById(userId);
  }
}
