package com.av.biv.web.controller;

import com.av.biv.domain.Note;
import com.av.biv.domain.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<Note>> getAllNotes() {
    return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Note> getNote(@PathVariable("id") int noteId) {
    return noteService.getNote(noteId).map(note -> new ResponseEntity<>(note, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<Note>> getUserNotes(@PathVariable("id") int userId) {
    return noteService.getUserNotes(userId)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/target/id/{id}")
  public ResponseEntity<List<Note>> getTargetNotes(@PathVariable("id") int entityId) {
    return noteService.getTargetNotes(entityId)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/target/type/{type}")
  public ResponseEntity<List<Note>> getNotesOfTargetType(@PathVariable("type") String targetType) {
    return noteService.getTargetTypeNotes(targetType)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/date/{date}")
  public ResponseEntity<List<Note>> getNotesByDate(@PathVariable("date") Date createDate) {
    return noteService.getNotesByDate(createDate)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @PostMapping("/save")
  public ResponseEntity<Note> save(@RequestBody Note note) {
    return new ResponseEntity<>(noteService.save(note), HttpStatus.OK);
  }

  @PostMapping("/edit")
  public ResponseEntity<Note> update(@RequestBody Note noteModified) {
   return noteService.update(noteModified).map(noteUpdated -> new ResponseEntity<>(noteUpdated, HttpStatus.OK))
           .orElse(new ResponseEntity<>(HttpStatus.FORBIDDEN));
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int noteId) {
    if (noteService.delete(noteId)) return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
