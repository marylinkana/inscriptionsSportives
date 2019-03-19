package Menus;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

import Inscriptions.*;
import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;

public class MenuInscription
{
	private Menu getCompetitionMenu(Inscriptions inscriptions)
	{
		Menu competitionMenu = new Menu("Competition Sub-Menu", "competition", "com");
		competitionMenu.add(MenuCompetition.getCompetitionList(inscriptions));
		competitionMenu.add(MenuCompetition.creerCompetitionOption(inscriptions));
		competitionMenu.addBack("r");

		return competitionMenu;
	}
	
	private Menu getEquipeMenu(Inscriptions inscriptions)
	{
		Menu equipeMenu = new Menu("Equipe Sub-Menu", "Equipe", "equ");
		equipeMenu.add(MenuEquipe.getEquipeList(inscriptions));
		equipeMenu.add(MenuEquipe.creerEquipeOption(inscriptions));
		equipeMenu.addBack("r");

		return equipeMenu;
	}
	
	private Menu getPersonneMenu(Inscriptions inscriptions)
	{
		Menu personneMenu = new Menu("Personne Sub-Menu", "Personne", "per");
		personneMenu.add(MenuPersonne.getPersonneList(inscriptions));
		personneMenu.add(MenuPersonne.creerPersonneOption(inscriptions));
		personneMenu.addBack("r");

		return personneMenu;
	}
	
	public MenuInscription(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;

		
		Menu rootMenu = new Menu("Root Menu");
		
		rootMenu.add(getCompetitionMenu(inscriptions));
		rootMenu.add(getEquipeMenu(inscriptions));
		rootMenu.add(getPersonneMenu(inscriptions));
		rootMenu.addQuit("q");
		rootMenu.start();

	}
	

	private Inscriptions inscriptions;
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	

	


}

