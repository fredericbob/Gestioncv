package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.*;

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

    private final NiveaucompetenceRepository niveaucompetenceRepository;

    private final CompetenceRepository competenceRepository;

    private final DiplomeobtentionRepository diplomeobtentionRepository;

    private final DomaineRepository domaineRepository;

    @Autowired
    public CvServices(CvRepository cvRepository, PersonneRepository personneRepository, NiveaucompetenceRepository niveaucompetenceRepository, CompetenceRepository competenceRepository,  DiplomeobtentionRepository diplomeobtentionRepository, DomaineRepository domaineRepository) {
        this.cvRepository = cvRepository;
        this.personneRepository = personneRepository;
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


        if (cv.getPersonne() != null) {
            Personne personne = personneRepository.findById(cv.getPersonne().getId())
                    .orElseThrow(() -> new RuntimeException("Personne not found"));
            existingCv.setPersonne(personne);
        }

        // Si diplome n'est pas null, mettre à jour le diplome
        if (cv.getDiplomeobtention() != null) {
            Diplomeobtention diplome = diplomeobtentionRepository.findById(cv.getDiplomeobtention().getId())
                    .orElseThrow(() -> new RuntimeException("Diplome  not found"));
            existingCv.setDiplomeobtention(diplome);
        }

        // Si domaine n'est pas null, mettre à jour le domaine
        if (cv.getDomaine() != null) {
            Domaine domaine = domaineRepository.findById(cv.getDomaine().getId())
                    .orElseThrow(() -> new RuntimeException("Domaine not found"));
            existingCv.setDomaine(domaine);
        }
        return this.cvRepository.save(existingCv);
    }

    public Cv save(int id, Cv cv) {
        cvRepository.findById(id);
        return this.cvRepository.save(cv);
    }

    public void delete(int id) {
        this.cvRepository.deleteById(id);
    }

    @Transactional
    public Cv addcv(Cv cv) {
        try {

            // Récupérer la personne par son ID
            Personne personne = personneRepository.findById(cv.getPersonne().getId())
                    .orElseThrow(() -> new RuntimeException("Personne not found"));

            // Récupérer le diplome par son ID
            Diplomeobtention diplome = diplomeobtentionRepository.findById(cv.getDiplomeobtention().getId())
                    .orElseThrow(() -> new RuntimeException("Diplome not found"));

            // Récupérer le domaine par son ID
            Domaine domaine = domaineRepository.findById(cv.getDomaine().getId())
                    .orElseThrow(() -> new RuntimeException("Domaine not found"));



            // Créer une nouvelle instance de Cv avec les informations validées
            Cv newCv = new Cv();
            newCv.setNomcv(cv.getNomcv());
            newCv.setTypecv(cv.getTypecv());
            newCv.setAutresinformations(cv.getAutresinformations());
            newCv.setArchive(false);
            newCv.setDiplomeobtention(diplome);
            newCv.setDomaine(domaine);
            newCv.setPersonne(personne);


            // Enregistrer le Cv en base de données
            Cv savedCv = cvRepository.save(newCv);

            //integration de competence
            Competence competence= new Competence();
            // Récupérer le niveau de competence par son ID
            Niveaucompetence niveaucompetence = niveaucompetenceRepository.findById(competence.getNiveaucompetence().getId())
                    .orElseThrow(() -> new RuntimeException("Domaine not found"));

            competence.setPersonne(savedCv.getPersonne());
            competence.setDomaine(savedCv.getDomaine());
            competence.setNiveaucompetence(niveaucompetence);
            //   competence.setDescription();

            competenceRepository.save(competence);
            // Retourner le Cv sauvegardé
            return savedCv;
        } catch (Exception e) {
            // Capturer et relancer l'exception pour une gestion centralisée
            throw new RuntimeException("Erreur lors de l'ajout du Cv : " + e.getMessage());
        }
    }

    public Long getTotalCv() {
        return cvRepository.countTotalCv();
    }

    public Integer getTotalNouveauxCvAujourdHui() {
        return cvRepository.findTotalNouveauxCvAujourdHui();
    }
}