package com.example.gestioncvback.Controllers.View;


import com.example.gestioncvback.Models.View.CvParposte;
import com.example.gestioncvback.Services.Cv.CvParposteService;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/poste")
public class CvParposteController {

    private final CvParposteService cvParposteService;

    @Autowired
    public CvParposteController(CvParposteService cvParposteService) {
        this.cvParposteService = cvParposteService;
    }

    @GetMapping("/search")
    public ResponseEntity<Result> searchCvByPoste(@RequestParam String searchTerm) {
        try {
            List<CvParposte> cvParPostes = cvParposteService.searchCvByPoste(searchTerm);
            return new ResponseEntity<>(new Result("Ok", "", cvParPostes), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }
}
