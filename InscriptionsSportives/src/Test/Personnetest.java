package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Set;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import inscriptions.Equipe;

public class Personnetest {

	Inscriptions inscriptions = Inscriptions.getInscriptions();
	
	Personne personnetest = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
	Personne personnetest2 = inscriptions.createPersonne("nomtest2", "prenomtest2", "mailtest2");

	Competition competitiontest = inscriptions.createCompetition("nomcompetitiontest",null, false);
	Competition competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", null, true);
	
	Equipe equipetest = inscriptions.createEquipe("nomequipetest");
	Equipe equipetest2 = inscriptions.createEquipe("nomequipetest2");
	
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
		
		String mailset = personnetest.getPrenom();
		assertTrue(mailset.contains("mailsettest") );
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
