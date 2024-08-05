package com.example.gestioncvback.Services.Personnes;

import com.example.gestioncvback.Models.Personne.Statutmatrimonial;
import com.example.gestioncvback.Repository.StatutmatrimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutmatrimonialService {

    private final StatutmatrimonialRepository statutmatrimonialRepository;

    @Autowired
    public StatutmatrimonialService(StatutmatrimonialRepository statutmatrimonialRepository) {
        this.statutmatrimonialRepository = statutmatrimonialRepository;
    }

    public List<Statutmatrimonial> findAll(){
        return this.statutmatrimonialRepository.findAll();
    }
}
