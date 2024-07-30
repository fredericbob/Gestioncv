package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.View.CvParposte;
import com.example.gestioncvback.Repository.CvParposteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvParposteService {



    private final CvParposteRepository cvParposteRepository;

    @Autowired
    public CvParposteService(CvParposteRepository cvParposteRepository) {
        this.cvParposteRepository = cvParposteRepository;
    }

    public List<CvParposte> searchCvByPoste(String searchTerm) {
        return cvParposteRepository.searchByPoste(searchTerm);
    }

    public List<CvParposte> searchCvByCompetence(String searchTerm) {
        return cvParposteRepository.searchByCompetence(searchTerm);
    }

}
