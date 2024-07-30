import React, { useState } from 'react';
import { jwtDecode } from 'jwt-decode';
import { useNavigate } from 'react-router-dom';

// Définir l'URL de l'API dans une variable de configuration
const API_URL = 'http://localhost:8080/authentication/login';

function Login() {
  const navigate = useNavigate();

  const [email, setEmail] = useState('durand@email.com');
  const [password, setPassword] = useState('password789');
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    const requestOptions = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ email, password }),
    };

    try {
      const response = await fetch(API_URL, requestOptions);

      if (!response.ok) {
        if (response.status === 401) {
          setError('Email ou mot de passe incorrect.');
        }
        throw new Error('La requête a échoué.');
      }

      const data = await response.json();
    
      localStorage.setItem('token', data.data.token);

 
      const token = data.data.token;
  

     
      localStorage.setItem('token', token);

      // Décoder le token pour obtenir le rôle
      const decodedToken = jwtDecode(token);
    // Ajouter ce log pour voir le contenu du token
  
    const email = decodedToken.email.toLowerCase();
    localStorage.setItem('email', email);
    console.log(email);
      const userRole = decodedToken.role.toLowerCase(); // Convertir en minuscules
    
  
      if (userRole === 'admin') {
      
        navigate('/admin/accueil') // Rediriger vers la page Sidebar pour les administrateurs
      } else if (userRole === 'client') {
        navigate('/client'); // Rediriger vers la page Client pour les clients
      } else {
       
        navigate('/login');
      }
    } catch (error) {
      console.error('Erreur lors de la requête à l\'API:', error);
      setError('Une erreur s\'est produite lors de la connexion : ' + error.message);
    }
  };

  return (
    <main>
      <div className="container">
        <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
          <div className="container">
            <div className="row justify-content-center">
              <div className="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                <div className="d-flex justify-content-center py-4">
                  <a href="Admin/Accueil.jsp" className="logo d-flex align-items-center w-auto">
                    <img src="/assets/img/logo.png" alt="" />
                    <span className="d-none d-lg-block">Gestion de cv</span>
                  </a>
                </div>
                <div className="card mb-3">
                  <div className="card-body">
                    <div className="pt-4 pb-2">
                      <h5 className="card-title text-center pb-0 fs-4">Connecter à votre compte</h5>
                      <p className="text-center small">Entrer votre email & mot de passe </p>
                    </div>
                    <form className="row g-3 needs-validation" onSubmit={handleSubmit}>
                      <div className="col-12">
                        <label htmlFor="yourUsername" className="form-label">Email</label>
                        <div className="input-group has-validation">
                          <input
                            type="text"
                            name="email"
                            className="form-control"
                            id="yourUsername"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                          />
                          <div className="invalid-feedback">Veuillez entrer votre email.</div>
                        </div>
                      </div>
                      <div className="col-12">
                        <label htmlFor="yourPassword" className="form-label">Mot de passe</label>
                        <input
                          type="password"
                          name="password"
                          className="form-control"
                          id="yourPassword"
                          value={password}
                          onChange={(e) => setPassword(e.target.value)}
                          required
                        />
                        <div className="invalid-feedback">Veuillez entrer votre mot de passe!</div>
                      </div>
                      {error && <div className="col-12"><p className="text-danger">{error}</p></div>}
                      <div className="col-12">
                        <button className="btn btn-primary w-100" type="submit">Connecter</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </main>
  );
}

export default Login;
