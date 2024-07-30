package com.example.gestioncvback.Repository;
import com.example.gestioncvback.Models.Users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

        @Query(value = "select u from Utilisateur u where u.email = :email")
        boolean existsByEmail(@Param("email") String email);

        @Query("select e from Utilisateur e where e.email = :email")
        Optional<Utilisateur> findByEmail(@Param("email") String email);



        @Query(value = "SELECT * FROM utilisateur WHERE email = ?1 AND password = ?2", nativeQuery = true)
        Optional<Utilisateur> findByEmailAndPassword(String email, String password);
    }
