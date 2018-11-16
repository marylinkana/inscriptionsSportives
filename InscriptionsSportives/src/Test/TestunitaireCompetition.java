
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

public class TestunitaireCompetition {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	
	Personne personnetest = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
	Personne personnetest2 = inscriptions.createPersonne("nomtest2", "prenomtest2", "mailtest2");

	Competition competitiontest = inscriptions.createCompetition("nomcompetitiontest",null, false);
	Competition competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", null, true);
	
	Equipe equipetest = inscriptions.createEquipe("nomequipetest");
	Equipe equipetest2 = inscriptions.createEquipe("nomequipetest2");
	
	@Test
	public void testgetNomCompetition()
	{
		assertEquals("nomcompetitiontest",competitiontest.getNom());
	}
	
	@Test
	public void testsetNomCompetition()
	 {
		competitiontest.setNom("setnomcompetitiontest");
		
		String setNom = competitiontest.getNom();
		assertEquals("setnomcompetitiontest", setNom );
	 }
	
	@Test
	public void testinscritionsOuverte()
	{
		assertEquals(true,competitiontest.inscriptionsOuvertes());
	}
	
	@Test
	public void testgetDateColture()
	{
		assertEquals(null,competitiontest.getDateCloture());
	}
	
	@Test
	public void testestEnEquipe()
	{
		assertEquals(true,competitiontest2.estEnEquipe());
	}
	
	@Test
	public void testsetDateCloture()
	{
		LocalDate datetest = LocalDate.of(2014, Month.JANUARY, 1);
		competitiontest.setDateCloture(datetest);
		assertEquals(datetest,competitiontest.getDateCloture());
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
//	public void testgetPersonnesAInscrire() 
//	{
//		assertTrue(competitiontest.getPersonnesAInscrire().contains(personnetest));
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
		competitiontest.delete();
		assertFalse(personnetest2.getCompetitions().contains(competitiontest));
	}
	
	@Test
	public void testcompareTocompetition() {
		Competition competitiontest1bis = inscriptions.createCompetition("nomcompetitiontest",null, false);
		assertEquals(0, competitiontest.compareTo(competitiontest1bis));
	}

}
