package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.*;

import com.example.gestioncvback.Models.Users.Utilisateur;
import com.example.gestioncvback.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CvServices {

    private final CvRepository cvRepository;
    private final PersonneRepository personneRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final NiveaucompetenceRepository niveaucompetenceRepository;

    private final CompetenceRepository competenceRepository;

    private final DiplomeobtentionRepository diplomeobtentionRepository;

    private final DomaineRepository domaineRepository;

    @Autowired
    public CvServices(CvRepository cvRepository, PersonneRepository personneRepository, UtilisateurRepository utilisateurRepository, NiveaucompetenceRepository niveaucompetenceRepository, CompetenceRepository competenceRepository, DiplomeobtentionRepository diplomeobtentionRepository, DomaineRepository domaineRepository) {
        this.cvRepository = cvRepository;
        this.personneRepository = personneRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.niveaucompetenceRepository = niveaucompetenceRepository;
        this.competenceRepository = competenceRepository;

        this.diplomeobtentionRepository = diplomeobtentionRepository;
        this.domaineRepository = domaineRepository;
    }

    public List<Cv> findAll() {
        return this.cvRepository.findAll();
    }

    public Optional<Cv> findById(int id) {
        return this.cvRepository.findById(id);
    }

    @Transactional
    public Cv update(int id, Cv cv) {
        // Récupérer la cv existante par son ID
        Cv existingCv = cvRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("cv not found with id: " + id));

        // Vérifier et mettre à jour les champs modifiés
        if (cv.getNomcv() != null && !cv.getNomcv().isEmpty()) {
            existingCv.setNomcv(cv.getNomcv());
        }
        if (cv.getTypecv() != null && !cv.getTypecv().isEmpty()) {
            existingCv.setTypecv(cv.getTypecv());
        }
        if (cv.getAutresinformations() != null) {
            existingCv.setAutresinformations(cv.getAutresinformations());
        }
        if (cv.getArchive() != null && !cv.getArchive()) {
            existingCv.setArchive(cv.getArchive());
        }


        if (cv.getUtilisateur() != null) {
            Utilisateur personne = utilisateurRepository.findById(cv.getUtilisateur().getId())
                    .orElseThrow(() -> new RuntimeException("Personne not found"));
            existingCv.setUtilisateur(personne);
        }

        // Si diplome n'est pas null, mettre à jour le diplome
        if (cv.getDiplomeobtention() != null) {
            Diplomeobtention diplome = diplomeobtentionRepository.findById(cv.getDiplomeobtention().getId())
                    .orElseThrow(() -> new RuntimeException("Diplome  not found"));
            existingCv.setDiplomeobtention(diplome);
        }

        // Si domaine n'est pas null, mettre à jour le domaine

        return this.cvRepository.save(existingCv);
    }

    public Cv createCv(Cv cv) {
        return cvRepository.save(cv);
    }

    public void delete(int id) {
        this.cvRepository.deleteById(id);
    }

    public Cv addCv(Cv cv) {
        if (cv.getUtilisateur() == null || cv.getUtilisateur().getId() == 0) {
            throw new IllegalArgumentException("Utilisateur is null or invalid");
        }

        // Vérifier que l'utilisateur existe
        Utilisateur utilisateur = utilisateurRepository.findById(cv.getUtilisateur().getId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));

        cv.setUtilisateur(utilisateur);

        // Définir archive sur false
        cv.setArchive(false);

        return cvRepository.save(cv);
    }
    public Long getTotalCv() {
        return cvRepository.countTotalCv();
    }

    public Integer getTotalNouveauxCvAujourdHui() {
        return cvRepository.findTotalNouveauxCvAujourdHui();
    }
}