import React, { useState, useEffect } from "react";

function Archives(){
    const apiUrl = 'http://localhost:8080/viewcv/cv_complet_archiver';
    const token = localStorage.getItem('token');
  
    const [cvParPersonne, setCvParPersonne] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [cvToArchive, setCvToArchive] = useState(null); // État pour suivre l'ID du CV à archiver
  
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
        
        setCvParPersonne(data.data);
      } catch (error) {
        console.error('Erreur lors de la requête à l\'API:', error);
      }
    }
  
    const handleSearchChange = (event) => {
      setSearchTerm(event.target.value);
    };
  
    const handleArchiveClick = (id) => {
      // Mettre à jour l'état pour suivre l'ID du CV à archiver
      setCvToArchive(id);
    };
  
    const handleConfirmArchive = () => {
      // Appeler la fonction d'archivage ici
      if (cvToArchive !== null) {
        archiveCv(cvToArchive);
      }
      // Réinitialiser l'état après l'archivage
      setCvToArchive(null);
    };
  
    const archiveCv = async (id) => {
      const archiveUrl = `http://localhost:8080/viewcv/desarchive/${id}`;
      const requestOptions = {
        method: 'PUT', // Utilisez PUT, POST ou DELETE selon votre API
        headers: {
          Authorization: `Bearer ${token}`,
          'Content-Type': 'application/json',
        },
      };
      try {
        const response = await fetch(archiveUrl, requestOptions);
        if (!response.ok) {
          throw new Error('Desarchivage du CV a échoué.');
        }
        // Rafraîchir la liste après le desarchivage
        fetchData();
      } catch (error) {
        console.error('Erreur lors de la desarchivage du CV:', error);
      }
    };
  
    // Filtrer les CV en fonction du terme de recherche
    const filteredCvComplet = cvParPersonne.filter(cv =>
      cv.nomComplet.toLowerCase().includes(searchTerm.toLowerCase()) ||
      cv.nomcv.toLowerCase().includes(searchTerm.toLowerCase()) ||
      cv.languesPlusMaitrisees.toLowerCase().includes(searchTerm.toLowerCase()) ||
      cv.competences.toLowerCase().includes(searchTerm.toLowerCase()) 
    );
  
    return (
      <main id="main" className="main">
        <section className="section">
          <div className="row">
            <div className="col-lg-12">
              <div className="card">
                <div className="card-body">
                  <h5 className="card-title">Listes des candidatures archivés</h5>
                  <div className="search-bar">
                    <input
                      type="text"
                      value={searchTerm}
                      onChange={handleSearchChange}
                      placeholder="Entrer le mot clé"
                    />
                  </div>
                  <div className="datatable-container">
                    <table className="table datatable">
                      <thead>
                        <tr>
                          <th><b>Nom</b></th>
                          <th>CV</th>
                          <th>Types</th>

                          <th>Desarchiver</th>
                        </tr>
                      </thead>
                      <tbody>
                        {filteredCvComplet.map((cv, index) => (
                          <tr key={cv.id}>
                            <td>{cv.nomComplet}</td>
                            <td>{cv.nomcv}</td>
                            <td>{cv.typeCv}</td>
                            <td>
                              <button
                                className="btn btn-sm btn-danger"
                                onClick={() => handleArchiveClick(cv.idcv)}
                              >
                                <i className="bx bxs-archive-in"></i>
                              </button>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        {cvToArchive !== null && (
          <div className="modal" style={{ display: 'block', backgroundColor: 'rgba(0, 0, 0, 0.5)' }}>
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Confirmation desarchiver ?</h5>
                  <button
                    type="button"
                    className="close"
                    onClick={() => setCvToArchive(null)}
                  >
                    <span>&times;</span>
                  </button>
                </div>
                <div className="modal-body">
                  <p>Êtes-vous sûr de vouloir desarchiver ce CV ?</p>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    onClick={() => setCvToArchive(null)}
                  >
                    Annuler
                  </button>
                  <button
                    type="button"
                    className="btn btn-danger"
                    onClick={handleConfirmArchive}
                  >
                    Desarchiver
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}
      </main>
    );
}

export default Archives;