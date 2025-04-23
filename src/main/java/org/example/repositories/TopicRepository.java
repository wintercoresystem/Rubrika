package org.example.repositories;

import org.example.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t FROM Topic t WHERE t.user.id = :userId ORDER BY title")
    public List<Topic> getUserTopicsOrderByName(@Param("userId") Long userId);

}
