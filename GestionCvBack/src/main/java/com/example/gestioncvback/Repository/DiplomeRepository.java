package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {
}