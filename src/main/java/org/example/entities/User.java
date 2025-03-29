package org.example.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column()
    private String settings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Topic> topics = new HashSet<>();

    public User() {
    }

    public User(Long id, String email, String password, String settings, Set<Topic> topics) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.settings = settings;
        this.topics = topics;
    }
}
