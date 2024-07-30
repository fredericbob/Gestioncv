package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}