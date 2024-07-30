import React, { useState, useEffect } from 'react';
import ReactApexChart from 'react-apexcharts';

function Acceuil() {
  const [totalCv, setTotalCv] = useState(0);
  const [nouveauxCv, setNouveauxCv] = useState(0); // Nombre de nouveaux CV reçus aujourd'hui
  const [candidatsEvalués, setCandidatsEvalués] = useState(0); // Nombre de candidats évalués

  const token = localStorage.getItem('token');

  const apiUrlTotalCv = 'http://localhost:8080/cv/totalcv'; // URL pour le nombre total de CV
  const apiUrlNouveauxCv = 'http://localhost:8080/cv/Nouveaucv'; // URL pour les nouveaux CV reçus aujourd'hui

  useEffect(() => {
    fetchTotalCv();
    fetchNouveauxCv(); // Appel de la fonction pour obtenir les nouveaux CV
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  async function fetchTotalCv() {
    const requestOptions = {
      method: 'GET',
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };
    try {
      const response = await fetch(apiUrlTotalCv, requestOptions);
      if (!response.ok) {
        throw new Error('La requête a échoué.');
      }
      const data = await response.json();
      setTotalCv(data.data || 0); // Assurez-vous d'utiliser la structure correcte
    } catch (error) {
      console.error('Erreur lors de la requête à l\'API:', error);
    }
  }

  async function fetchNouveauxCv() {
    const requestOptions = {
      method: 'GET',
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };
    try {
      const response = await fetch(apiUrlNouveauxCv, requestOptions);
      if (!response.ok) {
        throw new Error('La requête a échoué.');
      }
      const data = await response.json();
      setNouveauxCv(data.data || 0); // Assurez-vous d'utiliser la structure correcte
    } catch (error) {
      console.error('Erreur lors de la requête à l\'API:', error);
    }
  }

  const chartOptions = {
    series: [{
      name: 'Nouveaux CV reçus',
      data: [31, 40, 28, 51, 42, 82, 56],
    }, {
      name: 'Candidats évalués',
      data: [11, 32, 45, 32, 34, 52, 41]
    }],
    chart: {
      height: 350,
      type: 'area',
      toolbar: {
        show: false
      },
    },
    markers: {
      size: 4
    },
    colors: ['#4154f1', '#2eca6a'],
    fill: {
      type: "gradient",
      gradient: {
        shadeIntensity: 1,
        opacityFrom: 0.3,
        opacityTo: 0.4,
        stops: [0, 90, 100]
      }
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      curve: 'smooth',
      width: 2
    },
    xaxis: {
      type: 'datetime',
      categories: ["2018-09-19T00:00:00.000Z", "2018-09-19T01:30:00.000Z", "2018-09-19T02:30:00.000Z", "2018-09-19T03:30:00.000Z", "2018-09-19T04:30:00.000Z", "2018-09-19T05:30:00.000Z", "2018-09-19T06:30:00.000Z"]
    },
    tooltip: {
      x: {
        format: 'dd/MM/yy HH:mm'
      },
    }
  };

  return (
    <main id="main" className="main">
      <section className="section dashboard">
        <div className="row">
          {/* Total des CV */}
          <div className="col-xxl-4 col-md-6">
            <div className="card info-card sales-card">
              <div className="card-body">
                <h5 className="card-title">Total des CV</h5>
                <div className="d-flex align-items-center">
                  <div className="card-icon rounded-circle d-flex align-items-center justify-content-center">
                    <i className="bi bi-file-earmark-text"></i>
                  </div>
                  <div className="ps-3">
                    <h6>{totalCv}</h6> {/* Utilisez la valeur récupérée */}
                    <p className="text-muted small">Nombre total de CV enregistrés dans le système.</p>
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* Nouveaux CV reçus */}
          <div className="col-xxl-4 col-md-6">
            <div className="card info-card sales-card">
              <div className="filter">
                <a className="icon" href="#1" data-bs-toggle="dropdown"><i className="bi bi-three-dots"></i></a>
                <ul className="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li className="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>
                  <li><a className="dropdown-item" href="#today">Today</a></li>
                  <li><a className="dropdown-item" href="#month">This Month</a></li>
                  <li><a className="dropdown-item" href="#year">This Year</a></li>
                </ul>
              </div>
              <div className="card-body">
                <h5 className="card-title">Nouveaux CV reçus <span>| Aujourd'hui</span></h5>
                <div className="d-flex align-items-center">
                  <div className="card-icon rounded-circle d-flex align-items-center justify-content-center">
                    <i className="bi bi-file-earmark-text"></i>
                  </div>
                  <div className="ps-3">
                    <h6>{nouveauxCv}</h6> {/* Utilisez la valeur récupérée */}
                    <span className="text-success small pt-1 fw-bold"></span> <span className="text-muted small pt-2 ps-1">Nombres de cv reçus</span>
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* Candidats évalués */}
          <div className="col-xxl-4 col-md-6">
            <div className="card info-card revenue-card">
              <div className="filter">
                <a className="icon" href="#2" data-bs-toggle="dropdown"><i className="bi bi-three-dots"></i></a>
                <ul className="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li className="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>
                  <li><a className="dropdown-item" href="#today">Today</a></li>
                  <li><a className="dropdown-item" href="#month">This Month</a></li>
                  <li><a className="dropdown-item" href="#year">This Year</a></li>
                </ul>
              </div>
              <div className="card-body">
                <h5 className="card-title">Candidats évalués <span>| Ce mois-ci</span></h5>
                <div className="d-flex align-items-center">
                  <div className="card-icon rounded-circle d-flex align-items-center justify-content-center">
                    <i className="bi bi-person-check"></i>
                  </div>
                  <div className="ps-3">
                    <h6>{candidatsEvalués}</h6> {/* Utilisez la valeur récupérée ou une valeur d'exemple */}
                    <span className="text-success small pt-1 fw-bold">8%</span> <span className="text-muted small pt-2 ps-1">increase</span>
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* Graphique des rapports */}
          <div className="col-12">
            <div className="card">
              <div className="filter">
                <a className="icon" href="#4" data-bs-toggle="dropdown"><i className="bi bi-three-dots"></i></a>
                <ul className="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li className="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>
                  <li><a className="dropdown-item" href="#today">Today</a></li>
                  <li><a className="dropdown-item" href="#month">This Month</a></li>
                  <li><a className="dropdown-item" href="#year">This Year</a></li>
                </ul>
              </div>
              <div className="card-body">
                <h5 className="card-title">Rapports <span>/ Aujourd'hui</span></h5>
                <ReactApexChart options={chartOptions} series={chartOptions.series} type="area" height={350} />
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
  );
}

export default Acceuil;
