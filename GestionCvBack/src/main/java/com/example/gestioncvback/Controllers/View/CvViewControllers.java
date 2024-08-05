package com.example.gestioncvback.Controllers.View;

import com.example.gestioncvback.Models.Personne.CvArchive;
import com.example.gestioncvback.Models.View.CvComplet;
import com.example.gestioncvback.Models.View.Interfaces.CvCompletProjection;
import com.example.gestioncvback.Repository.CvCompletRepository;
import com.example.gestioncvback.Services.Cv.CvCompletServices;
import com.example.gestioncvback.Services.Cv.CvParPersonneService;
import com.example.gestioncvback.Services.Cv.HistoriqueCvServices;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viewcv")
public class CvViewControllers {


    private final CvCompletRepository cvCompletRepository;

    private final CvCompletServices cvCompletServices;
    private final HistoriqueCvServices historiqueCvServices;

    private final CvParPersonneService cvParPersonneService;



    @Autowired
    public CvViewControllers(CvCompletRepository cvCompletRepository, CvCompletServices cvCompletServices, HistoriqueCvServices historiqueCvServices, CvParPersonneService cvParPersonneService) {
        this.cvCompletRepository = cvCompletRepository;
        this.cvCompletServices = cvCompletServices;
        this.historiqueCvServices = historiqueCvServices;
        this.cvParPersonneService = cvParPersonneService;
    }

    @GetMapping("/cv_complet")
    public ResponseEntity<Result> Listcv(){
        try{
            List<CvComplet> cvParPersonne = this.cvCompletServices.findArchive();
            return new ResponseEntity<>(new Result("Ok","",cvParPersonne), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cv_complet_archiver")
    public ResponseEntity<Result> CvArchiver(){
        try{
            List<CvComplet> cvParPersonne = this.cvCompletServices.findDesarchive();
            return new ResponseEntity<>(new Result("Ok","",cvParPersonne), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/archive/{idcv}")
    public ResponseEntity<Result> archiveCv(@PathVariable("idcv") int idcv) {

        try {
            cvParPersonneService.archiverEtSupprimerCV(idcv);
            return new ResponseEntity<>(new Result("CV Archived successfully", "", ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("Failed to archive CV", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/desarchive/{idcv}")
    public ResponseEntity<Result> Desarchivecv(@PathVariable("idcv") int idcv) {

        try {
            cvParPersonneService.desarchivecv(idcv);
            return new ResponseEntity<>(new Result("CV Desarchived successfully", "", ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("Failed to Desarchive CV", e.getMessage(), ""), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<Result> getAllCvComplet() {
        try {
            List<CvCompletProjection> cvCompletList = cvCompletServices.getAllCvComplet();
            if (cvCompletList.isEmpty()) {
                return new ResponseEntity<>(new Result("NOT FOUND", "No data available", ""), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new Result("SUCCESS", "Data retrieved successfully", ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Result("An Error Occurred", e.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





    @GetMapping("/historique")
    public ResponseEntity<Result> HistoriqueCv(){
        try{
            List<CvArchive> cvParPersonne = this.historiqueCvServices.findAll();
            return new ResponseEntity<>(new Result("Ok","",cvParPersonne), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }

}
