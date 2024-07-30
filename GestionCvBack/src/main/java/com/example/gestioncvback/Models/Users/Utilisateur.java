package com.example.gestioncvback.Models.Users;

import com.example.gestioncvback.Models.Personne.Personne;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Utilisateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public Utilisateur(int id) {
        this.id = id;
    }

    public Utilisateur() {

    }
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @ManyToOne
    @JoinColumn(name = "idrole", referencedColumnName = "id")
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
