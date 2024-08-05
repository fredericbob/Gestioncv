package com.example.gestioncvback.Models.Personne;

import com.example.gestioncvback.Models.Users.Utilisateur;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Cvluangage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idutilisateur",referencedColumnName = "id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idlanguage",referencedColumnName = "id")
    private Language language;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Basic
    @Column(name = "pourcentage")
    private double pourcentage;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

}
