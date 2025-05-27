package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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
    private Long wordCount;
}
