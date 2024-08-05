package com.example.gestioncvback.Models.Personne;

import com.example.gestioncvback.Models.Users.Utilisateur;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Experience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;


    @Column(name = "poste")
    private String poste;

    @Column(name = "entreprise")
    private String entreprise;

    @Column(name = "debut")
    private Date debut;

    @Column(name = "fin")
    private Date fin;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
