package com.example.gestioncvback.Controllers.Personne.Caracteristique;

import com.example.gestioncvback.Models.Personne.Statutmatrimonial;
import com.example.gestioncvback.Repository.StatutmatrimonialRepository;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusControllers {

    private final StatutmatrimonialRepository statutmatrimonialRepository;

    @Autowired
    public StatusControllers(StatutmatrimonialRepository statutmatrimonialRepository) {
        this.statutmatrimonialRepository = statutmatrimonialRepository;
    }

    @GetMapping
    public ResponseEntity<Result> statutmatrimonial(){
        try{
            List<Statutmatrimonial> genres = this.statutmatrimonialRepository.findAll();
            return new ResponseEntity<>(new Result("Ok","",genres), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }
}
