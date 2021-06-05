package com.av.biv.persintance.crud;

import com.av.biv.persintance.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface NoteCrudRepository extends CrudRepository<NoteEntity, Integer> {
  Optional<List<NoteEntity>> findByUserId(int userId);
  Optional<List<NoteEntity>> findByTargetId(int entityId);
  Optional<List<NoteEntity>> findByCreateDate(Date createDate);
  Optional<List<NoteEntity>> findByTargetType(String entityType);
  Optional<List<NoteEntity>> findByTargetTypeAndUserId(String entityType, int userId);
}
