package org.example.services;

import org.example.entities.Note;
import org.example.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getNotesByTopicId(Long topicId) {
        return noteRepository.getNotesByTopicId(topicId);
    }

    public List<Note> getNotesByUserId(Long userId) {
        return noteRepository.getNotesByUserId(userId);
    }

    public void saveNote(Note note) {
        // TODO: add validation on topicId later
        noteRepository.save(note);
    }

    public void removeNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
