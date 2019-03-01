package menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class MenuEquipe {
//
//	public static Menu getEquipeMenu()
//	{
//		Menu equipeMenu = new Menu("Equipe Sub-Menu", "Equipe", "equ");
//		return equipeMenu;
//	}
//	
//	getEquipeMenu().add(afficheEquipeOption());
//	getEquipeMenu().add(creerEquipeOption());
//	
//	getEquipeMenu().addBack("r");
//	getEquipeMenu().setAutoBack(true);
//	
//	
//	private static  Option afficheEquipeOption() {
//		return new Option("Afficher les équipes", "afequi", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Liste des équipes : ");
//				Inscriptions inscriptions = Inscriptions.getInscriptions();
//				SortedSet<Equipe> lesEquipes = inscriptions.getEquipes();
//				System.out.println( lesEquipes );
//				
//			}
//		});
//	}
//	
//	private static  Option creerEquipeOption() {
//		return new Option("Créer une équipe", "crequi", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Enter le nom de l'équipe à ajouter ");
//				String nom = InOut.getString("Nom : ");
//	    		Inscriptions inscriptions = Inscriptions.getInscriptions();
//	            Equipe equipe = inscriptions.createEquipe(nom);
//			}
//		});
//	}
}
