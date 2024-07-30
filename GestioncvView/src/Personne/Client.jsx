import React from 'react';

import { Link } from 'react-router-dom';

function Client() {
  return (
    <aside id="sidebar" className="sidebar">
      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <Link to="/client/accueil" className="nav-link collapsed" >
            <i className="bi bi-grid"></i>
            <span>Accueil</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" to="#">
            <i className="bi bi-list-ul"></i>
            <span>Saisie cv</span>
            <i className="bi bi-chevron-down ms-auto"></i>
          </Link>
          <ul id="tables-nav" className="nav-content collapse" data-bs-parent="#sidebar-nav">
            <li>
              <Link to="/client/ajoutcv" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>Ajout cv</span>
              </Link>
            </li>
            <li>
              <Link to="/client/modifiercv" className="nav-link">
                <i className="bi bi-circle"></i>
                <span>Modifier</span>
              </Link>
            </li>
          </ul>
        </li>
        <li className="nav-item">
          <Link to="/client/profil" className="nav-link collapsed">
            <i className="bi bi-three-dots"></i>
            <span>Profil</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link collapsed" data-bs-target="#import" data-bs-toggle="collapse" to="#">
            <i className="bx bx-import"></i>
            <span>Export</span>
            <i className="bi bi-chevron-down ms-auto"></i>
          </Link>
          <ul id="import" className="nav-content collapse" data-bs-parent="#sidebar-nav">
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
