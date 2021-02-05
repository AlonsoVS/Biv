package com.av.biv.domain.service;

import com.av.biv.domain.Note;
import com.av.biv.domain.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
  @Autowired
  private NoteRepository noteRepository;

  public List<Note> getAllNotes() {
    return noteRepository.getAll();
  }

  public Optional<Note> getNote(int noteId) {
    return noteRepository.getNote(noteId);
  }

  public Optional<List<Note>> getUserNotes(int userId) {
    return noteRepository.getUserNotes(userId);
  }

  public Optional<Note> getEntityNotes(int entityId) {
    return noteRepository.getEntityNotes(entityId);
  }

  public Optional<List<Note>> getNotesByDate(Date createDate) {
    return noteRepository.getNotesByDate(createDate);
  }

  public Note save(Note note) {
    return noteRepository.save(note);
  }

  public boolean delete(int noteId) {
    return getNote(noteId).map(note -> {
      noteRepository.delete(noteId);
      return true;
    }).orElse(false);
  }
}
