import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function Deconnexion() {
  const navigate = useNavigate();

  useEffect(() => {
    // Supprimer le token du localStorage
    localStorage.removeItem('token');

    // Rediriger vers la page d'accueil ou de connexion
    navigate('/home'); // Ou '/login' si vous avez une page de connexion
  }, [navigate]);

  return null; // Ce composant ne rend rien
}

export default Deconnexion;
