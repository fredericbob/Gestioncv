package com.example.gestioncvback.Models.View;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cv_parposte", schema = "public", catalog = "gestioncv")
public class CvParposte {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom_complet")
    private String nomComplet;
    @Basic
    @Column(name = "idpersonne")
    private Integer idpersonne;
    @Basic
    @Column(name = "idcv")
    private Integer idcv;
    @Basic
    @Column(name = "nomcv")
    private String nomcv;
    @Basic
    @Column(name = "type_cv")
    private String typeCv;
    @Basic
    @Column(name = "domaine_competence")
    private String domaineCompetence;
    @Basic
    @Column(name = "competences")
    private String competences;
    @Basic
    @Column(name = "description_experience")
    private String descriptionExperience;
    @Basic
    @Column(name = "archive")
    private Boolean archive;
    @Basic
    @Column(name = "langues_plus_maitrisees")
    private String languesPlusMaitrisees;
    @Basic
    @Column(name = "diplomes_obtenus")
    private String diplomesObtenus;
    @Basic
    @Column(name = "dernier_poste")
    private String dernierPoste;
    @Basic
    @Column(name = "duree_experience_mois")
    private Double dureeExperienceMois;
    @Basic
    @Column(name = "duree_experience")
    private String dureeExperience;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Integer getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Integer idpersonne) {
        this.idpersonne = idpersonne;
    }

    public Integer getIdcv() {
        return idcv;
    }

    public void setIdcv(Integer idcv) {
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

    public String getDernierPoste() {
        return dernierPoste;
    }

    public void setDernierPoste(String dernierPoste) {
        this.dernierPoste = dernierPoste;
    }

    public Double getDureeExperienceMois() {
        return dureeExperienceMois;
    }

    public void setDureeExperienceMois(Double dureeExperienceMois) {
        this.dureeExperienceMois = dureeExperienceMois;
    }

    public String getDureeExperience() {
        return dureeExperience;
    }

    public void setDureeExperience(String dureeExperience) {
        this.dureeExperience = dureeExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CvParposte that = (CvParposte) o;
        return Objects.equals(id, that.id) && Objects.equals(nomComplet, that.nomComplet) && Objects.equals(idpersonne, that.idpersonne) && Objects.equals(idcv, that.idcv) && Objects.equals(nomcv, that.nomcv) && Objects.equals(typeCv, that.typeCv) && Objects.equals(domaineCompetence, that.domaineCompetence) && Objects.equals(competences, that.competences) && Objects.equals(descriptionExperience, that.descriptionExperience) && Objects.equals(archive, that.archive) && Objects.equals(languesPlusMaitrisees, that.languesPlusMaitrisees) && Objects.equals(diplomesObtenus, that.diplomesObtenus) && Objects.equals(dernierPoste, that.dernierPoste) && Objects.equals(dureeExperienceMois, that.dureeExperienceMois) && Objects.equals(dureeExperience, that.dureeExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomComplet, idpersonne, idcv, nomcv, typeCv, domaineCompetence, competences, descriptionExperience, archive, languesPlusMaitrisees, diplomesObtenus, dernierPoste, dureeExperienceMois, dureeExperience);
    }
}
