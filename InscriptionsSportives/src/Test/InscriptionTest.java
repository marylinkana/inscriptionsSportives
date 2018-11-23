package Test;

import static org.junit.Assert.*;

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

		competitiontest = inscriptions.createCompetition("nomcompetitiontest",null, false);
		competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", null, true);
		
		equipetest = inscriptions.createEquipe("nomequipetest");
		equipetest2 = inscriptions.createEquipe("nomequipetest2");
       
    }

    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }

	
	@Test
	public void testgetCompetitions() {
		assertEquals(competitiontest, inscriptions.getCompetitions());
	}
	
	@Test
	public void testgetCandidats() {
		assertEquals(personnetest, inscriptions.getCandidats());
		assertEquals(equipetest, inscriptions.getCandidats());
	}
	
	@Test
	public void testgetPersonnes() {
		assertEquals(personnetest2, inscriptions.getCandidats());
	}
	
	@Test
	public void testgetEquipes() {
		assertEquals(equipetest2, inscriptions.getCandidats());
	}
	
	@Test
	public void testcreateCompetition() {
		Competition competitiontest2bis = inscriptions.createCompetition("nomcompetitiontest2bis", null, true);
		assertEquals(competitiontest2bis, inscriptions.getCompetitions());
	}
	
	@Test
	public void testcreatePersonne() {
		Personne personnetest2bis = inscriptions.createPersonne("nomtest2bis", "prenomtest2bis", "mailtest2bis");
		assertEquals(personnetest2bis, inscriptions.getCompetitions());
	}
	
	@Test
	public void testcreateEquipe() {
		Equipe equipetest2bis = inscriptions.createEquipe("nomequipetest2bis");
		assertEquals(equipetest2bis, inscriptions.getCompetitions());
	}
	
	@Test
	public void testgetInscriptions() {
		Equipe equipetest2bis = inscriptions.createEquipe("nomequipetest2bis");
		assertEquals(inscriptions, inscriptions.getInscriptions());
	}
	
//	@Test
//	public void testreinitialiser() {
//		inscriptions.reinitialiser();
//		assertNull(competitiontest.getCandidats());
//	}
		
//	@Test
//	public void testrecharger() {
//		assertNotNull(inscriptions.recharger());
//	}
	
//	@Test
//	public void testsauvegarder() {
//		inscriptions.sauvegarder();
//	}
	
	
	
	
	
	
	
}
