package com.av.biv.domain.repository;

import com.av.biv.domain.Note;
import com.av.biv.persintance.entity.NoteEntity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface NoteRepository {
  List<Note> getAll();
  Optional<Note> getNote(int noteId);
  Optional<List<Note>> getUserNotes(int userId);
  Optional<List<Note>> getTargetNotes(int entityId);
  Optional<List<Note>> getNotesByDate(Date createDate);
  Optional<List<Note>> getNotesByTargetType(String entityType);
  Optional<List<Note>> getByTargetTypeAndUserId(String entityType, int userId);
  Note save(Note note);
  void delete(int noteId);
}
