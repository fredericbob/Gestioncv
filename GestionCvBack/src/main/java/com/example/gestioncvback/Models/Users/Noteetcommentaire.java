package com.example.gestioncvback.Models.Users;

import com.example.gestioncvback.Models.Personne.Cv;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Noteetcommentaire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idcv",referencedColumnName = "id")
    private Cv cv;

    @ManyToOne
    @JoinColumn(name = "idutilisateur",referencedColumnName = "id")
    private Utilisateur utilisateur;

    @Column(name = "note")
    private Integer note;
    @Basic
    @Column(name = "commentaire")
    private String commentaire;
    @Basic
    @Column(name = "date_commentaire")
    private Timestamp dateCommentaire;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Timestamp getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Timestamp dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }


}
