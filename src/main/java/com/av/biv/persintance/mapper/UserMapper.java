package com.av.biv.persintance.mapper;

import com.av.biv.domain.User;
import com.av.biv.persintance.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = TravelMapper.class)
public interface UserMapper {

  @Mapping(source = "userTravels", target = "userTravels")
  User toUser(UserEntity user);

  List<User> toUsers(List<UserEntity> users);

  @InheritInverseConfiguration
  UserEntity toUserEntity(User user);

  @InheritInverseConfiguration
  List<UserEntity> toUsersEntity(List<User> users);
}
