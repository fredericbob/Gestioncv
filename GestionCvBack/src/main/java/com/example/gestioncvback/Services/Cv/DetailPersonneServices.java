package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.View.DetailsPersonne;
import com.example.gestioncvback.Repository.DetailsPersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailPersonneServices {

    private final DetailsPersonneRepository detailsPersonneRepository;

    public DetailPersonneServices(DetailsPersonneRepository detailsPersonneRepository) {
        this.detailsPersonneRepository = detailsPersonneRepository;
    }

    public List<DetailsPersonne> findAll(){
        return  detailsPersonneRepository.findAll();
    }
}
