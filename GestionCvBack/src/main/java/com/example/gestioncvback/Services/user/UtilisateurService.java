package com.example.gestioncvback.Services.user;

import com.example.gestioncvback.Configurations.JWTInterceptor;
import com.example.gestioncvback.Configurations.JWTManager;
import com.example.gestioncvback.Models.Personne.Personne;
import com.example.gestioncvback.Models.Users.Role;
import com.example.gestioncvback.Models.Users.Utilisateur;
import com.example.gestioncvback.Repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    private final JWTManager jwt;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, JWTManager jwt) {
        this.utilisateurRepository = utilisateurRepository;
        this.jwt = jwt;
    }

    public Optional<Utilisateur> findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }


    public String login(String email, String password) throws Exception {
        // Chercher l'utilisateur par email

        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Identifiants invalides"));

        // Comparer les mots de passe (utiliser passwordEncoder.matches)
      /*  if (!passwordEncoder.matches(password, utilisateur.getPassword())) {
            throw new Exception("Identifiants invalides");
        }*/

        // Générer le token JWT pour l'utilisateur
        return jwt.generateToken(utilisateur);
    }

    public Utilisateur save(Utilisateur utilisateur){
        try {
            Utilisateur utilisateur1 = new Utilisateur();
            utilisateur1.setNom(utilisateur.getNom());
            utilisateur1.setPrenom(utilisateur.getPrenom());
            utilisateur1.setEmail(utilisateur.getEmail());

            // Encoder le mot de passe
            utilisateur1.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
            utilisateur1.setRole(new Role(3));

            // Enregistrer l'utilisateur
            Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur1);

            return savedUtilisateur;
        }catch (Exception e){
            throw new RuntimeException("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }


    public List<Utilisateur> findAll() {
        return this.utilisateurRepository.findAll();
    }
}

