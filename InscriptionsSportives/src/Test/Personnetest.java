package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Inscriptions.Candidat;
import Inscriptions.Competition;
import Inscriptions.Equipe;
import Inscriptions.Inscriptions;
import Inscriptions.Personne;

public class Personnetest {
	
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

		competitiontest = inscriptions.createCompetition("nomcompetitiontest",LocalDate.now().plusDays(30) , false);
		competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", LocalDate.now().plusDays(60), true);
		
		equipetest = inscriptions.createEquipe("nomequipetest");
		equipetest2 = inscriptions.createEquipe("nomequipetest2");
       
    }

    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }
    
	@Test
	public void testgetPrenom()
	 {
		String getNom = personnetest.getPrenom();
		assertEquals("prenomtest", getNom );
	 }
	
	@Test
	public void testsetprenom()
	 {
		personnetest.setPrenom("setprenomtest");
		
		String prenomset = personnetest.getPrenom();
		assertEquals("setprenomtest", prenomset );
		
	 }
	
	@Test
	public void testgetMail()
	 {
		String mailget = personnetest.getMail();
		assertEquals("mailtest", mailget );
	 }
	
	@Test
	public void testsetMail()
	 {
		personnetest.setMail("mailsettest");
		assertEquals("mailsettest", personnetest.getMail());
	 }
	
	@Test
	public void testgeEquipes()
	 {
		equipetest.add(personnetest);
		assertTrue(personnetest.getEquipes().contains(equipetest) );
	 }
	
	@Test
	public void testdelete() {
		personnetest.delete();
		assertTrue(!inscriptions.getCandidats().contains(personnetest));
		assertTrue(!equipetest.getMembres().contains(personnetest));
		assertTrue(!competitiontest.getCandidats().contains(personnetest));
	}
	
}
