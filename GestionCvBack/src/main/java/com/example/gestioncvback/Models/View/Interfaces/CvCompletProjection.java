package com.example.gestioncvback.Models.View.Interfaces;

public interface CvCompletProjection {
    Long getId();
    String getNomComplet();
    Long getIdpersonne();
    Long getIdcv();
    String getNomcv();
    String getTypeCv();
    String getDomaineCompetence();
    String getCompetences();
    String getDescriptionExperience();
    Boolean getArchive();
    String getLanguesPlusMaitrisees();
    String getDiplomesObtenus();
}
