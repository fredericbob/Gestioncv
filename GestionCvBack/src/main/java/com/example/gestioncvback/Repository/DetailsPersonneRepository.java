package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.View.DetailsPersonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsPersonneRepository extends JpaRepository<DetailsPersonne, Integer> {
}