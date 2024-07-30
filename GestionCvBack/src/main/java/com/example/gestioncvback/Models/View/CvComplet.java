package com.example.gestioncvback.Models.View;

import jakarta.persistence.*;

@Entity
@Table(name = "cv_complet")
public class CvComplet {

    @Id
    private Long id;
    private String nomComplet;
    private Long idpersonne;
    private Long idcv;
    private String nomcv;
    private String typeCv;
    private String domaineCompetence;
    private String competences;
    private String descriptionExperience;
    private Boolean archive;
    private String languesPlusMaitrisees;
    private String diplomesObtenus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Long getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Long idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Long getIdcv() {
        return idcv;
    }

    public void setIdcv(Long idcv) {
        this.idcv = idcv;
    }

    public String getNomcv() {
        return nomcv;
    }

    public void setNomcv(String nomcv) {
        this.nomcv = nomcv;
    }

    public String getTypeCv() {
        return typeCv;
    }

    public void setTypeCv(String typeCv) {
        this.typeCv = typeCv;
    }

    public String getDomaineCompetence() {
        return domaineCompetence;
    }

    public void setDomaineCompetence(String domaineCompetence) {
        this.domaineCompetence = domaineCompetence;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getDescriptionExperience() {
        return descriptionExperience;
    }

    public void setDescriptionExperience(String descriptionExperience) {
        this.descriptionExperience = descriptionExperience;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getLanguesPlusMaitrisees() {
        return languesPlusMaitrisees;
    }

    public void setLanguesPlusMaitrisees(String languesPlusMaitrisees) {
        this.languesPlusMaitrisees = languesPlusMaitrisees;
    }

    public String getDiplomesObtenus() {
        return diplomesObtenus;
    }

    public void setDiplomesObtenus(String diplomesObtenus) {
        this.diplomesObtenus = diplomesObtenus;
    }
}
