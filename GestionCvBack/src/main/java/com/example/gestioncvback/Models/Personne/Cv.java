package com.example.gestioncvback.Models.Personne;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Cv {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idpersonne",referencedColumnName = "id")
    private Personne personne;


    @Column(name = "nomcv")
    private String nomcv;

    @Column(name = "typecv")
    private String typecv;

    @ManyToOne
    @JoinColumn(name = "iddiplome" ,referencedColumnName = "id")
    private Diplomeobtention diplomeobtention;

    @ManyToOne
    @JoinColumn(name = "iddomaine",referencedColumnName = "id")
    private Domaine domaine;


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
