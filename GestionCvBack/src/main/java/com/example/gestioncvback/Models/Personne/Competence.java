package com.example.gestioncvback.Models.Personne;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Competence {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idpersonne",referencedColumnName = "id")
    private Personne personne;

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

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
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
