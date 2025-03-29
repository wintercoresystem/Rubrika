package org.example.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Topic {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "topic_id")
    private Set<Note> notes = new HashSet<>();

    public Topic() {
    }

    public Topic(Long id, String title, Set<Note> notes) {
        this.id = id;
        this.title = title;
        this.notes = notes;
    }
}