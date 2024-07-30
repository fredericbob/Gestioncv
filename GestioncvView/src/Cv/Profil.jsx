import React, { useEffect, useState } from 'react';
import { Spinner } from 'react-bootstrap'; 
import '../assets/css/style.css';


function Profil() {
    const [profil, setProfil] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const email = localStorage.getItem('email');
    const apiUrl = `http://localhost:8080/profil/${email}`;
    const token = localStorage.getItem('token');

    useEffect(() => {
        fetchData();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [apiUrl, token]);

    async function fetchData() {
        const requestOptions = {
            method: 'GET',
            headers: {
                Authorization: `Bearer ${token}`,
                'Content-Type': 'application/json',
            },
        };
        try {
            const response = await fetch(apiUrl, requestOptions);
            if (!response.ok) {
                throw new Error('La requête a échoué.');
            }
            const data = await response.json();
            setProfil(data.data);
        } catch (error) {
            console.error('Erreur lors de la requête à l\'API:', error);
            setError(error);
        } finally {
            setLoading(false);
        }
    }

    if (loading) return (
        <div className="d-flex justify-content-center align-items-center vh-100">
            <Spinner animation="border" variant="primary" style={{ width: '3rem', height: '3rem' }} />
        </div>
    );
    if (error) return <p className="text-danger text-center">Erreur: {error.message}</p>;
    if (!profil) return <p className="text-center">Aucune donnée trouvée</p>;

    return (
        <div className="container mt-5 profil-container">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="card">
                        <div className="card-header">
                            <h3 className="text-center" style={{

                                marginTop:'5%',
                               
                            }}>Votre profil</h3>
                        </div>
                        <div className="card-body">
                            <p><strong>Date de naissance:</strong> {profil.dateNaissance}</p>
                            <p><strong>Adresse:</strong> {profil.adresse}</p>
                            <p><strong>Téléphone:</strong> {profil.telephone}</p>
                            <p><strong>Email:</strong> {profil.email}</p>
                            <p><strong>Genre:</strong> {profil.genre}</p>
                            <p><strong>Statut Matrimonial:</strong> {profil.statutMatrimonial}</p>
                            <p><strong>CV Noms:</strong> {profil.cvNoms}</p>
                            <p><strong>Domaines de Compétence:</strong> {profil.domainesCompetences}</p>
                            <p><strong>Compétences:</strong> {profil.competences}</p>
                            <p><strong>Expériences:</strong> {profil.experiences}</p>
                            <p><strong>Diplômes Obtenus:</strong> {profil.diplomesObtenus}</p>
                            <p><strong>Langues Plus Maîtrisées:</strong> {profil.languesPlusMaitrisees}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Profil;
