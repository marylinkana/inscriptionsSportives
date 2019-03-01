package menus;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.SortedSet;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

public class MenuCompetition {
//
//	public static Menu getCompetitionMenu()
//	{
//		Menu competitionMenu = new Menu("Competition Sub-Menu", "competition", "com");
//		return competitionMenu;
//	}
//	
//	
//	getCompetitionMenu().add(afficherCandidatOption());
//	getCompetitionMenu().add(afficherInscriptionOption());
//	getCompetitionMenu().add(afficherCompetitionOption());
//	getCompetitionMenu().add(creerCompetitionOption());
//	
//	getCompetitionMenu().addBack("r");
//	getCompetitionMenu().setAutoBack(true);
//	
//	
//	private static  Option afficherInscriptionOption() {
//		return new Option("Afficher les Inscriptions", "afinsc", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Liste des inscriptions : ");
//				Inscriptions lesInscriptions = Inscriptions.getInscriptions();
//				System.out.println( lesInscriptions );
//			}
//		});
//	}
//	
//	private static  Option afficherCompetitionOption() {
//		return new Option("Afficher les Competitions", "afcomp", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Liste des competition : ");
//        		Inscriptions inscriptions = Inscriptions.getInscriptions();
//				SortedSet<Competition> lesCompetitions = inscriptions.getCompetitions();
//				System.out.println( lesCompetitions );
//			}
//		});
//	}
//	
//	private static  Option afficherCandidatOption() {
//		return new Option("Afficher le Candidats", "afcand", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Liste des candidats : ");
//        		Inscriptions inscriptions = Inscriptions.getInscriptions();
//				SortedSet<Candidat> lesCandidats = inscriptions.getCandidats();
//				System.out.println( lesCandidats );
//			}
//		});
//	}
//	
//
//	private static  Option creerCompetitionOption() {
//		return new Option("Créer une competition", "crcomp", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Enter le nom, le nombre de jour jusqu'a la ate de cloture puis true si la competition est en équipe ou sinon false  ");
//				String nom = InOut.getString("Nom : ");
//				System.out.print("nombre de jour :");
//				Scanner scanner = new Scanner(System.in);
//		        int day = scanner.nextInt();
//		        LocalDate date = LocalDate.now().plusDays(day);
//				System.out.print("enEquipe :");
//		        boolean enEquipe = scanner.nextBoolean();
//	    		Inscriptions inscriptions = Inscriptions.getInscriptions();
//	            Competition competition = inscriptions.createCompetition(nom, date, enEquipe);
//			}
//		});
//	}

}