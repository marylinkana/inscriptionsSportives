
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

public class CompetitionTest {
	
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

		competitiontest = inscriptions.createCompetition("nomcompetitiontest",LocalDate.now().plusDays(30), false);
		competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", LocalDate.now().plusDays(60), true);
		
		equipetest = inscriptions.createEquipe("nomequipetest");
		equipetest2 = inscriptions.createEquipe("nomequipetest2");
       
    }

    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }
    
	@Test
	public void testgetNomCompetition()
	{
		assertEquals("nomcompetitiontest",competitiontest.getNom());
	}
	
	@Test
	public void testsetNomCompetition()
	 {
		competitiontest.setNom("setnomcompetitiontest");
		assertEquals("setnomcompetitiontest", competitiontest.getNom() );
	 }
	
	@Test
	public void testinscritionsOuverte()
	{
		assertEquals(true,competitiontest.inscriptionsOuvertes());
		assertEquals(true,competitiontest2.inscriptionsOuvertes());

	}
	
	@Test
	public void testgetDateColture()
	{
		assertEquals(LocalDate.now().plusDays(30),competitiontest.getDateCloture());
	}
	
	@Test
	public void testestEnEquipe()
	{
		assertEquals(true,competitiontest2.estEnEquipe());
	}
	
	@Test
	public void testsetDateCloture()
	{
		competitiontest.setDateCloture(LocalDate.now().plusDays(90));
		assertEquals(LocalDate.now().plusDays(90),competitiontest.getDateCloture());
	}
	
	@Test
	public void testgetCandidat()
	{
		competitiontest.add(personnetest);
		assertTrue(competitiontest.getCandidats().contains(personnetest));
	}
	
	@Test
	public void testaddpersonne()
	{
		competitiontest.add(personnetest2);
		assertTrue(competitiontest.getCandidats().contains(personnetest2));

	}
	
	@Test
	public void testaddequipe()	
	{
		competitiontest2.add(equipetest);
		assertTrue(competitiontest2.getCandidats().contains(equipetest));
	}
	
//	@Test
//	public void testgetCandidatsAInscrire() 
//	{
//		assertTrue(!competitiontest.getCandidatsAInscrire().contains(personnetest));
//	}
	
	@Test
	public void testremove()
	{
		competitiontest.add(personnetest2);
		assertTrue(competitiontest.getCandidats().contains(personnetest2));
		competitiontest.remove(personnetest2);
		assertFalse(competitiontest.getCandidats().contains(personnetest2));
	}
	
	@Test
	public void testdelete() {
		competitiontest.add(personnetest2);
		assertTrue(competitiontest.getCandidats().contains(personnetest2));
		competitiontest2.add(equipetest2);
		assertTrue(competitiontest2.getCandidats().contains(equipetest2));
		competitiontest.delete();
		assertFalse(personnetest2.getCompetitions().contains(competitiontest));
		assertFalse(equipetest2.getCompetitions().contains(competitiontest));
		

	}
	
	@Test
	public void testcompareTocompetition() {
		Competition competitiontest1bis = inscriptions.createCompetition("nomcompetitiontest",null, false);
		assertEquals(0, competitiontest.compareTo(competitiontest1bis));
	}

}
