package inscriptions;

import java.util.ArrayList;
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
						System.out.println("fonction pour ajouter un candidat ");
					}
				}));
		
		personneMenu.add(				
				new Option("Sélectionner une personne", "s", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des candidat : ");
						
						
					}
				}));
		 	
		equipeMenu.add(				
				new Option("Ajoute une équipe", "a", new Action()
				{
					public void optionSelected()
					{
						System.out.println("fonction pour ajouter une equipe ");
					}
				}));
		
		equipeMenu.add(				
				new Option("Sélectionner une équipe", "s", new Action()
				{
					public void optionSelected()
					{
//						System.out.println("Liste des équipes : ");
						java.util.List<String> equipe = new ArrayList<>();
						equipe.add("Amandine");
						equipe.add("Yann");
						equipe.add("Cefkan");
						
					}
				}));
		
		competitionMenu.add(				
				new Option("Ajoute une competition", "a", new Action()
				{
					public void optionSelected()
					{
						System.out.println("fonction pour ajouter une competition ");
					}
				}));
		
		competitionMenu.add(				
				new Option(" Sélectionnez une competition", "s", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des competition : ");
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
