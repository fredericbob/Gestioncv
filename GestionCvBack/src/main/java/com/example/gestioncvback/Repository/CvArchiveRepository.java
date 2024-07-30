package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.Personne.CvArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvArchiveRepository extends JpaRepository<CvArchive, Integer> {
}