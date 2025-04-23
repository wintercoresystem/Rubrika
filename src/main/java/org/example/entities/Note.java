package org.example.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text", length = 25000)
    private String text;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Note() {
    }

    public Note(Long id, String title, String text, Date date, Topic topic) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

