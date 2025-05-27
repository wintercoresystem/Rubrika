package org.example.dtos;

import org.example.entities.Note;
import org.example.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteMapper {
    @Autowired
    TopicService topicService;

    public Note toEntity(NoteDTO dto) {
        return Note.builder()
                .id(dto.getNoteId())
                .title(dto.getTitle())
                .text(dto.getText())
                .topic(topicService.getTopicById(1L, dto.getTopicId())) // TODO: Maybe should remove userid?
                .build();
    }

    public NoteDTO toDto(Note note) {
        return NoteDTO.builder()
                .noteId(note.getId())
                .title(note.getTitle())
                .text(note.getText())
                .date(note.getDate())
                .topicId(note.getTopic().getId())
                .topicTitle(note.getTopic().getTitle())
                .wordCount(note.getText().chars().filter(spaces -> spaces == ' ').count())
                .build();
    }

    public List<Note> toEntities(List<NoteDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }


    public List<NoteDTO> toDtos(List<Note> notes) {
        return notes.stream()
                .map(this::toDto)
                .toList();
    }
}
