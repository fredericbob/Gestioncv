package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Diplomeobtention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeobtentionRepository extends JpaRepository<Diplomeobtention, Integer> {
}