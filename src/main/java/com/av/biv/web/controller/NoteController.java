package com.av.biv.web.controller;

import com.av.biv.domain.Note;
import com.av.biv.domain.service.NoteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
  @Autowired
  private NoteService noteService;

  @GetMapping("/all")
  @ApiOperation("Get all Notes in the database")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<List<Note>> getAllNotes() {
    return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ApiOperation("Search Note by Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "Note Not Found")
  })
  public ResponseEntity<Note> getNote(@ApiParam(value = "Id of Note to search", required = true, example = "3")
                                        @PathVariable("id") int noteId) {
    return noteService.getNote(noteId).map(note -> new ResponseEntity<>(note, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/user/{id}")
  @ApiOperation("Search Notes of User")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "User Bad Request")
  })
  public ResponseEntity<List<Note>> getUserNotes(@ApiParam(value = "Id of User to search Notes", required = true, example = "20")
                                                   @PathVariable("id") int userId) {
    return noteService.getUserNotes(userId)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/target/id/{id}")
  @ApiOperation("Search Notes of Target Entity by Entity Id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Target Entity Bad Request")
  })
  public ResponseEntity<List<Note>> getTargetNotes(@ApiParam(value = "Id of Target Entity to search Notes", required = true, example = "4")
                                                     @PathVariable("id") int entityId) {
    return noteService.getTargetNotes(entityId)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/target/type/{type}")
  @ApiOperation("Search Notes of Target Entity by Entity Type")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Target Entity Bad Request")
  })
  public ResponseEntity<List<Note>> getNotesOfTargetType(@ApiParam(value = "Type of Target Entity to search Notes", required = true, example = "travel")
                                                           @PathVariable("type") String targetType) {
    return noteService.getTargetTypeNotes(targetType)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @GetMapping("/date/{date}")
  @ApiOperation("Search Notes by Created Date")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Date Bad Request")
  })
  public ResponseEntity<List<Note>> getNotesByDate(@ApiParam(value = "Created Date to search Notes", required = true, example = "2005-02-12")
                                                     @PathVariable("date") Date createDate) {
    return noteService.getNotesByDate(createDate)
            .map(notes -> new ResponseEntity<>(notes, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

  @PostMapping("/save")
  @ApiOperation("Save a Note")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<Note> save(@ApiParam(value = "Note to Save Json Object", required = true,
                                              example= "{" +
                                                          "\"content\": \"string\"," +
                                                          "\"targetId\": 0," +
                                                          "\"targetType\": \"string\"," +
                                                          "\"userId\": 0" +
                                                        "}")
                                     @RequestBody Note note) {
    return new ResponseEntity<>(noteService.save(note), HttpStatus.OK);
  }

  @PostMapping("/edit")
  @ApiOperation("Edit a Note")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 403, message = "Edit Note Forbidden")
  })
  public ResponseEntity<Note> update(@ApiParam(value = "Note to Edit Json Object", required = true,
                                                example= "{" +
                                                        "\"content\": \"string\"," +
                                                        "\"createDate\": \"string\"," +
                                                        "\"id\": 0," +
                                                        "\"targetId\": 0," +
                                                        "\"targetType\": \"string\"" +
                                                        "}")
                                       @RequestBody Note noteModified) {
   return noteService.update(noteModified).map(noteUpdated -> new ResponseEntity<>(noteUpdated, HttpStatus.OK))
           .orElse(new ResponseEntity<>(HttpStatus.FORBIDDEN));
  }

  @PostMapping("/delete/{id}")
  @ApiOperation("Delete a Note")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 403, message = "Delete Note Forbidden")
  })
  public ResponseEntity delete(@ApiParam(value = "Note Id to Delete", required = true, example = "4")
                                 @PathVariable("id") int noteId) {
    if (noteService.delete(noteId)) return new ResponseEntity<>(HttpStatus.OK);
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
