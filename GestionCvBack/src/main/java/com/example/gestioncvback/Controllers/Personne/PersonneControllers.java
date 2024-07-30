package com.example.gestioncvback.Controllers.Personne;

import com.example.gestioncvback.Models.Personne.Personne;
import com.example.gestioncvback.Models.View.DetailsPersonne;
import com.example.gestioncvback.Services.Cv.DetailPersonneServices;
import com.example.gestioncvback.Services.Personnes.PersonneServices;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class PersonneControllers {

    private final PersonneServices personneServices;
    private final DetailPersonneServices detailPersonneServices;

    @Autowired
    public PersonneControllers(PersonneServices personneServices, DetailPersonneServices detailPersonneServices) {
        this.personneServices = personneServices;
        this.detailPersonneServices = detailPersonneServices;
    }


    @GetMapping("/listpersonne")
    public ResponseEntity<Result> Listpersonne(){
        try{
            List<Personne> personnes = this.personneServices.findAll();
            return new ResponseEntity<>(new Result("Ok","",personnes), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addpersonne")
    public ResponseEntity<Result> saveDetails(@RequestBody Personne personne) {
        try{
            Personne p= personneServices.addpersonne(personne);
            return new ResponseEntity<>(new Result("CREATED", "", p), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> update(@PathVariable int id,@RequestBody Personne personne){
        try{
            Personne p = personneServices.update(id,personne);
            return new  ResponseEntity<>(new Result("UPDATED","",p),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id){
        try {
            Optional<Personne> personne=personneServices.findById(id);
            if (personne.isPresent()){
                personneServices.delete(id);
                return new ResponseEntity<>(new Result("DELETED","",""),HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new Result("NOT FOUND","",""),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }
}

