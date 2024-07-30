package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.View.CvComplet;
import com.example.gestioncvback.Models.View.Interfaces.CvCompletProjection;
import com.example.gestioncvback.Repository.CvCompletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvCompletServices {

    @Autowired
    private CvCompletRepository cvCompletRepository;

    public List<CvCompletProjection> getAllCvComplet() {
        return cvCompletRepository.findAllProjections();
    }

    public List<CvComplet> findArchive() {
        return cvCompletRepository.findArchive();
    }

    public List<CvComplet> findDesarchive() {
        return cvCompletRepository.findDesarchive();
    }
}
