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

public class MenuInscription
{
	public MenuInscription()
	{
		// Creates the root menu of the application
		Menu rootMenu = new Menu("Root Menu");
		
		// Creates two options
		//Option competitionOption = new Option("Competition", "C");
		Menu inscriptionMenu = new Menu("Inscription Sub-Menu", "Inscription", "ins");
		
		// Adds an option to the rootMenu 
		//rootMenu.add(competitionOption);
		
		// Adds the sub-menu sayHelloMenu to the rootMenu
		// Please notice that since Menu extends Option, polymorphism allows us to pass the Menu sayHelloMenu where an Option was expected.
		rootMenu.add(inscriptionMenu);

		
		// Adds the quit option
		rootMenu.addQuit("q");
		
		// Defines the action that will be triggered if the calculator is selected.
//		competitionOption.setAction(new Action()
//		{
//			// Method triggered if the calculatorOption is selected 
//			public void optionSelected()
//			{
//				int a = InOut.getInt("Input the first operand : "),
//						b = InOut.getInt("Input the second operand : ");
//				System.out.println("" + a + " + " + b + " = " + (a+b));
//			}
//		});
//		
		// Please notice that the action can be passed to the constructor of Option 
		
		inscriptionMenu.add(afficherInscriptionOption());
		
		inscriptionMenu.add(afficherCompetitionOption());
		
		inscriptionMenu.add(afficherCandidatOption());
		
		inscriptionMenu.add(afficheEquipeOption());
		
		inscriptionMenu.add(affichePersonneOption());
		
		inscriptionMenu.add(creerCompetitionOption());
		
		inscriptionMenu.add(creerEquipeOption());
		
		inscriptionMenu.add(creerPersonneOption());
		
		
		// Adds an option to go back to the rootMenu
		inscriptionMenu.addBack("r");

		
		// Once an option has been selected in sayHelloMenu, and the associated action is done, we will automatically go back to the rootMenu. 
		inscriptionMenu.setAutoBack(true);

		rootMenu.start();
	}
	
	private static  Option afficherInscriptionOption() {
		return new Option("Afficher les Inscriptions", "afinsc", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Liste des inscriptions : ");
				Inscriptions lesInscriptions = Inscriptions.getInscriptions();
				System.out.println( lesInscriptions );
			}
		});
	}
	
	private static  Option afficherCompetitionOption() {
		return new Option("Afficher les Competitions", "afcomp", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Liste des competition : ");
        		Inscriptions inscriptions = Inscriptions.getInscriptions();
				SortedSet<Competition> lesCompetitions = inscriptions.getCompetitions();
				System.out.println( lesCompetitions );
			}
		});
	}
	
	private static  Option afficherCandidatOption() {
		return new Option("Afficher le Candidats", "afcand", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Liste des candidats : ");
        		Inscriptions inscriptions = Inscriptions.getInscriptions();
				SortedSet<Candidat> lesCandidats = inscriptions.getCandidats();
				System.out.println( lesCandidats );
			}
		});
	}
	
	private static  Option afficheEquipeOption() {
		return new Option("Afficher les équipes", "afequi", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Liste des équipes : ");
				Inscriptions inscriptions = Inscriptions.getInscriptions();
				SortedSet<Equipe> lesEquipes = inscriptions.getEquipes();
				System.out.println( lesEquipes );
				
			}
		});
	}
	
	private static  Option affichePersonneOption() {
		return new Option("Afficher les personnes", "afpers", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Liste des personnes : ");
        		Inscriptions inscriptions = Inscriptions.getInscriptions();
				SortedSet<Personne> lesPersonnes = inscriptions.getPersonnes();
				System.out.println( lesPersonnes );
				
			}
		});
	}
	
	private static  Option creerCompetitionOption() {
		return new Option("Créer une competition", "crcomp", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Enter le nom, le nombre de jour jusqu'a la ate de cloture puis true si la competition est en équipe ou sinon false  ");
				String nom = InOut.getString("Nom : ");
				System.out.print("enEquipe :");
				Scanner scanner = new Scanner(System.in);
		        int day = scanner.nextInt();
		        LocalDate date = LocalDate.now().plusDays(day);
				System.out.print("enEquipe :");
		        boolean enEquipe = scanner.nextBoolean();
        		Inscriptions inscriptions = Inscriptions.getInscriptions();
                Competition competition = inscriptions.createCompetition(nom, date, enEquipe);
			}
		});
	}
	
	private static  Option creerEquipeOption() {
		return new Option("Créer une équipe", "crequi", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Enter le nom de l'équipe à ajouter ");
				String nom = InOut.getString("Nom : ");
	    		Inscriptions inscriptions = Inscriptions.getInscriptions();
	            Equipe equipe = inscriptions.createEquipe(nom);
			}
		});
	}
	
	private static  Option creerPersonneOption() {
		return new Option("créer une personne", "crpers", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Enter le nom, le prenom et l'adresse email de la personne que vous voulez ajouter ");
				String nom = InOut.getString("Nom : ");
				String prenom = InOut.getString("Prénom : ");
                String mail = InOut.getString("Email : ");
        		Inscriptions inscriptions = Inscriptions.getInscriptions();
                Personne personne = inscriptions.createPersonne(nom, prenom, mail);
			}
		});
	}

}
