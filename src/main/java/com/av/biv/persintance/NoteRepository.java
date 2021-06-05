package com.av.biv.persintance;

import com.av.biv.domain.Note;
import com.av.biv.persintance.crud.NoteCrudRepository;
import com.av.biv.persintance.entity.NoteEntity;
import com.av.biv.persintance.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository implements com.av.biv.domain.repository.NoteRepository {
  @Autowired
  private NoteMapper noteMapper;
  @Autowired
  private NoteCrudRepository noteCrudRepository;

  @Override
  public List<Note> getAll() {
    return noteMapper.toNotes((List<NoteEntity>) noteCrudRepository.findAll());
  }

  @Override
  public Optional<Note> getNote(int noteId) {
    return noteCrudRepository.findById(noteId).map(note -> noteMapper.toNote(note));
  }

  @Override
  public Optional<List<Note>> getUserNotes(int userId) {
    return noteCrudRepository.findByUserId(userId).map(notes -> noteMapper.toNotes(notes));
  }

  @Override
  public Optional<List<Note>> getTargetNotes(int entityId) {
    return noteCrudRepository.findByTargetId(entityId).map(notes -> noteMapper.toNotes(notes));
  }

  @Override
  public Optional<List<Note>> getNotesByDate(Date createDate) {
    return noteCrudRepository.findByCreateDate(createDate).map(notes -> noteMapper.toNotes(notes));
  }

  @Override
  public Optional<List<Note>> getNotesByTargetType(String entityType) {
    return noteCrudRepository.findByTargetType(entityType).map(notes -> noteMapper.toNotes(notes));
  }

  @Override
  public Note save(Note note) {
    NoteEntity noteEntity = noteMapper.toNoteEntity(note);
    return noteMapper.toNote(noteCrudRepository.save(noteEntity));
  }

  @Override
  public void delete(int noteId) {
    noteCrudRepository.deleteById(noteId);
  }
}
