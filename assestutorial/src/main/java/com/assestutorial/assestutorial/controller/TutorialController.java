package com.assestutorial.assestutorial.controller;

import com.assestutorial.assestutorial.dto.TutorialDTO;
import com.assestutorial.assestutorial.entity.Tutorial;
import com.assestutorial.assestutorial.repository.TutorialRepository;
import com.assestutorial.assestutorial.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        return tutorialService.getAllTutorials(title);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return tutorialService.getTutorialById(id);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody TutorialDTO tutorial) {
        return tutorialService.createTutorial(tutorial);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        return tutorialService.updateTutorial(id, tutorial);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        return tutorialService.deleteTutorial(id);
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        return tutorialService.deleteAllTutorials();
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        return tutorialService.findByPublished();
    }
}
