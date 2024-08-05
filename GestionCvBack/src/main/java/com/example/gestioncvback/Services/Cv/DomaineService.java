package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.Domaine;
import com.example.gestioncvback.Repository.DomaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomaineService {

    private final DomaineRepository domaineRepository;

    @Autowired
    public DomaineService(DomaineRepository domaineRepository) {
        this.domaineRepository = domaineRepository;
    }


    public List<Domaine> findAll(){
        return this.domaineRepository.findAll();
    }

}
