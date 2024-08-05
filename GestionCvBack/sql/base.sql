        create database gestioncv with encoding 'utf8';
        \c gestioncv;

        CREATE TABLE role(
        id SERIAL PRIMARY KEY ,
        nom VARCHAR(50) not null
        );
        INSERT INTO Role (nom) VALUES ('USER'), ('ADMIN'), ('client');

        CREATE TABLE genre(
                             id SERIAL PRIMARY KEY ,
                             nom VARCHAR(50) not null
        );

        INSERT INTO genre (nom) VALUES ('Homme'), ('femme');

        CREATE TABLE Domaine (
        id SERIAL PRIMARY KEY,
        nomdomaine VARCHAR(100) NOT NULL
        );

        INSERT INTO Domaine (nomdomaine) VALUES
        ('Développement Web'),
        ('Développement Mobile'),
        ('Data Science'),
        ('Réseaux et Sécurité'),
        ('Gestion de Projet');


        CREATE TABLE StatutMatrimonial (
        id SERIAL PRIMARY KEY,
        statut VARCHAR(50) NOT NULL
        );

        INSERT INTO StatutMatrimonial (statut) VALUES
        ('Célibataire'),
        ('Marié(e)'),
        ('Divorcé(e)'),
        ('Veuf/Veuve');

        CREATE TABLE Utilisateur  (
                      id SERIAL PRIMARY KEY,
                      nom varchar not null ,
                      prenom varchar not null ,
                      email varchar unique not null ,
                      password VARCHAR(300) not null ,
                      idrole INT REFERENCES role
        );

        CREATE INDEX idx_utilisateur_email ON Utilisateur(email);

        INSERT INTO Utilisateur (nom,prenom, email, password, idrole)
        VALUES
            ('Jean', 'Dupont', 'dupont@email.com', 'password123', 1),
            ('Marie', 'Martin', 'martin@email.com', 'password456', 2),
            ('Pierre','Durand', 'durand@email.com', 'password789', 3);


        CREATE TABLE Personne (
        id SERIAL PRIMARY KEY,
        idutilisateur int references Utilisateur on delete cascade ,
        date_naissance DATE not null ,
        adresse TEXT not null ,
        telephone char(10)  ,
        idgenre INT REFERENCES genre(id),
        idstatutmatrimonial INT REFERENCES StatutMatrimonial(id),
        CONSTRAINT chk_telephone_format CHECK (telephone ~ '^0[0-9]{9}$')
        );

        CREATE INDEX idx_personne_email ON Personne(idutilisateur);
        CREATE INDEX idx_personne_idgenre ON Personne(idgenre);
        CREATE INDEX idx_personne_idstatutmatrimonial ON Personne(idstatutmatrimonial);
        CREATE INDEX idx_personne_idutilisateur ON Personne(idutilisateur);


        INSERT INTO Personne (idutilisateur, date_naissance, adresse, telephone,idgenre, idstatutmatrimonial) VALUES
        (1, '1985-02-10', '15 rue de la Liberté, Paris', '0123456789', 1, 2),
        (2, '1990-04-25', '25 avenue des Roses, Lyon', '0987654321', 2, 3),
        (3, '1980-10-05', '10 rue du Commerce, Bordeaux', '0765432109', 1, 1);

        CREATE TABLE niveaucompetence (
        id SERIAL PRIMARY KEY,
        nom VARCHAR,
        note int
        );
        INSERT INTO niveaucompetence (nom, note) VALUES
        ('Débutant', 1),
        ('Intermédiaire', 2),
        ('Avancé', 3),
        ('Expert', 4),
        ('Maître', 5);


        CREATE TABLE Competence (
        id SERIAL PRIMARY KEY,
        idutilisateur INT REFERENCES Utilisateur(id) ON DELETE CASCADE,
        iddomaine INT REFERENCES Domaine(id),
        idniveau INT REFERENCES niveaucompetence(id),
        description TEXT
        );

        CREATE INDEX idx_competence_idpersonne ON Competence(idutilisateur);
        CREATE INDEX idx_competence_iddomaine ON Competence(iddomaine);


        INSERT INTO Competence (idutilisateur, iddomaine, idniveau, description) VALUES
        (1, 1, 4, 'JavaScript'),
        (1, 1, 3, 'Python'),
        (2, 2, 2, 'Gestion de Projet'),
        (2, 1, 5, 'Java'),
        (3, 1, 5, 'Java');




        CREATE TABLE language(
        id SERIAL PRIMARY KEY ,
        nom VARCHAR
        );

        INSERT INTO language (nom) VALUES
        ('Java'),
        ('Python'),
        ('Php'),
        ('JavaScript');


        CREATE TABLE Diplome (
                                 id SERIAL PRIMARY KEY,
                                 nom varchar
        );

        INSERT INTO Diplome (nom) VALUES
                                      ('master'),
                                      ('licence'),
                                      ('doctorat');

        CREATE TABLE DiplomeObtention (
                                 id SERIAL PRIMARY KEY,
                                 iddiplome int references Diplome(id),
                                 dateobtention DATE not null ,
                                 etablissement VARCHAR(100)
        );
        INSERT INTO DiplomeObtention (iddiplome, dateobtention, etablissement) VALUES
       (1, '2023-05-15', 'Université A'),
       (2, '2021-09-20', 'Université B'),
       (3, '2025-01-10', 'Université C');


        CREATE INDEX idx_diplome ON DiplomeObtention(iddiplome);

        CREATE TABLE Experience (
        id SERIAL PRIMARY KEY,
        idutilisateur INT REFERENCES Utilisateur(id) ON DELETE CASCADE,
        poste VARCHAR(100) NOT NULL,
        entreprise VARCHAR(100),
        debut DATE,
        fin DATE,
        description TEXT
        );

        CREATE INDEX idx_experience_idpersonne ON Experience(idutilisateur);

        INSERT INTO Experience (idutilisateur, poste, entreprise, debut, fin, description) VALUES
        (1, 'Développeur Full-stack', 'Startup Innovate', '2010-08-01', '2015-12-31', 'Développement de plateformes web innovantes'),
        (2, 'Recruteur Senior', 'Agence RH Plus', '2012-05-15', '2020-03-20', 'Recrutement pour divers secteurs d activité'),
        (3, 'Chef de Projet IT', 'Grande Entreprise SA', '2015-03-10', '2023-01-05', 'Gestion de projets informatiques complexes');


        CREATE TABLE CV (
        id SERIAL PRIMARY KEY,
        idutilisateur INT REFERENCES Utilisateur(id) ON DELETE CASCADE,
        nomcv VARCHAR(100) NOT NULL,
        typecv VARCHAR(50),
        iddiplome INT REFERENCES DiplomeObtention(id) not null ,
        autresinformations TEXT,
        archive BOOLEAN DEFAULT false,
        date_reception Date
        );



        CREATE INDEX idx_cv_idpersonne ON CV(idutilisateur);
        CREATE INDEX idx_cv_iddiplome ON CV(iddiplome);

        CREATE INDEX idx_cv_archive ON CV(archive);


        INSERT INTO CV (idutilisateur, nomcv, typecv, iddiplome, autresinformations) VALUES
        (1, 'CV Jean Dupont', 'Développeur Web', 1, 'Expérience dans la création de sites web responsives'),
        (2, 'CV Marie Martin', 'Recruteur', 1,  'Spécialisée dans le recrutement technique et stratégique'),
        (3, 'CV Pierre Durand', 'Chef de Projet IT', 3,  'Expertise en gestion de projets Agile');

        CREATE TABLE cv_archive (
        id Serial PRIMARY KEY,
        idutiliasteur INT references Utilisateur(id) on delete cascade ,
        nomcv VARCHAR(255) NOT NULL,
        typecv VARCHAR(255) NOT NULL,
        iddiplome INT references DiplomeObtention(id)  ,
        autresinformations TEXT,
        date_archivage TIMESTAMP
        );



        CREATE TABLE CVluangage (
        id SERIAL PRIMARY KEY,
        idutilisateur INT REFERENCES Utilisateur(id)  ON DELETE CASCADE,
        idlanguage INT REFERENCES language(id),
        pourcentage double precision  not null
        );

        CREATE INDEX idx_cvluangage_idcv ON CVluangage(idutilisateur);


        INSERT INTO CVluangage (idutilisateur, idlanguage, pourcentage) VALUES
        (1, 1, 90.5),
        (1, 2, 80),
        (2, 3, 95),
        (3, 4, 85);

        CREATE TABLE noteetcommentaire (
        id SERIAL PRIMARY KEY,
        idcv INT REFERENCES CV(id) ON DELETE CASCADE,
        idutilisateur INT REFERENCES Utilisateur(id) ON DELETE CASCADE,
        note INT CHECK (note >= 1 AND note <= 10),
        commentaire TEXT,
        date_commentaire TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        );

        CREATE INDEX idx_noteetcommentaire_idcv ON noteetcommentaire(idcv);
        CREATE INDEX idx_noteetcommentaire_idutilisateur ON noteetcommentaire(idutilisateur);


        INSERT INTO noteetcommentaire (idcv, idutilisateur, note, commentaire) VALUES
        (1, 2, 5, 'Excellent CV, très bien structuré.'),
        (2, 2, 4, 'Bon CV, mais manque de détails sur les projets.'),
        (1, 1, 3, 'CV acceptable, mais peut être amélioré.'),
        (3, 2, 2, 'CV peu clair et mal organisé.');



        create function archiver_cv(cv_id integer) returns void
            language plpgsql
