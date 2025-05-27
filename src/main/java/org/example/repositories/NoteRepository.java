package org.example.repositories;

import org.example.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE n.topic.id = :topicId ORDER BY n.date DESC")
    public List<Note> getNotesByTopicId(@Param("topicId") Long topicId);

    @Query("SELECT n FROM Note n JOIN topic t WHERE  t.user.id = :userId ORDER BY n.date DESC")
    public List<Note> getNotesByUserId(@Param("userId") Long userId);
}
