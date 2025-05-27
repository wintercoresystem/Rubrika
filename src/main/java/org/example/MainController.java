package org.example;

import org.example.dtos.NoteMapper;
import org.example.dtos.TopicDTO;
import org.example.dtos.TopicMapper;
import org.example.entities.Note;
import org.example.entities.Topic;
import org.example.entities.User;
import org.example.services.NoteService;
import org.example.services.TopicService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private NoteService noteService;

    private TopicMapper topicMapper =  new TopicMapper();
    private NoteMapper noteMapper =  new NoteMapper();

    @GetMapping("/")
    public String mainPage(Model model) {
        User user = userService.getUserById(1L);
        List<Topic> topics = topicService.getUserTopics(1L);
        List<Note> notes = noteService.getNotesByUserId(1L);


        model.addAttribute("currentTopic", null);
        model.addAttribute("user", user);
        model.addAttribute("topics", topicMapper.toDtos(topics));
        model.addAttribute("notes", noteMapper.toDtos(notes));

        return "index";
    }


    @GetMapping("/{topicId}")
    public String mainPage(Model model,
                           @PathVariable("topicId") Long topicId) {
        User user = userService.getUserById(1L);
        List<Topic> topics = topicService.getUserTopics(1L);
        TopicDTO currentTopic = topicMapper.toDto(topicService.getTopicById(1L, topicId));
        List<Note> notes = noteService.getNotesByTopicId(topicId);


        model.addAttribute("currentTopic", currentTopic);
        model.addAttribute("user", user);
        model.addAttribute("topics", topicMapper.toDtos(topics));
        model.addAttribute("notes", noteMapper.toDtos(notes));

        return "index";
    }


    @PostMapping("/{topicId}")
    public String createNote(@PathVariable("topicId") Long topicId,
                            @RequestParam("title") String title, // TODO: Maybe change to empty dto and th:object?
                            @RequestParam("text") String text) {

        Note newNote = Note.builder()
                .topic(topicService.getTopicById(1L, topicId))
                .date(Date.from(Instant.now()))
                .title(title)
                .text(text)
                .build();

        System.out.println(noteMapper.toDto(newNote)); // TODO: Make proper logging
        noteService.saveNote(newNote);

        return "redirect:/" + topicId;
    }

    @PostMapping("/delete/{noteId}")
    public String removeNote(@PathVariable(value = "noteId") Long noteId) {

        System.out.println(noteId); // TODO: Make proper logging
        noteService.removeNoteById(noteId);

        return "redirect:/";
    }
}
