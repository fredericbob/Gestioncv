import React from 'react';


import { Link } from 'react-router-dom';
function Sidebar () {
  

  
  return (
 <aside id="sidebar" className="sidebar">
  <ul className="sidebar-nav" id="sidebar-nav">
    <li className="nav-item">
      <Link to="/admin/accueil" className="nav-link collapsed" >
        <i className="bi bi-grid"></i> <span>Accueil</span>
      </Link>
    </li>
    <li className="nav-item">
      <Link to="/admin/listecandidat" className="nav-link collapsed">
        <i className="bi bi-three-dots"></i>
        <span>Liste Candidat</span>
      </Link>
    </li>
    <li className="nav-item">
      <Link to="/admin/listeCv" className="nav-link collapsed">
        <i className="ri-checkbox-multiple-line"></i>
        <span>Liste Cv</span>
      </Link>
    </li>
    <li className="nav-item">
      <Link to="/admin/archives" className="nav-link collapsed">
      <i className="bi bi-archive"></i>
        <span>Archives</span>
      </Link>
    </li>
    <li className="nav-item">
      <a className="nav-link collapsed" data-bs-toggle="collapse" href="#recherches-nav">
        <i className="bi bi-list-ul"></i>
        <span>Recherches</span>
        <i className="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="recherches-nav" className="nav-content collapse">
        <li>
          <Link to="/admin/competence" className="nav-link">
            <i className="bi bi-circle"></i>
            <span>Par compétence</span>
          </Link>
        </li>
        <li>
          <Link to="/admin/poste" className="nav-link">
            <i className="bi bi-circle"></i>
            <span>Par poste</span>
          </Link>
        </li>
      </ul>
    </li>
    <li className="nav-item">
      <a className="nav-link collapsed" data-bs-toggle="collapse" href="#import-nav">
        <i className="bx bx-import"></i>
        <span>Import</span>
        <i className="bi bi-chevron-down ms-auto"></i>
      </a>
      <ul id="import-nav" className="nav-content collapse">
        <li>
          <Link to="/admin/import" className="nav-link">
            <i className="bi bi-circle"></i>
            <span>PDF</span>
          </Link>
        </li>
      </ul>
    </li>
  </ul>
</aside>
  );
};

export default Sidebar;
