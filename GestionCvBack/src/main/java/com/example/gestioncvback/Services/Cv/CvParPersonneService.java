package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.View.CvParPersonne;
import com.example.gestioncvback.Repository.CvParPersonneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvParPersonneService {

    private  final CvParPersonneRepository cvParPersonneRepository;

    @Autowired
    public CvParPersonneService(CvParPersonneRepository cvParPersonneRepository) {
        this.cvParPersonneRepository = cvParPersonneRepository;
    }

    @Transactional
    public void archiverEtSupprimerCV(int idcv) {
        cvParPersonneRepository.supprimer(idcv); // Marque le CV comme archivé dans la table CV
        cvParPersonneRepository.archiver(idcv); // Appelle la fonction PL/pgSQL pour archiver dans CV_Archive et supprimer de CV
    }

    @Transactional
    public void desarchivecv(int idcv) {
        cvParPersonneRepository.supprimerArchive(idcv); // Marque le CV comme archivé dans la table CV
        cvParPersonneRepository.desarchiver(idcv); // Appelle la fonction PL/pgSQL pour archiver dans CV_Archive et supprimer de CV
    }

    public List<CvParPersonne> findCvParPersonne(){
        return this.cvParPersonneRepository.findCvParPersonne();
    }
}
