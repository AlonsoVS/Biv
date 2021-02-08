package com.av.biv.web.controller;

import com.av.biv.domain.Note;
import com.av.biv.domain.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {
  @Autowired
  private NoteService noteService;

  @GetMapping("/all")
  public List<Note> getAllNotes() {
    return noteService.getAllNotes();
  }

  @GetMapping("/{id}")
  public Optional<Note> getNote(@PathVariable("id") int noteId) {
    return noteService.getNote(noteId);
  }

  @GetMapping("/user/{id}")
  public Optional<List<Note>> getUserNotes(@PathVariable("id") int userId) {
    return noteService.getUserNotes(userId);
  }

  @GetMapping("/target/{id}")
  public Optional<List<Note>> getTargetNotes(@PathVariable("id") int entityId) {
    return noteService.getTargetNotes(entityId);
  }

  @GetMapping("/date/{date}")
  public Optional<List<Note>> getNotesByDate(@PathVariable("date") Date createDate) {
    return noteService.getNotesByDate(createDate);
  }

  @PostMapping("/save")
  public Note save(@RequestBody Note note) {
    return noteService.save(note);
  }

  @PostMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int noteId) {
    return noteService.delete(noteId);
  }
}
