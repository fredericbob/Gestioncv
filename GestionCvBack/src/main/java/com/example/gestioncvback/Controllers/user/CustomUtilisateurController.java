package com.example.gestioncvback.Controllers.user;

import com.example.gestioncvback.Models.Users.Utilisateur;
import com.example.gestioncvback.Services.user.UtilisateurService;
import com.example.gestioncvback.result.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomUtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public CustomUtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/count")
    public ResponseEntity<Result> signup() {
        try {
            List<Utilisateur> utilisateurs = this.utilisateurService.findAll();
            return new ResponseEntity<>(new Result("OK", "", utilisateurs.size()-1), HttpStatus.OK);
        }catch (Exception e ) {
            return new ResponseEntity<>(new Result("Error occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }
}
