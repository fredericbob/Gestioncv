import React from 'react';
import { Link } from 'react-router-dom';

function Client() {
  return (
    <aside id="sidebar" className="sidebar">
      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <Link to="/client/accueil" className="nav-link">
            <i className="bi bi-grid"></i>
            <span>Accueil</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link collapsed" data-bs-toggle="collapse" data-bs-target="#saisie-cv-nav" aria-expanded="false" aria-controls="saisie-cv-nav">
            <i className="bi bi-list-ul"></i>
            <span>Saisie cv</span>
            <i className="bi bi-chevron-down ms-auto"></i>
          </Link>
          <ul id="saisie-cv-nav" className="nav-content collapse" data-bs-parent="#sidebar-nav">
          <li>
              <Link to="/client/ajoutpersonne" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>Detail profil</span>
              </Link>
            </li>
            <li>
              <Link to="/client/ajoutcv" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>Cv et diplome</span>
              </Link>
            </li>
            <li>
              <Link to="/client/experience" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>Experience</span>
              </Link>
            </li>
            <li>
              <Link to="/client/competence" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>Competence</span>
              </Link>
            </li>
          </ul>
        </li>
        <li className="nav-item">
  <Link 
    className="nav-link collapsed" 
    data-bs-toggle="collapse" 
    data-bs-target="#modifier-nav" 
    aria-expanded="false" 
    aria-controls="modifier-nav"
  >
    <i className="bi bi-list-ul"></i>
    <span>Modifier</span>
    <i className="bi bi-chevron-down ms-auto"></i>
  </Link>
  <ul id="modifier-nav" className="nav-content collapse" data-bs-parent="#sidebar-nav">
    <li>
      <Link to="/client/modifiecv" className="nav-link">
        <i className="bi bi-circle"></i>
        <span>Cv et diplome</span>
      </Link>
    </li>
    <li>
      <Link to="/client/modifieexperience" className="nav-link">
        <i className="bi bi-circle"></i>
        <span>Experience</span>
      </Link>
    </li>
    <li>
      <Link to="/client/modifiecompetence" className="nav-link">
        <i className="bi bi-circle"></i>
        <span>Competence</span>
      </Link>
    </li>
  </ul>
</li>
        <li className="nav-item">
          <Link to="/client/profil" className="nav-link">
            <i className="bi bi-three-dots"></i>
            <span>Profil</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link collapsed" data-bs-toggle="collapse" data-bs-target="#export-nav" aria-expanded="false" aria-controls="export-nav">
            <i className="bx bx-import"></i>
            <span>Export</span>
            <i className="bi bi-chevron-down ms-auto"></i>
          </Link>
          <ul id="export-nav" className="nav-content collapse" data-bs-parent="#sidebar-nav">
            <li>
              <Link to="/exportpdf" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>PDF</span>
              </Link>
            </li>
          </ul>
        </li>
      </ul>
    </aside>
  );
}

export default Client;
