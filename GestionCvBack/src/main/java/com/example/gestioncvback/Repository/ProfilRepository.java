package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.View.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer> {

    @Query("SELECT p FROM Profil p WHERE p.email = :email")
    Optional<Profil> findByEmail(@Param("email") String email);

}