as
$$
        BEGIN

        INSERT INTO CV_Archive (idutilisateur, nomcv, typecv, iddiplome, autresinformations)
        SELECT idutilisateur, nomcv, typecv, iddiplome,  autresinformations
        FROM CV
        WHERE id = cv_id;


        DELETE FROM CV WHERE id = cv_id;
        END;
$$;

        alter function archiver_cv(integer) owner to postgres;


        ----view cv
        CREATE OR REPLACE VIEW cv_complet AS
        SELECT
            row_number() OVER () AS id,
                    u.nom || ' ' || u.prenom AS nom_complet,
            p.id AS idpersonne,
            c.id AS idcv,
            c.nomcv,
            COALESCE(string_agg(DISTINCT c.typecv, ', '), '-') AS type_cv,
            COALESCE(string_agg(DISTINCT d.nomdomaine, ', '), '-') AS domaine_competence,
            COALESCE(string_agg(DISTINCT comp.description || ' (' || nc.note || ')', ', '), '-') AS competences,
            COALESCE(string_agg(DISTINCT e.description, ', '), '-') AS description_experience,
            c.archive AS archive,
            COALESCE((SELECT string_agg(DISTINCT l.nom, ', ')
                      FROM CVluangage cvl
                               JOIN language l ON cvl.idlanguage = l.id
                      WHERE cvl.idutilisateur = c.idutilisateur), '-') AS langues_plus_maitrisees,
            COALESCE(string_agg(DISTINCT CONCAT(di.nom, ' (', dpl.dateobtention, ')'), ', '), '-') AS diplomes_obtenus,
            COALESCE(MAX(e.poste), '-') AS dernier_poste
        FROM
            Personne p
                LEFT JOIN Utilisateur u ON u.id = p.idutilisateur
                LEFT JOIN CV c ON p.id = c.idutilisateur
                LEFT JOIN Competence comp ON p.id = comp.idutilisateur
                LEFT JOIN Domaine d ON comp.iddomaine = d.id
                LEFT JOIN niveaucompetence nc ON comp.idniveau = nc.id
                LEFT JOIN Experience e ON p.id = e.idutilisateur
                LEFT JOIN DiplomeObtention dpl ON c.iddiplome = dpl.id
                LEFT JOIN Diplome di ON dpl.iddiplome = di.id
        GROUP BY
            p.id, c.id, u.nom, u.prenom
        ORDER BY
            u.nom, u.prenom;

