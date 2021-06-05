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

  public Optional<List<Note>> getTargetNotes(int entityId) {
    return noteRepository.getTargetNotes(entityId);
  }

  public Optional<List<Note>> getNotesByDate(Date createDate) {
    return noteRepository.getNotesByDate(createDate);
  }

  public Optional<List<Note>> getTargetTypeNotes(String targetType) {
    return noteRepository.getNotesByTargetType(targetType);
  }

  public Note save(Note note) {
    return noteRepository.save(note);
  }

  public Optional<Note> update(Note noteModified) {
    boolean noteFound = noteRepository.getNote(noteModified.getId())
            .map(noteUpdated -> {
              if (noteUpdated.getUserId() == noteModified.getUserId()) return true;
              return false;
            })
            .orElse(false);
    if (noteFound) {
      return Optional.ofNullable(noteRepository.save(noteModified));
    };
    return Optional.empty();
  }

  public boolean delete(int noteId) {
    return getNote(noteId).map(note -> {
      noteRepository.delete(noteId);
      return true;
    }).orElse(false);
  }
}
