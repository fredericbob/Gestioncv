package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}