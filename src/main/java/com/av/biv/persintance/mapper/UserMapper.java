package com.av.biv.persintance.mapper;

import com.av.biv.domain.User;
import com.av.biv.persintance.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TravelMapper.class, NoteMapper.class})
public interface UserMapper {

  @Mappings({
          @Mapping(source = "travels", target = "travels"),
          @Mapping(source = "notes", target = "notes")
  })
  User toUser(UserEntity user);

  List<User> toUsers(List<UserEntity> users);

  @InheritInverseConfiguration
  UserEntity toUserEntity(User user);

  @InheritInverseConfiguration
  List<UserEntity> toUsersEntity(List<User> users);
}
