package com.example.gestioncvback.Models.Personne;

import com.example.gestioncvback.Models.Users.Utilisateur;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Personne {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public Personne(int id) {
        this.id = id;
    }

    public Personne() {

    }

    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "adresse")
    private String adresse;



    @Column(name = "telephone")
    private String telephone;


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @ManyToOne
    @JoinColumn(name = "idgenre",referencedColumnName = "id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "idstatutmatrimonial",referencedColumnName = "id")
    private Statutmatrimonial statutmatrimonial;

    public Statutmatrimonial getStatutmatrimonial() {
        return statutmatrimonial;
    }

    public void setStatutmatrimonial(Statutmatrimonial statutmatrimonial) {
        this.statutmatrimonial = statutmatrimonial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date_naissance")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
