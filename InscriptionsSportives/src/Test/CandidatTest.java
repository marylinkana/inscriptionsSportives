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


public class CandidatTest {
	
	Inscriptions inscriptions ;

    Personne personnetest ;
    Personne personnetest2 ;

    Equipe equipetest; 
    Equipe equipetest2;
    
    Competition competitiontest ;
    Competition competitiontest2 ;
   
	
	@Before
    public void setUp() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		
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
	public void testgetNom()
	 {
		String getNom = personnetest.getNom();
		assertEquals("nomtest", getNom);
	 }
	
	@Test
	public void testsetNom()
	 {
		personnetest.setNom("nomsettest");
		
		String nomset = personnetest.getNom();
		assertEquals("nomsettest", nomset );
		
	 }
	
	@Test
	public void testgetCompetition()
	{
		competitiontest.add(personnetest);
		equipetest.add(personnetest);
		
		assertTrue(personnetest.getCompetitions().contains(competitiontest));
	}
	
	@Test
	public void testdelate()
	{
		personnetest2.delete();
		assertTrue(!inscriptions.getCandidats().contains(personnetest2));
	}
	
	@Test
	public void testcompareTopersonne()
	{
		Personne personnetestbis = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
		assertEquals(0, personnetest.compareTo(personnetestbis) );
	}
	
	@Test
	public void testtoString()
	{
		assertTrue(!personnetest.toString().contentEquals(""));
	}
	
}
	