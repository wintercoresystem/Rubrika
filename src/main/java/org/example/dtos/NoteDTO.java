package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.entities.Note;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class NoteDTO {
    private Long noteId;
    private String title;
    private String text;
    private Date date;
    private Long topicId;
    private String topicTitle;

    public NoteDTO(Note noteEntity) {
        this.noteId = noteEntity.getId();
        this.title = noteEntity.getTitle();
        this.text = noteEntity.getText();
        this.date = noteEntity.getDate();
        this.topicId = noteEntity.getTopic().getId();
        this.topicTitle = noteEntity.getTopic().getTitle();
    }
}
