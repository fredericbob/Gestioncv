import React, { useEffect, useState } from 'react';
import { Spinner, Card } from 'react-bootstrap'; 
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
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <Card>
                        <Card.Header className="bg-primary text-white">
                            <h3 className="text-center mb-0">Votre profil</h3>
                        </Card.Header>
                        <Card.Body>
                            <ul className="list-unstyled">
                                <li className="mb-2"><strong>Date de naissance:</strong> {profil.dateNaissance}</li>
                                <li className="mb-2"><strong>Adresse:</strong> {profil.adresse}</li>
                                <li className="mb-2"><strong>Téléphone:</strong> {profil.telephone}</li>
                                <li className="mb-2"><strong>Email:</strong> {profil.email}</li>
                                <li className="mb-2"><strong>Genre:</strong> {profil.genre}</li>
                                <li className="mb-2"><strong>Statut Matrimonial:</strong> {profil.statutMatrimonial}</li>
                                <li className="mb-2"><strong>CV Noms:</strong> {profil.cvNoms}</li>
                                <li className="mb-2"><strong>Domaines de Compétence:</strong> {profil.domainesCompetences}</li>
                                <li className="mb-2"><strong>Compétences:</strong> {profil.competences}</li>
                                <li className="mb-2"><strong>Expériences:</strong> {profil.experiences}</li>
                                <li className="mb-2"><strong>Diplômes Obtenus:</strong> {profil.diplomesObtenus}</li>
                                <li className="mb-2"><strong>Langues Plus Maîtrisées:</strong> {profil.languesPlusMaitrisees}</li>
                            </ul>
                        </Card.Body>
                    </Card>
                </div>
            </div>
        </div>
    );
}

export default Profil;
