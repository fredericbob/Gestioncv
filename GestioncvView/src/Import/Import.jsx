import React, { useState } from 'react';

function Import(){
  // État pour gérer le fichier sélectionné
  const [file, setFile] = useState(null);

  // Fonction pour gérer le changement de fichier
  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  // Fonction pour gérer la soumission du formulaire
  const handleSubmit = (event) => {
    event.preventDefault();

    // Créez un objet FormData pour envoyer le fichier
    const formData = new FormData();
    formData.append('point', file);

    // Envoyez la demande de formulaire
    fetch('/importpoint', {
      method: 'POST',
      body: formData,
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
  };

  return (
    <main id="main" className="main">
    <section className="section">
      <div className="card-body">
        <h5 className="card-title">Import</h5>
        <form onSubmit={handleSubmit} encType="multipart/form-data">
          <div className="row align-items-center">
            <label htmlFor="mt" className="col-sm-1 col-form-label">Cv</label>
            <div className="col-sm-8">
              <input 
                type="file" 
                name="point" 
                className="form-control" 
                id="mt" 
                onChange={handleFileChange} 
              />
            </div>
            <div className="col-sm-3">
              <button type="submit" className="btn btn-primary w-100">Importer</button>
            </div>
          </div>
        </form>
      </div>
    </section>
  </main>
);
};

export default Import;
