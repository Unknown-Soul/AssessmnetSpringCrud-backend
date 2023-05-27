package com.assestutorial.assestutorial.repository;

import com.assestutorial.assestutorial.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findAll();
    List<Tutorial> findByTitleContaining(String title);
}
