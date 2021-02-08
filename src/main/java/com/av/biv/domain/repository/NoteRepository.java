package com.av.biv.domain.repository;

import com.av.biv.domain.Note;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface NoteRepository {
  List<Note> getAll();
  Optional<Note> getNote(int noteId);
  Optional<List<Note>> getUserNotes(int userId);
  Optional<List<Note>> getTargetNotes(int entityId);
  Optional<List<Note>> getNotesByDate(Date createDate);
  Note save(Note note);
  void delete(int noteId);
}
