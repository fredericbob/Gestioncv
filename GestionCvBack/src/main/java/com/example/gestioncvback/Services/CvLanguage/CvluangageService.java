package com.example.gestioncvback.Services.CvLanguage;

import com.example.gestioncvback.Models.Personne.Cvluangage;
import com.example.gestioncvback.Repository.CvluangageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CvluangageService {

    @Autowired
    private CvluangageRepository cvluangageRepository;

    @Transactional
    public List<Cvluangage> addCvluangages(List<Cvluangage> cvluangages) {
        for (Cvluangage cvluangage : cvluangages) {
            validateCvluangage(cvluangage);
        }
        return cvluangageRepository.saveAll(cvluangages);
    }

    @Transactional
    public Cvluangage addCvluangage(Cvluangage cvluangage) {
        // Validation des champs
        validateCvluangage(cvluangage);

        // Sauvegarde de la langue
        return cvluangageRepository.save(cvluangage);
    }

    private void validateCvluangage(Cvluangage cvluangage) {
        if (cvluangage.getUtilisateur() == null || cvluangage.getUtilisateur().getId() == 0) {
            throw new IllegalArgumentException("Utilisateur is null or ID is missing");
        }
        if (cvluangage.getLanguage() == null || cvluangage.getLanguage().getId() == 0) {
            throw new IllegalArgumentException("Language is null or ID is missing");
        }
        if (cvluangage.getPourcentage() < 0) {
            throw new IllegalArgumentException("Pourcentage cannot be negative");
        }
        // Optionnel: ajouter une vérification pour le pourcentage maximum (si nécessaire)
        if (cvluangage.getPourcentage() > 100) {
            throw new IllegalArgumentException("Pourcentage cannot exceed 100");
        }
    }
}
