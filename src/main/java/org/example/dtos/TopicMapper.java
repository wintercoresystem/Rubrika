package org.example.dtos;

import org.example.entities.Topic;
import org.example.services.NoteService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TopicMapper {
    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    public Topic toEntity(TopicDTO dto) {
        return Topic.builder()
                .id(dto.getTopicId())
                .title(dto.getTopicTitle())
                .notes(noteService.getNotesByTopicId(dto.getTopicId()))
                .user(userService.getUserByTopic(dto.getTopicId()))
                .build();
    }


    public TopicDTO toDto(Topic topic) {
        return TopicDTO.builder()
                .topicTitle(topic.getTitle())
                .topicId(topic.getId())
                .build();
    }

    public List<Topic> toEntities(List<TopicDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }


    public List<TopicDTO> toDtos(List<Topic> topics) {
        return topics.stream()
                .map(this::toDto)
                .toList();
    }
}
