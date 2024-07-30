import React, { useState, useEffect } from 'react';
import { useForm, useFieldArray } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

function AjoutCv() {
  const navigate = useNavigate();
  const { register, handleSubmit, control, formState: { errors }, setError, getValues } = useForm({
    defaultValues: {
      competences: [{ nom: '', niveau: '' }],
      idpersonne: '',
      iddiplome: '',
      iddomaine: '',
      autresinformations: '',
      typecv: ''
    }
  });
  const { fields, append, remove } = useFieldArray({
    control,
    name: 'competences'
  });
  const [personnes, setPersonnes] = useState([]);
  const [diplomes, setDiplomes] = useState([]);
  const [domaines, setDomaines] = useState([]);
  const [niveaux, setNiveaux] = useState([]);
  const [cvIdToDelete, setCvIdToDelete] = useState('');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [personnesRes, diplomesRes, domainesRes, niveauxRes] = await Promise.all([
          fetch('/api/personnes').then(res => res.json()),
          fetch('/api/diplomes').then(res => res.json()),
          fetch('/api/domaines').then(res => res.json()),
          fetch('/api/niveaux').then(res => res.json()),
        ]);

        setPersonnes(personnesRes);
        setDiplomes(diplomesRes);
        setDomaines(domainesRes);
        setNiveaux(niveauxRes);
      } catch (error) {
        console.error('Erreur lors du chargement des données:', error);
      }
    };

    fetchData();
  }, []);

  const onSubmit = async (data) => {
    if (data.password !== data.confirmPassword) {
      setError('confirmPassword', { type: 'manual', message: 'Les mots de passe ne correspondent pas' });
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/cv', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer YOUR_TOKEN`, // Remplacez par le token approprié
        },
        body: JSON.stringify(data),
      });

      const responseData = await response.json();

      if (response.ok) {
        navigate('/Client');
      } else {
        throw new Error(responseData.message || 'Erreur lors de l\'ajout du CV');
      }
    } catch (error) {
      console.error('Erreur lors de l\'ajout du CV:', error.message);
    }
  };

  return (
    <main>
      <div className="container" style={{ marginLeft: "20%", width: "80%" }}>
        <div className="d-flex flex-row justify-content-center">
          <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4 mx-2">
            <div className="container">
              <div className="row justify-content-center">
                <div className="col-lg-12 d-flex flex-column align-items-center justify-content-center">
                  <div className="card mb-3">
                    <div className="card-body">
                      <div className="pt-4 pb-2">
                        <h5 className="card-title text-center pb-0 fs-4">Ajouter un CV</h5>
                      </div>
                      <form className="row g-3" onSubmit={handleSubmit(onSubmit)}>
                        <div className="col-md-6">
                          <label htmlFor="nomcv" className="form-label">Nom du cv</label>
                          <input
                            type="text"
                            id="typecv"
                            className={`form-control ${errors.nomcv ? 'is-invalid' : ''}`}
                            placeholder="Nom du cv"
                            {...register('typecv', { required: 'Nom de CV requis' })}
                          />
                          {errors.idpersonne && <div className="invalid-feedback">{errors.idpersonne.message}</div>}
                        </div>

                        <div className="col-md-6">
                          <label htmlFor="iddiplome" className="form-label">Diplôme</label>
                          <select
                            id="iddiplome"
                            className={`form-select ${errors.iddiplome ? 'is-invalid' : ''}`}
                            {...register('iddiplome', { required: 'Diplôme requis' })}
                          >
                            <option value="">Sélectionner un diplôme</option>
                            {diplomes.map(diplome => (
                              <option key={diplome.id} value={diplome.id}>{diplome.nom}</option>
                            ))}
                          </select>
                          {errors.iddiplome && <div className="invalid-feedback">{errors.iddiplome.message}</div>}
                        </div>

                        <div className="col-md-6">
                          <label htmlFor="iddomaine" className="form-label">Domaine</label>
                          <select
                            id="iddomaine"
                            className={`form-select ${errors.iddomaine ? 'is-invalid' : ''}`}
                            {...register('iddomaine', { required: 'Domaine requis' })}
                          >
                            <option value="">Sélectionner un domaine</option>
                            {domaines.map(domaine => (
                              <option key={domaine.id} value={domaine.id}>{domaine.nom}</option>
                            ))}
                          </select>
                          {errors.iddomaine && <div className="invalid-feedback">{errors.iddomaine.message}</div>}
                        </div>

                        <div className="col-md-6">
                          <label htmlFor="typecv" className="form-label">Type de CV</label>
                          <input
                            type="text"
                            id="typecv"
                            className={`form-control ${errors.typecv ? 'is-invalid' : ''}`}
                            placeholder="Type de CV"
                            {...register('typecv', { required: 'Type de CV requis' })}
                          />
                          {errors.typecv && <div className="invalid-feedback">{errors.typecv.message}</div>}
                        </div>

                        <div className="col-md-12">
                          <label htmlFor="autresinformations" className="form-label">Autres Informations</label>
                          <textarea
                            id="autresinformations"
                            className={`form-control ${errors.autresinformations ? 'is-invalid' : ''}`}
                            placeholder="Autres informations"
                            {...register('autresinformations')}
                          ></textarea>
                          {errors.autresinformations && <div className="invalid-feedback">{errors.autresinformations.message}</div>}
                        </div>

                        <div className="col-md-12">
                          <label htmlFor="competences" className="form-label">Compétences</label>
                          {fields.map((field, index) => (
                            <div key={field.id} className="mb-3">
                              <div className="row">
                                <div className="col-md-5">
                                  <input
                                    type="text"
                                    className={`form-control ${errors.competences?.[index]?.nom ? 'is-invalid' : ''}`}
                                    placeholder="Nom de la compétence"
                                    {...register(`competences.${index}.nom`, { required: 'Nom de compétence requis' })}
                                    defaultValue={field.nom}
                                  />
                                  {errors.competences?.[index]?.nom && <div className="invalid-feedback">{errors.competences[index].nom.message}</div>}
                                </div>
                                <div className="col-md-5">
                                  <input
                                    type="text"
                                    className={`form-control ${errors.competences?.[index]?.niveau ? 'is-invalid' : ''}`}
                                    placeholder="Niveau de compétence"
                                    {...register(`competences.${index}.niveau`, { required: 'Niveau de compétence requis' })}
                                    defaultValue={field.niveau}
                                  />
                                  {errors.competences?.[index]?.niveau && <div className="invalid-feedback">{errors.competences[index].niveau.message}</div>}
                                </div>
                                <div className="col-md-2">
                                  <button type="button" className="btn btn-danger" onClick={() => remove(index)}>Supprimer</button>
                                </div>
                              </div>
                            </div>
                          ))}
                          <button
                            type="button"
                            className="btn btn-primary"
                            onClick={() => append({ nom: '', niveau: '' })}
                          >
                            Ajouter une compétence
                          </button>
                        </div>

                        <div className="col-md-12 text-center">
                          <button type="submit" className="btn btn-primary">Ajouter le CV</button>
                        </div>
                      </form>

                      <div className="mt-3 text-center">
                        <input
                          type="text"
                          className="form-control mb-2"
                          placeholder="ID du CV à supprimer"
                          value={cvIdToDelete}
                          onChange={(e) => setCvIdToDelete(e.target.value)}
                        />
                      </div>
                      {errors.submit && <div className="invalid-feedback d-block">{errors.submit.message}</div>}
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
      </div>
    </main>
  );
}

export default AjoutCv;
