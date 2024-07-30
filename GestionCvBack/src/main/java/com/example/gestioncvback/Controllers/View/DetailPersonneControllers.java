package com.example.gestioncvback.Controllers.View;
import com.example.gestioncvback.Models.View.DetailsPersonne;
import com.example.gestioncvback.Services.Cv.DetailPersonneServices;
import com.example.gestioncvback.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/details")
public class DetailPersonneControllers {
    private final DetailPersonneServices detailPersonneServices;

    public DetailPersonneControllers(DetailPersonneServices detailPersonneServices) {
        this.detailPersonneServices = detailPersonneServices;
    }


    @GetMapping("/personne")
    public ResponseEntity<Result> detail(){
        try{
            List<DetailsPersonne> detailsPersonnes = this.detailPersonneServices.findAll();
            return new ResponseEntity<>(new Result("Ok","",detailsPersonnes), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }
}
