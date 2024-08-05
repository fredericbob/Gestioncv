package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    @Query("SELECT e FROM Experience e where e.utilisateur.id= :idutilisateur")
    List<Experience> findexperience(@Param("idutilisateur") int id);

}