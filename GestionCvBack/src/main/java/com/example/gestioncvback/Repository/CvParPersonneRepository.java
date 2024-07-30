package com.example.gestioncvback.Repository;

import com.example.gestioncvback.Models.View.CvParPersonne;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvParPersonneRepository extends JpaRepository<CvParPersonne, Integer> {

    @Query(value = "Select cv from CvParPersonne cv where cv.archive =false")
    List<CvParPersonne> findCvParPersonne();

    @Transactional
    @Modifying
    @Query(value = """
   INSERT INTO CV_Archive (idpersonne, nomcv, typecv, iddiplome, iddomaine, autresinformations, date_archivage)
   SELECT c.idpersonne, c.nomcv, c.typecv, c.iddiplome, c.iddomaine, c.autresinformations, CURRENT_TIMESTAMP
   FROM CV c
   WHERE c.id = :idcv
   """, nativeQuery = true)
    void archiver(@Param("idcv") int idcv);

    @Transactional
    @Modifying
    @Query("UPDATE Cv c SET c.archive = true WHERE c.id = :idcv")
    void supprimer(@Param("idcv") int idcv);

    @Transactional
    @Modifying
    @Query(value = """
        INSERT INTO CV (idpersonne, nomcv, typecv, iddiplome, iddomaine, autresinformations, archive)
        SELECT idpersonne, nomcv, typecv, iddiplome, iddomaine, autresinformations, false
        FROM cv_archive
        WHERE id = :idcv
        """, nativeQuery = true)
    void desarchiver(@Param("idcv") int idcv);

    @Transactional
    @Modifying
    @Query("UPDATE Cv c SET c.archive = false WHERE c.id = :idcv")
    void supprimerArchive(@Param("idcv") int idcv);
}