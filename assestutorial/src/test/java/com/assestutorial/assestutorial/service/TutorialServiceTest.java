package com.assestutorial.assestutorial.service;

import com.assestutorial.assestutorial.dto.TutorialDTO;
import com.assestutorial.assestutorial.entity.Tutorial;
import com.assestutorial.assestutorial.repository.TutorialRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class TutorialServiceTest {

    @Mock
    TutorialRepository tutorialRepository;

    @Autowired
    TutorialService tutorialService;


    // to mock the repo in tutorialService.
    @BeforeEach
    void setTutorialRepository(){
        this.tutorialService = new TutorialService(this.tutorialRepository);
    }

    @Test
    void getAllTutorials() {
        ResponseEntity<List<Tutorial>> result = tutorialService.getAllTutorials("Java");
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

    @Test
    void createTutorial() {
        TutorialDTO tutorialDTO = new TutorialDTO();
        tutorialDTO.setDescription(null);
        tutorialDTO.setDescription(null);
        ResponseEntity<Tutorial> result = tutorialService.createTutorial(tutorialDTO);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    void getTutorialById() {
        ResponseEntity<Tutorial> result = tutorialService.getTutorialById(11l);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    //test our db and service return same data
    @Test
    void getAllTutorialsRepoTest(){
        tutorialService.getAllTutorials(null);
        verify(tutorialRepository).findAll();
    }


}
