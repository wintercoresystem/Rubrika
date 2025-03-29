package org.example;

import org.example.entities.Note;
import org.example.entities.Topic;
import org.example.entities.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage(Model model) {

        User user = userService.getUserById(Long.parseLong("1"));
        Set<Topic> topics = user.getTopics();
        Set<Note> notes = user.getAllNotes();
        model.addAttribute("topics", topics);
        model.addAttribute("notes", notes);

        return "index";
    }
}
