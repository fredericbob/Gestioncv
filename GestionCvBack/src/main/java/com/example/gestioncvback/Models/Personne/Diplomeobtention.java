package com.example.gestioncvback.Models.Personne;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Diplomeobtention {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "iddiplome" ,referencedColumnName = "id")
    private Diplome diplome;

    @Basic
    @Column(name = "dateobtention")
    private Date dateobtention;
    @Basic
    @Column(name = "etablissement")
    private String etablissement;

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getDateobtention() {
        return dateobtention;
    }

    public void setDateobtention(Date dateobtention) {
        this.dateobtention = dateobtention;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

}
