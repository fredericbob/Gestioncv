package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.Diplome;

import com.example.gestioncvback.Repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }





    public List<Diplome> findAll(){
        return this.diplomeRepository.findAll();
    }
}
