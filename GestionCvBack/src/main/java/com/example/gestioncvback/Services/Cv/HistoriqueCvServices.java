package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.CvArchive;
import com.example.gestioncvback.Models.View.DetailsPersonne;
import com.example.gestioncvback.Repository.CvArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueCvServices {

    private final CvArchiveRepository cvArchiveRepository;

    @Autowired
    public HistoriqueCvServices(CvArchiveRepository cvArchiveRepository) {
        this.cvArchiveRepository = cvArchiveRepository;
    }

    public List<CvArchive> findAll(){
        return  cvArchiveRepository.findAll();
    }
}
