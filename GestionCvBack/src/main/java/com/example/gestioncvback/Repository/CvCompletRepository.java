package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.View.CvComplet;
import com.example.gestioncvback.Models.View.CvParPersonne;
import com.example.gestioncvback.Models.View.Interfaces.CvCompletProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CvCompletRepository extends JpaRepository<CvComplet, Long> {

    @Query(value = "Select cv from CvComplet cv where cv.archive =false")
    List<CvComplet> findArchive();
    @Query(value = "Select cv from CvComplet cv where cv.archive =true")
    List<CvComplet> findDesarchive();
    @Query("SELECT c FROM CvComplet c")
    List<CvCompletProjection> findAllProjections();

    @Query("SELECT cv FROM Cv cv JOIN cv.utilisateur p JOIN Competence comp ON p.id = comp.utilisateur.id " +
            "JOIN Domaine d ON comp.domaine.id = d.id " +
            "JOIN Experience e ON p.id = e.utilisateur.id " +
            " WHERE LOWER(cv.nomcv) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(d.nomdomaine) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(comp.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(e.poste) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(e.entreprise) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<CvComplet> searchCVs(@Param("keyword") String keyword);


}