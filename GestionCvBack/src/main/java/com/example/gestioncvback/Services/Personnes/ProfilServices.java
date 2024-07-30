package com.example.gestioncvback.Services.Personnes;

import com.example.gestioncvback.Models.View.DetailsPersonne;
import com.example.gestioncvback.Models.View.Profil;
import com.example.gestioncvback.Repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilServices {

    private final ProfilRepository profilRepository;

    @Autowired
    public ProfilServices(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    public List<Profil> findAll(){
        return  profilRepository.findAll();
    }

    public Optional<Profil> getProfilByEmail(String email) {
        return profilRepository.findByEmail(email);
    }




}
