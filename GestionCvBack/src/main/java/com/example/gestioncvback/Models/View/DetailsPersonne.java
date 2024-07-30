package com.example.gestioncvback.Models.View;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "details_personne", schema = "public", catalog = "gestioncv")
public class DetailsPersonne {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_personne")
    private Integer idPersonne;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "date_naissance")
    private Date dateNaissance;
    @Basic
    @Column(name = "adresse")
    private String adresse;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "genre")
    private String genre;

    @Basic
    @Column(name = "cv_noms")
    private String cv_noms;

    @Basic
    @Column(name = "domaines_competences")
    private String domaines_competences;

    @Basic
    @Column(name = "competences")
    private String competences;

    @Basic
    @Column(name = "experiences")
    private String experiences;

    @Basic
    @Column(name = "diplomes_obtenus")
    private String diplomes_obtenus;

    public String getCv_noms() {
        return cv_noms;
    }

    public void setCv_noms(String cv_noms) {
        this.cv_noms = cv_noms;
    }

    public String getDomaines_competences() {
        return domaines_competences;
    }

    public void setDomaines_competences(String domaines_competences) {
        this.domaines_competences = domaines_competences;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getDiplomes_obtenus() {
        return diplomes_obtenus;
    }

    public void setDiplomes_obtenus(String diplomes_obtenus) {
        this.diplomes_obtenus = diplomes_obtenus;
    }

    @Basic
    @Column(name = "statut_matrimonial")
    private String statutMatrimonial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatutMatrimonial() {
        return statutMatrimonial;
    }

    public void setStatutMatrimonial(String statutMatrimonial) {
        this.statutMatrimonial = statutMatrimonial;
    }
}
