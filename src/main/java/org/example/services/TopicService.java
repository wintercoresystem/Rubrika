package org.example.services;

import org.example.entities.Topic;
import org.example.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getUserTopics(Long userId) {
        return topicRepository.getUserTopicsOrderByName(userId);
    }

    public Topic getTopicById(Long userId, Long topicId) { // TODO: userId here is for validation?
        return topicRepository
                .findById(topicId).orElseThrow(() -> new IllegalArgumentException("Topic not found"));

    }
}