------------------CV_par_personne

        CREATE OR REPLACE VIEW cv_par_personne AS
        SELECT
            row_number() OVER () AS id,
                    u.nom || ' ' || u.prenom AS nom_complet,
            p.id AS idpersonne,
            c.id AS idcv,
            c.nomcv,
            COALESCE(string_agg(DISTINCT c.typecv , ', '), '-') AS type_cv,
            COALESCE(string_agg(DISTINCT d.nomdomaine, ', '), '-') AS domaine_competence,
            COALESCE(string_agg(DISTINCT comp.description || ' (' || nc.note || ')', ', '), '-') AS competences,
            COALESCE(string_agg(DISTINCT e.description, ', '), '-') AS description_experience,
            c.archive AS archive,
            COALESCE((SELECT string_agg(DISTINCT l.nom, ', ')
                      FROM CVluangage cvl
                               JOIN language l ON cvl.idlanguage = l.id
                      WHERE cvl.idutilisateur = c.idutilisateur), '-') AS langues_plus_maitrisees,
            COALESCE(string_agg(DISTINCT CONCAT(di.nom, ' (', dpl.dateobtention, ')'), ', '), '-') AS diplomes_obtenus
        FROM
            Personne p
                LEFT JOIN Utilisateur u ON u.id = p.idutilisateur
                LEFT JOIN CV c ON p.id = c.idutilisateur
                LEFT JOIN Competence comp ON p.id = comp.idutilisateur
                LEFT JOIN Domaine d ON comp.iddomaine = d.id
                LEFT JOIN niveaucompetence nc ON comp.idniveau = nc.id
                LEFT JOIN Experience e ON p.id = e.idutilisateur
                LEFT JOIN DiplomeObtention dpl ON c.iddiplome = dpl.id
                LEFT JOIN Diplome di ON dpl.iddiplome = di.id
        GROUP BY
            p.id, c.id,u.nom,u.prenom
        ORDER BY
            u.nom, u.prenom;






        -----view poste par experience
        CREATE OR REPLACE VIEW CV_ParPoste AS
        SELECT
            cv.*,
            -- Calculer la durée d'expérience spécifique pour chaque poste
            EXTRACT(YEAR FROM AGE(MAX(e.fin), MIN(e.debut))) * 12 + EXTRACT(MONTH FROM AGE(MAX(e.fin), MIN(e.debut))) AS duree_experience_mois,
            EXTRACT(YEAR FROM AGE(MAX(e.fin), MIN(e.debut))) || ' ans ' ||
            EXTRACT(MONTH FROM AGE(MAX(e.fin), MIN(e.debut))) || ' mois' AS duree_experience
        FROM
            cv_complet cv
                LEFT JOIN Experience e ON e.idutilisateur = cv.idpersonne
        WHERE
            cv.dernier_poste IS NOT NULL
          AND e.poste = cv.dernier_poste
        GROUP BY
            cv.id, cv.nom_complet, cv.idpersonne, cv.idcv, cv.nomcv, cv.type_cv, cv.domaine_competence,
            cv.competences, cv.description_experience, cv.archive, cv.langues_plus_maitrisees,
            cv.diplomes_obtenus, cv.dernier_poste
        ORDER BY
            duree_experience_mois DESC;



        ---recherche par poste
        SELECT *
        FROM CV_ParPoste
        WHERE dernier_poste ILIKE '%%';




