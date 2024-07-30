package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}