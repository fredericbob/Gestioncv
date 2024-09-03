package com.example.gestioncvback.Services.Cv;

import com.example.gestioncvback.Models.Personne.Language;
import com.example.gestioncvback.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvlanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public CvlanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll(){
        return this.languageRepository.findAll();
    }


}
