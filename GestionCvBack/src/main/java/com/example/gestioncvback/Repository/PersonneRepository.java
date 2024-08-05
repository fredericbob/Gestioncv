package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    @Query("SELECT COUNT(p) > 0 FROM Personne p WHERE p.utilisateur.id = :utilisateurId")
    boolean existsByUtilisateurId(@Param("utilisateurId") Long utilisateurId);
}