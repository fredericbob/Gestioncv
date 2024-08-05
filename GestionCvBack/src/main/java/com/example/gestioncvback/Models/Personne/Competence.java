package com.example.gestioncvback.Models.Personne;

import com.example.gestioncvback.Models.Users.Utilisateur;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Competence {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idutilisateur",referencedColumnName = "id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "iddomaine",referencedColumnName = "id")
    private Domaine domaine;

    @ManyToOne
    @JoinColumn(name = "idniveau",referencedColumnName = "id")
    private Niveaucompetence niveaucompetence;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    public Niveaucompetence getNiveaucompetence() {
        return niveaucompetence;
    }

    public void setNiveaucompetence(Niveaucompetence niveaucompetence) {
        this.niveaucompetence = niveaucompetence;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
