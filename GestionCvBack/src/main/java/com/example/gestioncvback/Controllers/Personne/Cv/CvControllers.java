package com.example.gestioncvback.Controllers.Personne.Cv;

import com.example.gestioncvback.Models.Personne.Cv;
import com.example.gestioncvback.Services.Cv.CvServices;
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

    @Autowired
    public CvControllers(CvServices cvServices) {
        this.cvServices = cvServices;
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

    @PostMapping("/addcv")
    public ResponseEntity<Result> saveDetails(@RequestBody Cv cv) {
        try{
            Cv c= cvServices.addcv(cv);
            return new ResponseEntity<>(new Result("CREATED", "", c), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new Result("An Error Occured", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
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

}
