import React, { useEffect, useRef } from 'react';
import { Container, Nav, Navbar, Image } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { gsap } from 'gsap';

const Navbars = () => {
  const imageRef = useRef(null);

  useEffect(() => {
    const tl = gsap.timeline();
    tl.to(imageRef.current, { x: 60, rotation: 360, duration: 1, ease: 'power3.in' })
      .to(imageRef.current, { x: 0, rotation: 0, duration: 1, ease: 'power3.out' });
  }, []);

  return (
    <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand as={Link} to="/">
          <Image
            ref={imageRef}
            src="../assets/img/logo.jpg"
            alt="Gestion CV Logo"
            height="80"
          />
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
          <Nav>
            <Nav.Link as={Link} to="/home">Accueil</Nav.Link>
            <Nav.Link as={Link} to="/login">Login</Nav.Link>
            <Nav.Link as={Link} to="/signup">Signup</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Navbars;
