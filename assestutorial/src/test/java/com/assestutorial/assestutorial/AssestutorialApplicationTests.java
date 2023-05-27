package com.assestutorial.assestutorial;

import com.assestutorial.assestutorial.dto.TutorialDTO;
import com.assestutorial.assestutorial.entity.Tutorial;
import com.assestutorial.assestutorial.service.TutorialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AssestutorialApplicationTests {

    @Autowired
    TutorialService tutorialService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveTutorial() {
        TutorialDTO tutorialDTO = new TutorialDTO();
        tutorialDTO.setDescription(null);
        tutorialDTO.setDescription(null);
        ResponseEntity<Tutorial> result = tutorialService.createTutorial(tutorialDTO);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }




    @Test
    void testGetAllTutorials() {
        ResponseEntity<List<Tutorial>> result = tutorialService.getAllTutorials("Java");
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}