-------detail personne
            CREATE OR REPLACE VIEW details_personne AS
            SELECT
                row_number() OVER () AS id,
                p.id AS id_personne,
                u.nom AS nom,
                u.prenom AS prenom,
                p.date_naissance,
                p.adresse,
                p.telephone,
                u.email as email,
                g.nom AS genre,
                sm.statut AS statut_matrimonial,
                COALESCE(string_agg(DISTINCT c.nomcv, ', '), '-') AS cv_noms,
                COALESCE(string_agg(DISTINCT d.nomdomaine, ', '), '-') AS domaines_competences,
                COALESCE(string_agg(DISTINCT comp.description || ' (' || nc.note || ')', ', '), '-') AS competences,
                COALESCE(string_agg(DISTINCT e.poste || ' chez ' || e.entreprise || ' (' || EXTRACT(YEAR FROM AGE(e.fin, e.debut)) || ' ans)', ', '), '-') AS experiences,
                COALESCE(string_agg(DISTINCT CONCAT(di.nom, ' (', dpl.dateobtention, ')'), ', '), '-') AS diplomes_obtenus
            FROM
                Personne p
                    JOIN Utilisateur u ON p.idutilisateur = u.id
                    LEFT JOIN genre g ON p.idgenre = g.id
                    LEFT JOIN StatutMatrimonial sm ON p.idstatutmatrimonial = sm.id
                    LEFT JOIN CV c ON p.id = c.idutilisateur
                    LEFT JOIN Competence comp ON p.id = comp.idutilisateur
                    LEFT JOIN Domaine d ON comp.iddomaine = d.id
                    LEFT JOIN niveaucompetence nc ON comp.idniveau = nc.id
                    LEFT JOIN Experience e ON p.id = e.idutilisateur
                    LEFT JOIN DiplomeObtention dpl ON c.iddiplome = dpl.id
                    LEFT JOIN Diplome di ON dpl.iddiplome = di.id
            GROUP BY
                p.id, u.nom, u.prenom, p.date_naissance, p.adresse, p.telephone, g.nom, sm.statut,u.email
            ORDER BY
                u.nom, u.prenom;

