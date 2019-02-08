package inscriptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;

public class MenuInscription
{
	public static void main(String[] args)
	{
		// Creates the root menu of the application
		Menu rootMenu = new Menu("Root Menu");
		
		// Creates two options
		//Option competitionOption = new Option("Competition", "C");
		Menu personneMenu = new Menu("Personne Sub-Menu", "Personne", "per");
		Menu equipeMenu = new Menu("Equipe Sub-Menu", "Equipe", "equ");
		Menu competitionMenu = new Menu("Competition Sub-Menu", "Competition", "com");
		
		// Adds an option to the rootMenu 
		//rootMenu.add(competitionOption);
		
		// Adds the sub-menu sayHelloMenu to the rootMenu
		// Please notice that since Menu extends Option, polymorphism allows us to pass the Menu sayHelloMenu where an Option was expected.
		rootMenu.add(personneMenu);
		rootMenu.add(equipeMenu);
		rootMenu.add(competitionMenu);
		
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
		personneMenu.add(				
				new Option("Ajoute une personne", "a", new Action()
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
				}));
		
		personneMenu.add(				
				new Option("Sélectionner une personne", "s", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des candidat : ");
                		Inscriptions inscriptions = Inscriptions.getInscriptions();
						SortedSet<Personne> lesCandidats = inscriptions.getPersonnes();
						System.out.println( lesCandidats );
						
					}
				}));
		 	
		equipeMenu.add(				
				new Option("Ajoute une équipe", "a", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Enter le nom de l'équipe à ajouter ");
						String nom = InOut.getString("Nom : ");
                		Inscriptions inscriptions = Inscriptions.getInscriptions();
                        Equipe equipe = inscriptions.createEquipe(nom);
					}
				}));
		
		equipeMenu.add(				
				new Option("Sélectionner une équipe", "s", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des équipes : ");
						Inscriptions inscriptions = Inscriptions.getInscriptions();
						SortedSet<Equipe> lesEquipes = inscriptions.getEquipes();
						System.out.println( lesEquipes );
						
					}
				}));
		
		competitionMenu.add(				
				new Option("Ajoute une competition", "a", new Action()
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
				}));
		
		competitionMenu.add(				
				new Option(" Sélectionnez une competition", "s", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des competition : ");
						Inscriptions inscriptions = Inscriptions.getInscriptions();
						SortedSet<Competition> lesCompetitions = inscriptions.getCompetitions();
						System.out.println( lesCompetitions );
					}
				}));
		
		// Adds an option to go back to the rootMenu
		personneMenu.addBack("r");
		equipeMenu.addBack("r");
		competitionMenu.addBack("r");
		
		// Once an option has been selected in sayHelloMenu, and the associated action is done, we will automatically go back to the rootMenu. 
		personneMenu.setAutoBack(true);
		equipeMenu.setAutoBack(true);
		competitionMenu.setAutoBack(true);
		
		rootMenu.start();
	}
}
