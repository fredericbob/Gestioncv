package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Statutmatrimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutmatrimonialRepository extends JpaRepository<Statutmatrimonial, Integer> {
}