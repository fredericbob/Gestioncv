package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {


        @Query("SELECT COUNT(c) FROM Cv c")
        Long countTotalCv();

        @Query(value = "SELECT COUNT(*) FROM cv WHERE date_reception = CURRENT_DATE", nativeQuery = true)
        Integer findTotalNouveauxCvAujourdHui();
}