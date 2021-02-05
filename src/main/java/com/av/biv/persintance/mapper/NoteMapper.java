package com.av.biv.persintance.mapper;

import com.av.biv.domain.Note;
import com.av.biv.domain.Travel;
import com.av.biv.persintance.entity.NoteEntity;
import com.av.biv.persintance.entity.TravelEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {
  Note toNote(NoteEntity note);

  List<Note> toNotes(List<NoteEntity> notes);

  @InheritInverseConfiguration
  NoteEntity toNoteEntity(Note note);

  @InheritInverseConfiguration
  List<NoteEntity> toNotesEntity(List<Note> notes);
}
