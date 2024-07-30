import React, { useEffect, useRef } from 'react';
import styled from 'styled-components';
import { gsap } from 'gsap';
import { ScrollTrigger } from 'gsap/ScrollTrigger';
import Navbars from '../components/Navbars';

const Home = () => {
  const titleRef = useRef(null);
  
  const sectionsRef = useRef([]);

  useEffect(() => {
    gsap.registerPlugin(ScrollTrigger);

    const ctx = gsap.context(() => {
      const tl = gsap.timeline();
      tl.fromTo(
        titleRef.current,
        { opacity: 0, y: -50 },
        { opacity: 1, y: 0, duration: 1, ease: 'power3.out' }
      );

      // Animation pour les sections principales avec ScrollTrigger
      gsap.from(sectionsRef.current, {
        scrollTrigger: {
          trigger: sectionsRef.current,
          start: "top bottom",
        },
        opacity: 0,
        y: 50,
        duration: 1,
        stagger: 0.3,
      });

      // Animation de l'image
     
    });

    return () => {
      ctx.revert();
      ScrollTrigger.getAll().forEach((trigger) => trigger.kill());
    };
  }, []);

  return (
    <Container>
      <Navbars />
      <Banner>
        <h1 ref={titleRef}>Bienvenue sur mon site Gestion CV</h1>
        <p>Votre outil pour gérer vos CV efficacement</p>
      </Banner>
      <MainContent>
        <Section className="animate-section" ref={el => sectionsRef.current[0] = el}>
          <h2>Nos Services</h2>
          <p>Contenu des services ici...</p>
        </Section>
        <Section className="animate-section" ref={el => sectionsRef.current[1] = el}>
          <h2>À Propos</h2>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat enim quis odio ultrices, ac gravida est faucibus.</p>
          <p>Autres informations ici...</p>
        </Section>
      </MainContent>
      
    </Container>
  );
};

const Container = styled.div`
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
`;

const Banner = styled.div`
  background-color: #333;
  color: #fff;
  padding: 60px 20px;
  text-align: center;

  h1 {
    font-size: 2.5em;
    margin: 0;
  }

  p {
    font-size: 1.2em;
    margin-top: 10px;
  }
`;

const MainContent = styled.div`
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
`;

const Section = styled.div`
  flex: 1;
  margin-right: 20px;

  h2 {
    margin-bottom: 20px;
  }
`;



export default Home;

