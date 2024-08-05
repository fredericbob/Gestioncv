package com.example.gestioncvback.Services.Experiences;

import com.example.gestioncvback.Models.Personne.Experience;
import com.example.gestioncvback.Models.Users.Utilisateur;
import com.example.gestioncvback.Repository.ExperienceRepository;
import com.example.gestioncvback.Repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServices {

    private final ExperienceRepository experienceRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public ExperienceServices(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }



    @Transactional
    public Experience addExperience(Experience experience) {
        if (experience.getUtilisateur() == null || experience.getUtilisateur().getId() == 0) {
            throw new IllegalArgumentException("Utilisateur is null or invalid");
        }

        // Vérifier que l'utilisateur existe
        Utilisateur utilisateur = utilisateurRepository.findById(experience.getUtilisateur().getId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));

        experience.setUtilisateur(utilisateur);

        return experienceRepository.save(experience);
    }

    public List<Experience> getExperienceById(int id) {
        return experienceRepository.findexperience(id);
    }

    public Experience updateExperience(int id, Experience experience) {
        if (experienceRepository.existsById(id)) {
            experience.setId(id); // Assurez-vous que l'ID est bien mis à jour
            return experienceRepository.save(experience);
        } else {
            return null;
        }
    }
}
