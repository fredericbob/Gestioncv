package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Cvluangage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvluangageRepository extends JpaRepository<Cvluangage, Integer> {
}