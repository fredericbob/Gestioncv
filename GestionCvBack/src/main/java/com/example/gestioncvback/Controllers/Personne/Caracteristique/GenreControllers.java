package com.example.gestioncvback.Controllers.Personne.Caracteristique;

import com.example.gestioncvback.Models.Personne.Genre;
import com.example.gestioncvback.Repository.GenreRepository;
import com.example.gestioncvback.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreControllers {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreControllers(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public ResponseEntity<Result> genre(){
        try{
            List<Genre> genres = this.genreRepository.findAll();
            return new ResponseEntity<>(new Result("Ok","",genres), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Result("An Error Occured",e.getMessage(),""),HttpStatus.BAD_REQUEST);
        }
    }
}
