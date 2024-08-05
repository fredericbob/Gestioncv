package com.example.gestioncvback.Models.Personne;

import com.example.gestioncvback.Models.Users.Utilisateur;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Cv {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @ManyToOne
    @JoinColumn(name = "idutilisateur",referencedColumnName = "id")
    private Utilisateur utilisateur;


    @Column(name = "nomcv")
    private String nomcv;

    @Column(name = "typecv")
    private String typecv;

    @ManyToOne
    @JoinColumn(name = "iddiplome" ,referencedColumnName = "id")
    private Diplomeobtention diplomeobtention;




    @Column(name = "autresinformations")
    private String autresinformations;

    @Column(name = "archive")
    private Boolean archive;

    public Diplomeobtention getDiplomeobtention() {
        return diplomeobtention;
    }

    public void setDiplomeobtention(Diplomeobtention diplomeobtention) {
        this.diplomeobtention = diplomeobtention;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getNomcv() {
        return nomcv;
    }

    public void setNomcv(String nomcv) {
        this.nomcv = nomcv;
    }

    public String getTypecv() {
        return typecv;
    }

    public void setTypecv(String typecv) {
        this.typecv = typecv;
    }


    public String getAutresinformations() {
        return autresinformations;
    }

    public void setAutresinformations(String autresinformations) {
        this.autresinformations = autresinformations;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }


}
