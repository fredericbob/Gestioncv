package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Integer> {
}