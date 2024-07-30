package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.View.CvParposte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvParposteRepository extends JpaRepository<CvParposte, Integer> {

    @Query("SELECT c FROM CvParposte c WHERE LOWER(c.dernierPoste) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<CvParposte> searchByPoste(@Param("searchTerm") String searchTerm);

    @Query("SELECT cv FROM CvParposte cv WHERE LOWER(cv.competences) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<CvParposte> searchByCompetence(@Param("searchTerm") String searchTerm);
}