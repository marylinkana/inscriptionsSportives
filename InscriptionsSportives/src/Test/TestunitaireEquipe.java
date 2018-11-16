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

public class TestunitaireEquipe {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	
	Personne personnetest = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
	Personne personnetest2 = inscriptions.createPersonne("nomtest2", "prenomtest2", "mailtest2");

	Competition competitiontest = inscriptions.createCompetition("nomcompetitiontest",null, false);
	Competition competitiontest2 = inscriptions.createCompetition("nomcompetitiontest2", null, true);
	
	Equipe equipetest = inscriptions.createEquipe("nomequipetest");
	Equipe equipetest2 = inscriptions.createEquipe("nomequipetest2");
	
	@Test
	public void testgetMembres() {
		equipetest.add(personnetest);
		assertEquals(personnetest, equipetest.getMembres());
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
//		
//		assertTrue(equipetest2.getPersonnesAAjouter().contains(personnetest));
//	}
	
//	@Test
//	public void testdelete() {
//		personnetest2.delete();
//		assertFalse( );
//	}
}