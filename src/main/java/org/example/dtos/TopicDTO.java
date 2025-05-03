package org.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TopicDTO {
    private String topicTitle;
    private Long topicId;
}
