import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { authFetch } from '../components/authFetch';

function ListeCandidat() {
  const apiUrl = 'http://localhost:8080/details/personne';

  const [personne, setPersonne] = useState([]);
  const [perPage, setPerPage] = useState(10);
  const [searchTerm, setSearchTerm] = useState('');
  const [currentPage, setCurrentPage] = useState(1);
  const [totalEntries, setTotalEntries] = useState(0);
  const [selectedPerson, setSelectedPerson] = useState(null); // Pour stocker la personne sélectionnée
  const [modalOpen, setModalOpen] = useState(false); // Pour contrôler l'ouverture de la modal

  useEffect(() => {
    fetchData();
  }, [apiUrl, currentPage, perPage]);

  async function fetchData() {
    try {
      const data = await authFetch(apiUrl);
      
      setPersonne(data.data);
      setTotalEntries(data.total); // Assuming API provides total number of entries
    } catch (error) {
      console.error('Erreur lors de la requête à l\'API:', error);
    }
  }

  const filteredData = personne.filter((p) =>
    p.nom.toLowerCase().includes(searchTerm.toLowerCase()) ||
    p.prenom.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const totalPages = Math.ceil(filteredData.length / perPage);
  const startIndex = (currentPage - 1) * perPage;
  const paginatedData = filteredData.slice(startIndex, startIndex + perPage);

  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  const handlePerPageChange = (e) => {
    setPerPage(Number(e.target.value));
    setCurrentPage(1);
  };

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
    setCurrentPage(1);
  };

  const openModal = (person) => {
    setSelectedPerson(person);
    setModalOpen(true);
  };

  const closeModal = () => {
    setModalOpen(false);
    setSelectedPerson(null);
  };

  return (
    <main id="main" className="main">
      <section className="section">
        <div className="row">
          <div className="col-lg-12">
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">Liste des candidats</h5>

                <div className="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
                  <div className="datatable-top">
                    <div className="datatable-dropdown">
                      <label>
                        <select
                          className="datatable-selector"
                          name="per-page"
                          value={perPage}
                          onChange={handlePerPageChange}
                        >
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="10">10</option>
                        </select>{' '}
                        Entrer votre page
                      </label>
                    </div>
                    <div className="datatable-search">
                      <input
                        className="datatable-input"
                        placeholder="Search..."
                        type="search"
                        name="search"
                        value={searchTerm}
                        onChange={handleSearchChange}
                        title="Search within table"
                      />
                    </div>
                  </div>
                  <div className="datatable-container">
                    <table className="table datatable">
                      <thead>
                        <tr>
                          <th><b>Nom</b></th>
                          <th>Prénom</th>
                          <th>Date de naissance</th>
                          <th>Adresse</th>
                          <th>Téléphone</th>
                          <th>Email</th>
                          <th>Statut</th>
                          <th>Genre</th>
                          <th>Voir le cv</th>
                        </tr>
                      </thead>
                      <tbody>
                        {paginatedData.map((p) => (
                          <tr key={p.idPersonne}>
                            <td>{p.nom}</td>
                            <td>{p.prenom}</td>
                            <td>{p.dateNaissance}</td>
                            <td>{p.adresse}</td>
                            <td>{p.telephone}</td>
                            <td>{p.email}</td>
                            <td>{p.statutMatrimonial}</td>
                            <td>{p.genre}</td>
                            <td>
                              <button onClick={() => openModal(p)} style={{ color: 'blue', border: 'none', background: 'none'}}>
                                <i className="bi bi-eye"></i>
                              </button>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                  <div className="datatable-bottom" style={{ color: 'black', padding: '10px' }}>
                    Pages
                    <nav className="datatable-pagination">
                      <ul className="datatable-pagination-list">
                        <li className={`datatable-pagination-list-item ${currentPage === 1 ? 'datatable-hidden datatable-disabled' : ''}`}>
                          <button
                            className="datatable-pagination-list-item-link"
                            onClick={() => handlePageChange(currentPage - 1)}
                            aria-label="Previous Page"
                          >
                            ‹
                          </button>
                        </li>
                        {Array.from({ length: totalPages }, (_, index) => index + 1).map((page) => (
                          <li
                            key={page}
                            className={`datatable-pagination-list-item ${currentPage === page ? 'datatable-active' : ''}`}
                          >
                            <button
                              className="datatable-pagination-list-item-link"
                              onClick={() => handlePageChange(page)}
                              aria-label={`Page ${page}`}
                            >
                              {page}
                            </button>
                          </li>
                        ))}
                        <li className={`datatable-pagination-list-item ${currentPage === totalPages ? 'datatable-hidden datatable-disabled' : ''}`}>
                          <button
                            className="datatable-pagination-list-item-link"
                            onClick={() => handlePageChange(currentPage + 1)}
                            aria-label="Next Page"
                          >
                            ›
                          </button>
                        </li>
                      </ul>
                    </nav>
                  </div>
                </div>

                {modalOpen && selectedPerson && (
                  <div className="modal" style={{ display: 'block', backgroundColor: 'rgba(0, 0, 0, 0.5)' }}>
                    <div className="modal-dialog">
                      <div className="modal-content">
                        <div className="modal-header">
                          <h5 className="modal-title">Détails du CV</h5>
                          <button
                            type="button"
                            className="close"
                            onClick={closeModal}
                          >
                            <span>&times;</span>
                          </button>
                        </div>
                        <div className="modal-body">
                        <p><strong>Nom:</strong> {selectedPerson.cv_noms}</p>
                          <p><strong>Domaines et competences:</strong> {selectedPerson.domaines_competences}</p>
                          <p><strong>Competences:</strong> {selectedPerson.competences}</p>
                          <p><strong>Experiences:</strong> {selectedPerson.experiences}</p>
                          <p><strong>Diplomes obtenus:</strong> {selectedPerson.diplomes_obtenus}</p>
                          {/* Ajoutez d'autres informations si nécessaire */}
                        </div>
                        <div className="modal-footer">
                          <button
                            type="button"
                            className="btn btn-secondary"
                            onClick={closeModal}
                          >
                            Fermer
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                )}

              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  );
}

export default ListeCandidat;
