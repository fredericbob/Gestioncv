package com.example.gestioncvback.Controllers.Personne;

import com.example.gestioncvback.Models.View.Profil;
import com.example.gestioncvback.Services.Personnes.ProfilServices;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profil")
public class ProfilControllers {

    private final ProfilServices profilServices;

    @Autowired
    public ProfilControllers(ProfilServices profilServices) {
        this.profilServices = profilServices;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Result> getProfilByEmail(@PathVariable String email) {
        try {
            Optional<Profil> profil = profilServices.getProfilByEmail(email);
            if (profil.isPresent()) {
                return new ResponseEntity<>(new Result("Ok", "", profil.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Result("Not Found", "Profil non trouvé", ""), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occurred", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }
}
