package com.example.gestioncvback.Controllers.Personne.Cv;

import com.example.gestioncvback.Models.Personne.Experience;
import com.example.gestioncvback.Services.Experiences.ExperienceServices;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceControllers {

    @Autowired
    private ExperienceServices experienceService;

    @PostMapping("/add")
    public ResponseEntity<Result> addExperience(@RequestBody Experience experience) {
        try {
            Experience newExperience = experienceService.addExperience(experience);
            return new ResponseEntity<>(new Result("CREATED", "", newExperience), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Result> getExperience(@PathVariable int id) {
        try{
        List<Experience> experience = experienceService.getExperienceById(id);
        return new ResponseEntity<>(new Result("CREATED", "", experience), HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
    }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable int id, @RequestBody Experience experience) {
        Experience updatedExperience = experienceService.updateExperience(id, experience);
        if (updatedExperience != null) {
            return ResponseEntity.ok(updatedExperience);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
