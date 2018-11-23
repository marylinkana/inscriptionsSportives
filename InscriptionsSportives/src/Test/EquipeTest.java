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

public class EquipeTest {
	
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
	public void testgetMembres() {
		equipetest.add(personnetest);
		assertTrue(equipetest.getMembres().contains(personnetest));
	}
	
	@Test
	public void testadd() {
		equipetest2.add(personnetest2);
		assertTrue(equipetest2.getMembres().contains(personnetest2));
	}
	
	@Test
	public void remove() {
		equipetest2.add(personnetest2);
		equipetest2.remove(personnetest2);
		assertFalse(equipetest2.getMembres().contains(personnetest2));
	}
	
//	@Test
//	public void testgetPersonnesAAjouter() {
//		equipetest.add(personnetest);
//		assertTrue(!equipetest2.getPersonnesAAjouter().contains(personnetest));
//	}
	
	@Test
	public void testdelete() {
		competitiontest.add(personnetest2);
		equipetest.add(personnetest2);
		personnetest2.delete();
		assertTrue(!competitiontest.getCandidats().contains(personnetest2));
		assertTrue(!equipetest.getMembres().contains(personnetest2));
	}
	
	
	
	
}