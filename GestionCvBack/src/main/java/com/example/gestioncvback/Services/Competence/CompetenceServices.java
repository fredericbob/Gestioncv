package com.example.gestioncvback.Services.Competence;

import com.example.gestioncvback.Models.Personne.Competence;

import com.example.gestioncvback.Repository.CompetenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServices {

    private final CompetenceRepository competenceRepository;

    @Autowired
    public CompetenceServices(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }


    @Transactional
    public List<Competence> addCompetences(List<Competence> competences) {
        for (Competence competence : competences) {
            if (competence.getUtilisateur() == null || competence.getUtilisateur().getId() == 0) {
                throw new IllegalArgumentException("Utilisateur is null or ID is missing");
            }
            if (competence.getDomaine() == null || competence.getDomaine().getId() == null) {
                throw new IllegalArgumentException("Domaine is null or ID is missing");
            }
            if (competence.getNiveaucompetence() == null || competence.getNiveaucompetence().getId() == 0) {
                throw new IllegalArgumentException("Niveaucompetence is null or ID is missing");
            }
        }
        return competenceRepository.saveAll(competences);
    }

    @Transactional
    public Competence addCompetence(Competence competence) {
        // Validation des champs
        if (competence.getUtilisateur() == null || competence.getUtilisateur().getId() == 0) {
            throw new IllegalArgumentException("Utilisateur is null or ID is missing");
        }
        if (competence.getDomaine() == null || competence.getDomaine().getId() == null) {
            throw new IllegalArgumentException("Domaine is null or ID is missing");
        }
        if (competence.getNiveaucompetence() == null || competence.getNiveaucompetence().getId() == 0) {
            throw new IllegalArgumentException("Niveaucompetence is null or ID is missing");
        }

        // Sauvegarde de la compétence
        return competenceRepository.save(competence);
    }
}