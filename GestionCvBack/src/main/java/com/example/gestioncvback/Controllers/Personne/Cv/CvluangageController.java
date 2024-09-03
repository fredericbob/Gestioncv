package com.example.gestioncvback.Controllers.Personne.Cv;

import com.example.gestioncvback.Models.Personne.Cvluangage;
import com.example.gestioncvback.Services.CvLanguage.CvluangageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cvluangages")
public class CvluangageController {

    @Autowired
    private CvluangageService cvluangageService;

    @PostMapping("/add")
    public ResponseEntity<?> addCvluangage(@RequestBody Object requestBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Vérification si la requête contient une liste ou un objet unique
            if (requestBody instanceof List) {
                // Ajouter plusieurs langues
                List<?> cvluangages = (List<?>) requestBody;
                if (!cvluangages.isEmpty() && cvluangages.get(0) instanceof Map) {
                    // Convertir la liste d'objets JSON en liste d'objets Cvluangage
                    List<Cvluangage> cvluangageList = new ArrayList<>();
                    for (Object item : cvluangages) {
                        Cvluangage cvluangage = objectMapper.convertValue(item, Cvluangage.class);
                        cvluangageList.add(cvluangage);
                    }
                    List<Cvluangage> addedCvluangages = cvluangageService.addCvluangages(cvluangageList);
                    return ResponseEntity.ok(addedCvluangages);
                }
                return ResponseEntity.badRequest().body("Type de données dans la liste invalide");
            } else if (requestBody instanceof Map) {
                // Ajouter une seule langue
                Cvluangage cvluangage = objectMapper.convertValue(requestBody, Cvluangage.class);
                Cvluangage addedCvluangage = cvluangageService.addCvluangage(cvluangage);
                return ResponseEntity.ok(addedCvluangage);
            }
            return ResponseEntity.badRequest().body("Type de requête invalide");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");
        }
    }
}

