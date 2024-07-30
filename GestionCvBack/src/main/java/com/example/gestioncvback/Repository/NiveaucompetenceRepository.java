package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Niveaucompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveaucompetenceRepository extends JpaRepository<Niveaucompetence, Integer> {
}