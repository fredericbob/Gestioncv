package com.example.gestioncvback.Services.Personnes;

import com.example.gestioncvback.Models.Personne.Genre;
import com.example.gestioncvback.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Genreservice {

    private final GenreRepository genreRepository;

    @Autowired
    public Genreservice(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll(){
        return this.genreRepository.findAll();
    }
}
