package com.example.gestioncvback.Controllers.Personne.Cv;

import com.example.gestioncvback.Models.Personne.Cv;
import com.example.gestioncvback.Models.Personne.Diplome;
import com.example.gestioncvback.Models.Personne.Domaine;
import com.example.gestioncvback.Services.Cv.CvServices;
import com.example.gestioncvback.Services.Cv.DiplomeService;
import com.example.gestioncvback.Services.Cv.DomaineService;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cv")
public class CvControllers {

    private final CvServices cvServices;

    private final DomaineService domaineService;
    private final DiplomeService diplomeService;

    @Autowired
    public CvControllers(CvServices cvServices, DomaineService domaineService, DiplomeService diplomeService) {
        this.cvServices = cvServices;
        this.domaineService = domaineService;
        this.diplomeService = diplomeService;
    }



    @GetMapping("/listecv")
    public ResponseEntity<Result> Listecv(){
        try{
            List<Cv> cv = this.cvServices.findAll();
            return new ResponseEntity<>(new Result("Ok","",cv), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Result> addCv(@RequestBody Cv cv) {
        try {
            Cv newCv = cvServices.addCv(cv);
            return new ResponseEntity<>(new Result("CREATED", "", newCv), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occurred", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Result> update(@PathVariable int id, @RequestBody Cv cv){
        try{
            Cv c = cvServices.update(id,cv);
            return new  ResponseEntity<>(new Result("UPDATED","",c),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id){
        try {
            Optional<Cv> cv=cvServices.findById(id);
            if (cv.isPresent()){
                cvServices.delete(id);
                return new ResponseEntity<>(new Result("DELETED","",""),HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new Result("NOT FOUND","",""),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/totalcv")
    public ResponseEntity<Result> getTotalCvCount() {
        try {
            long count = cvServices.getTotalCv();
            return new ResponseEntity<>(new Result("Ok", "", count), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Nouveaucv")
    public ResponseEntity<Result> Nouveaucv() {
        try {
            long count = cvServices.getTotalNouveauxCvAujourdHui();
            return new ResponseEntity<>(new Result("Ok", "", count), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/domaine")
    public ResponseEntity<Result> domaine() {
        try {
            List<Domaine> domaine = domaineService.findAll();
            return new ResponseEntity<>(new Result("Ok", "", domaine), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/diplome")
    public ResponseEntity<Result> diplome() {
        try {
            List<Diplome> diplomes = diplomeService.findAll();
            return new ResponseEntity<>(new Result("Ok", "", diplomes), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }

}
