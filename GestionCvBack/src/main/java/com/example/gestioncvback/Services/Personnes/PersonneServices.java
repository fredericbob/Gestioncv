package com.example.gestioncvback.Services.Personnes;

import com.example.gestioncvback.Models.Personne.Genre;
import com.example.gestioncvback.Models.Personne.Personne;
import com.example.gestioncvback.Models.Personne.Statutmatrimonial;
import com.example.gestioncvback.Models.Users.Utilisateur;
import com.example.gestioncvback.Repository.GenreRepository;
import com.example.gestioncvback.Repository.PersonneRepository;
import com.example.gestioncvback.Repository.StatutmatrimonialRepository;
import com.example.gestioncvback.Repository.UtilisateurRepository;
import com.example.gestioncvback.util.Util;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneServices {

    private final PersonneRepository personneRepository;

    private final StatutmatrimonialRepository statutmatrimonialRepository;

    private final GenreRepository genreRepository;

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public PersonneServices(PersonneRepository personneRepository, StatutmatrimonialRepository statutmatrimonialRepository, GenreRepository genreRepository, UtilisateurRepository utilisateurRepository) {
        this.personneRepository = personneRepository;
        this.statutmatrimonialRepository = statutmatrimonialRepository;
        this.genreRepository = genreRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Personne> findAll() {
        return this.personneRepository.findAll();
    }

    public Optional<Personne> findById(int id) {
        return this.personneRepository.findById(id);
    }

    @Transactional
    public Personne update(int id, Personne personne) {
        // Récupérer la personne existante par son ID
        Personne existingPersonne = personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personne not found with id: " + id));

        // Vérifier et mettre à jour les champs modifiés
        if (personne.getDateNaissance() != null) {
            existingPersonne.setDateNaissance(personne.getDateNaissance());
        }
        if (personne.getAdresse() != null && !personne.getAdresse().isEmpty()) {
            existingPersonne.setAdresse(personne.getAdresse());
        }

        if (personne.getTelephone() != null && !personne.getTelephone().isEmpty()) {
            existingPersonne.setTelephone(personne.getTelephone());
        }

        if (personne.getGenre() != null) {
            Genre genre = genreRepository.findById(personne.getGenre().getId())
                    .orElseThrow(() -> new RuntimeException("Genre not found"));
            existingPersonne.setGenre(genre);
        }

        // Si personne.getStatutmatrimonial() n'est pas null, mettre à jour le statut matrimonial
        if (personne.getStatutmatrimonial() != null) {
            Statutmatrimonial statutMatrimonial = statutmatrimonialRepository.findById(personne.getStatutmatrimonial().getId())
                    .orElseThrow(() -> new RuntimeException("Statut matrimonial not found"));
            existingPersonne.setStatutmatrimonial(statutMatrimonial);
        }

        // Si personne.getUtilisateur() n'est pas null, mettre à jour l'utilisateur
        if (personne.getUtilisateur() != null) {
            Utilisateur utilisateur = utilisateurRepository.findById(personne.getUtilisateur().getId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
            existingPersonne.setUtilisateur(utilisateur);
        }
        return this.personneRepository.save(existingPersonne);
    }

    public Personne save(int id ,Personne personne) {
        personneRepository.findById(id);
       return this.personneRepository.save(personne);
    }
    public void delete(int id) {
        this.personneRepository.deleteById(id);
    }

    @Transactional
    public Personne addpersonne(Personne personne) {
        try {
        // Récupérer l'utilisateur par son ID
        Utilisateur utilisateur = utilisateurRepository.findById(personne.getUtilisateur().getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        // Récupérer le genre par son ID
        Genre genre = genreRepository.findById(personne.getGenre().getId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        // Récupérer le statut matrimonial par son ID
        Statutmatrimonial statutMatrimonial = statutmatrimonialRepository.findById(personne.getStatutmatrimonial().getId())
                .orElseThrow(() -> new RuntimeException("Statut matrimonial not found"));

        // Utiliser les informations récupérées pour peupler la personne

        personne.setUtilisateur(utilisateur);
        personne.setGenre(genre);
        personne.setStatutmatrimonial(statutMatrimonial);

        // Enregistrer la personne en base de données
            // Enregistrer la personne en base de données
            Personne savedPersonne = personneRepository.save(personne);

            // Retourner la personne sauvegardée
            return savedPersonne;
        } catch (Exception e) {
            // Capturer toute exception et la relancer pour être gérée au niveau du contrôleur
            throw new RuntimeException("Erreur lors de l'ajout de la personne : " + e.getMessage());
        }
    }
}