--------fonction pour ajouter un date de creation de cv automatique a chaque creation
            CREATE OR REPLACE FUNCTION set_date_reception()
                RETURNS TRIGGER AS $$
                        BEGIN
                    NEW.date_reception := CURRENT_TIMESTAMP;
                        RETURN NEW;
                        END;
                $$ LANGUAGE plpgsql;

        DROP TRIGGER IF EXISTS trg_set_date_reception ON CV;

        CREATE TRIGGER trg_set_date_reception
            BEFORE INSERT ON CV
            FOR EACH ROW
            EXECUTE PROCEDURE set_date_reception();

------profil
        CREATE OR REPLACE VIEW profil AS
        SELECT
            row_number() OVER () AS id,
            p.id AS id_personne,
            u.nom AS nom,
            u.prenom AS prenom,
            p.date_naissance,
            p.adresse,
            p.telephone,
            u.email,
            g.nom AS genre,
            sm.statut AS statut_matrimonial,
            COALESCE(string_agg(DISTINCT c.nomcv, ', '), '-') AS cv_noms,
            COALESCE(string_agg(DISTINCT d.nomdomaine, ', '), '-') AS domaines_competences,
            COALESCE(string_agg(DISTINCT comp.description || ' (' || nc.note || ')', ', '), '-') AS competences,
            COALESCE(string_agg(DISTINCT e.poste || ' chez ' || e.entreprise || ' (' || EXTRACT(YEAR FROM AGE(e.fin, e.debut)) || ' ans)', ', '), '-') AS experiences,
            COALESCE(string_agg(DISTINCT CONCAT(di.nom, ' (', dpl.dateobtention, ')'), ', '), '-') AS diplomes_obtenus,
            COALESCE(string_agg(DISTINCT l.nom || ' (' || cvl.pourcentage || '%)', ', '), '-') AS langues_plus_maitrisees
        FROM
            Personne p
                JOIN Utilisateur u ON p.idutilisateur = u.id
                LEFT JOIN genre g ON p.idgenre = g.id
                LEFT JOIN StatutMatrimonial sm ON p.idstatutmatrimonial = sm.id
                LEFT JOIN CV c ON p.id = c.idutilisateur
                LEFT JOIN Competence comp ON p.id = comp.idutilisateur
                LEFT JOIN Domaine d ON comp.iddomaine = d.id
                LEFT JOIN niveaucompetence nc ON comp.idniveau = nc.id
                LEFT JOIN Experience e ON p.id = e.idutilisateur
                LEFT JOIN DiplomeObtention dpl ON c.iddiplome = dpl.id
                LEFT JOIN Diplome di ON dpl.iddiplome = di.id
                LEFT JOIN CVluangage cvl ON c.idutilisateur = cvl.idutilisateur
                LEFT JOIN language l ON cvl.idlanguage = l.id
        GROUP BY
            p.id, u.nom, u.prenom, p.date_naissance, p.adresse, p.telephone, g.nom, sm.statut, u.email
        ORDER BY
            u.nom, u.prenom;

