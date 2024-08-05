import React from 'react';
import PropTypes from 'prop-types'; // Import PropTypes
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './Login/Login';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import Acceuil from './Accueil/Accueil';
import ListeCandidat from './Personne/ListeCandidat';
import ListCv from './Cv/ListCv';
import Competence from './Recherches/Competence.jsx';
import Home from './Pages/Home';
import Inscription from './Inscription/Inscription';
import { jwtDecode } from 'jwt-decode';
import Poste from './Recherches/Poste.jsx';
import Import from './Import/Import.jsx';
import Archives from './Archive/Archives.jsx';
import AjoutCv from './Cv/AjoutCv';
import ModifierCv from './Cv/ModifierCv';
import Profil from './Cv/Profil.jsx';
import ExportPDF from './Export/ExportPdf.jsx';
import ProtectedRoute from './ProtectedRoute';
import Deconnexion from './components/Deconnexion.jsx';
import Client from './Personne/Client.jsx';
import AjoutExperience from './Cv/AjoutExperience.jsx';
import AjoutCompetence from './Cv/AjoutCompetence.jsx';
import ModifierExperience from './Cv/Modifier/ModifierExperience .jsx';
import AjoutPersonne from './Cv/AjoutPersonne.jsx';

const Layout = ({ children }) => {
  const token = localStorage.getItem('token');
  const decodedToken = jwtDecode(token);
  const userRole = decodedToken.role.toLowerCase();
  
  return (
    <>
      <Header />
      {userRole === "admin" ? <Sidebar /> : <Client />}
      {children}
    </>
  );
};

// Ajouter la validation des props
Layout.propTypes = {
  children: PropTypes.node.isRequired
};

function App() {
  return (
    <Router>
      <Routes>
        {/* Routes non protégées */}
        <Route path="/" element={<Navigate to="/home" />} />
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Inscription />} />
        <Route path="/deconnection" element={<Deconnexion />} />

        {/* Routes pour les Administrateurs */}
        <Route
          path="/admin/*"
          element={
            <ProtectedRoute roleRequired="admin" element={<Layout><Routes>
              <Route path="accueil" element={<Acceuil />} />
              <Route path="listecandidat" element={<ListeCandidat />} />
              <Route path="listeCv" element={<ListCv />} />
              <Route path="competence" element={<Competence />} />
              <Route path="poste" element={<Poste />} />
              <Route path="import" element={<Import />} />
              <Route path="archives" element={<Archives />} />
              <Route path="/" element={<Navigate to="/accueil" />} /> {/* Redirection vers la page d'accueil par défaut */}
            </Routes></Layout>} />
          }
        />

        {/* Routes pour les Clients */}
        <Route
          path="/client/*"
          element={
            <ProtectedRoute roleRequired="client" element={<Layout><Routes>
              <Route path="accueil" element={<Acceuil />} />
              <Route path="profil" element={<Profil />} />
              <Route path="ajoutpersonne" element={<AjoutPersonne />} />
              <Route path="ajoutcv" element={<AjoutCv />} />
              <Route path="competence" element={<AjoutCompetence />} />
              <Route path="experience" element={<AjoutExperience />} />
              <Route path="modifieexperience/:id" element={<ModifierExperience />} />
              <Route path="exportpdf" element={<ExportPDF />} />
              <Route path="/" element={<Navigate to="accueil" />} /> {/* Redirection vers la page d'accueil par défaut */}
            </Routes></Layout>} />
          }
        />
      </Routes>
    </Router>
  );
}

export default App;
