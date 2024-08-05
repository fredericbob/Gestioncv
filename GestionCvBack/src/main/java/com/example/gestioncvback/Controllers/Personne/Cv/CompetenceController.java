package com.example.gestioncvback.Controllers.Personne.Cv;

import com.example.gestioncvback.Models.Personne.Competence;



import com.example.gestioncvback.Models.Personne.Domaine;
import com.example.gestioncvback.Models.Personne.Niveaucompetence;
import com.example.gestioncvback.Services.Competence.CompetenceServices;
import com.example.gestioncvback.Services.Cv.DomaineService;
import com.example.gestioncvback.Services.Cv.NiveauCompetenceService;
import com.example.gestioncvback.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    private final CompetenceServices competenceService;

    private final NiveauCompetenceService niveauCompetenceService;

    private final DomaineService domaineService;

    @Autowired
    public CompetenceController(CompetenceServices competenceService, NiveauCompetenceService niveauCompetenceService, DomaineService domaineService) {
        this.competenceService = competenceService;
        this.niveauCompetenceService = niveauCompetenceService;
        this.domaineService = domaineService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCompetence(@RequestBody Object requestBody) {
        try {
            // Vérification si la requête contient une liste ou un objet unique
            if (requestBody instanceof List) {
                // Ajouter plusieurs compétences
                List<?> competences = (List<?>) requestBody;
                if (!competences.isEmpty() && competences.get(0) instanceof Map) {
                    // Convertir la liste d'objets JSON en liste d'objets Competence
                    List<Competence> competenceList = new ArrayList<>();
                    for (Object item : competences) {
                        Competence competence = new ObjectMapper().convertValue(item, Competence.class);
                        competenceList.add(competence);
                    }
                    List<Competence> addedCompetences = competenceService.addCompetences(competenceList);
                    return ResponseEntity.ok(addedCompetences);
                }
                return ResponseEntity.badRequest().body("Type de données dans la liste invalide");
            } else if (requestBody instanceof Map) {
                // Ajouter une seule compétence
                Competence competence = new ObjectMapper().convertValue(requestBody, Competence.class);
                Competence addedCompetence = competenceService.addCompetence(competence);
                return ResponseEntity.ok(addedCompetence);
            }
            return ResponseEntity.badRequest().body("Type de requête invalide");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur interne du serveur");
        }
    }

    @GetMapping("/domaine")
    public ResponseEntity<Result> domaine(){
        try{
            List<Domaine> domaines = this.domaineService.findAll();
            return new ResponseEntity<>(new Result("Ok","",domaines), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/niveau")
    public ResponseEntity<Result> niveau(){
        try{
            List<Niveaucompetence> niveaucompetences = this.niveauCompetenceService.findAll();
            return new ResponseEntity<>(new Result("Ok","",niveaucompetences), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    // Optionally, add more endpoints for other operations (e.g., GET, PUT, DELETE)
}
