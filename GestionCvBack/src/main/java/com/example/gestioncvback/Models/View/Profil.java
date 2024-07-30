package com.example.gestioncvback.Models.View;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Profil {
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
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "statut_matrimonial")
    private String statutMatrimonial;
    @Basic
    @Column(name = "cv_noms")
    private String cvNoms;
    @Basic
    @Column(name = "domaines_competences")
    private String domainesCompetences;
    @Basic
    @Column(name = "competences")
    private String competences;
    @Basic
    @Column(name = "experiences")
    private String experiences;
    @Basic
    @Column(name = "diplomes_obtenus")
    private String diplomesObtenus;
    @Basic
    @Column(name = "langues_plus_maitrisees")
    private String languesPlusMaitrisees;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCvNoms() {
        return cvNoms;
    }

    public void setCvNoms(String cvNoms) {
        this.cvNoms = cvNoms;
    }

    public String getDomainesCompetences() {
        return domainesCompetences;
    }

    public void setDomainesCompetences(String domainesCompetences) {
        this.domainesCompetences = domainesCompetences;
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

    public String getDiplomesObtenus() {
        return diplomesObtenus;
    }

    public void setDiplomesObtenus(String diplomesObtenus) {
        this.diplomesObtenus = diplomesObtenus;
    }

    public String getLanguesPlusMaitrisees() {
        return languesPlusMaitrisees;
    }

    public void setLanguesPlusMaitrisees(String languesPlusMaitrisees) {
        this.languesPlusMaitrisees = languesPlusMaitrisees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profil profil = (Profil) o;
        return Objects.equals(id, profil.id) && Objects.equals(idPersonne, profil.idPersonne) && Objects.equals(nom, profil.nom) && Objects.equals(prenom, profil.prenom) && Objects.equals(dateNaissance, profil.dateNaissance) && Objects.equals(adresse, profil.adresse) && Objects.equals(telephone, profil.telephone) && Objects.equals(email, profil.email) && Objects.equals(genre, profil.genre) && Objects.equals(statutMatrimonial, profil.statutMatrimonial) && Objects.equals(cvNoms, profil.cvNoms) && Objects.equals(domainesCompetences, profil.domainesCompetences) && Objects.equals(competences, profil.competences) && Objects.equals(experiences, profil.experiences) && Objects.equals(diplomesObtenus, profil.diplomesObtenus) && Objects.equals(languesPlusMaitrisees, profil.languesPlusMaitrisees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPersonne, nom, prenom, dateNaissance, adresse, telephone, email, genre, statutMatrimonial, cvNoms, domainesCompetences, competences, experiences, diplomesObtenus, languesPlusMaitrisees);
    }
}
