package Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import inscriptions.Equipe;


public class InscriptionTest {
	
	Inscriptions inscriptions ;

    Personne personnetest ;
    Personne personnetest2 ;

    Equipe equipetest; 
    Equipe equipetest2;
    
    Competition competitiontest ;
    Competition competitiontest2 ;
   
	
	@Before
    public void setUp() {
		inscriptions = Inscriptions.getInscriptions();
		
		personnetest = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
		personnetest2 = inscriptions.createPersonne("nomtest2", "prenomtest2", "mailtest2");

		competitiontest = inscriptions.createCompetition("nomcompetitiontest", LocalDate.now().plusDays(30), false);
		competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", LocalDate.now().plusDays(60), true);
		
		equipetest = inscriptions.createEquipe("nomequipetest");
		equipetest2 = inscriptions.createEquipe("nomequipetest2");
       
    }

    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }

	
	@Test
	public void testgetCompetitions() {
		assertTrue(inscriptions.getCompetitions().contains(competitiontest));
		assertTrue(inscriptions.getCompetitions().contains(competitiontest2));

	}
	
	@Test
	public void testgetCandidats() {
		assertTrue(inscriptions.getCandidats().contains(personnetest));
		assertTrue(inscriptions.getCandidats().contains(equipetest));
	}
	
	@Test
	public void testgetPersonnes() {
		assertTrue(inscriptions.getPersonnes().contains(personnetest2));
	}
	
	@Test
	public void testgetEquipes() {
		assertTrue(inscriptions.getEquipes().contains(equipetest2));
	}
	
	@Test
	public void testcreateCompetition() {
		Competition competitiontest2bis = inscriptions.createCompetition("nomcompetitiontest2bis", LocalDate.now().plusDays(30), true);
		assertTrue(inscriptions.getCompetitions().contains(competitiontest2bis));
	}
	
	@Test
	public void testcreatePersonne() {
		Personne personnetest2bis = inscriptions.createPersonne("nomtest2bis", "prenomtest2bis", "mailtest2bis");
		assertTrue(inscriptions.getPersonnes().contains(personnetest2bis));
	}
	
	@Test
	public void testcreateEquipe() {
		Equipe equipetest2bis = inscriptions.createEquipe("nomequipetest2bis");
		assertTrue(inscriptions.getEquipes().contains(equipetest2bis));
	}
	
	@Test
	public void testgetInscriptions()
	{
		assertEquals(inscriptions, Inscriptions.getInscriptions());
	}
	
	@Test
	public void testreinitialiser() {
		inscriptions.reinitialiser();
		assertFalse(inscriptions.getInscriptions().getPersonnes().contains(personnetest));
	}
		
	@Test
	public void testrecharger() {
		inscriptions.recharger();
		assertFalse(inscriptions.getInscriptions().getPersonnes().contains(personnetest));
	}

	@Test
	public void testsauvegarder() throws IOException {
		inscriptions.sauvegarder();
		Personne personnetestbis = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
		inscriptions.recharger();
		assertTrue(inscriptions.getInscriptions().getCandidats().contains(personnetest));
		assertFalse(inscriptions.getInscriptions().getCandidats().contains(personnetestbis));
	}
	
	
	
	
	
	
	
}
