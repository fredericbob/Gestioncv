package com.example.gestioncvback.Models.Personne;

import com.example.gestioncvback.Models.Users.Utilisateur;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cv_archive")
public class CvArchive {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;


    @Column(name = "nomcv")
    private String nomcv;

    @Column(name = "typecv")
    private String typecv;

    @ManyToOne
    @JoinColumn(name = "iddiplome")
    private Diplomeobtention diplomeobtention;

    @ManyToOne
    @JoinColumn(name = "iddomaine")
    private Domaine domaine;


    @Column(name = "autresinformations")
    private String autresinformations;

    @Column(name = "date_archivage")
    private Timestamp dateArchivage;

    public Diplomeobtention getDiplomeobtention() {
        return diplomeobtention;
    }

    public void setDiplomeobtention(Diplomeobtention diplomeobtention) {
        this.diplomeobtention = diplomeobtention;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }


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

    public Timestamp getDateArchivage() {
        return dateArchivage;
    }

    public void setDateArchivage(Timestamp dateArchivage) {
        this.dateArchivage = dateArchivage;
    }



}
