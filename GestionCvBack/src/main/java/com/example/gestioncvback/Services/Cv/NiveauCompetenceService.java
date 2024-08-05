package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.Niveaucompetence;
import com.example.gestioncvback.Repository.NiveaucompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauCompetenceService {

    private final NiveaucompetenceRepository niveaucompetenceRepository;

    @Autowired
    public NiveauCompetenceService(NiveaucompetenceRepository niveaucompetenceRepository) {
        this.niveaucompetenceRepository = niveaucompetenceRepository;
    }

    public List<Niveaucompetence> findAll(){
        return this.niveaucompetenceRepository.findAll();
    }
}
