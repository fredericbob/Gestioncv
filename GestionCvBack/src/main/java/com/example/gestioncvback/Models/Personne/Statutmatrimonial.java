package com.example.gestioncvback.Models.Personne;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Statutmatrimonial {
    public Statutmatrimonial(int id) {
        this.id = id;
    }
    public Statutmatrimonial() {

    }


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "statut")
    private String statut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


}
