package org.example;

import org.example.entities.Note;
import org.example.entities.Topic;
import org.example.entities.User;
import org.example.repositories.NoteRepository;
import org.example.services.NoteService;
import org.example.services.TopicService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String mainPage(Model model) {
        User user = userService.getUserById(1L);
        List<Topic> topics = topicService.getUserTopics(1L);
        List<Note> notes = noteService.getNotesByUserId(1L);

        model.addAttribute("user", user);
        model.addAttribute("topics", topics);
        model.addAttribute("notes", notes);

        return "index";
    }


    @GetMapping("/{topicId}")
    public String mainPage(Model model, @PathVariable("topicId") Long topicId) {
        User user = userService.getUserById(1L);
        List<Topic> topics = topicService.getUserTopics(1L);
        Topic currentTopic = topicService.getTopicById(1L, topicId);
        List<Note> notes = noteService.getNotesByTopicId(topicId);


        model.addAttribute("currentTopic", currentTopic);
        model.addAttribute("user", user);
        model.addAttribute("topics", topics);
        model.addAttribute("notes", notes);

        return "index";
    }
}
