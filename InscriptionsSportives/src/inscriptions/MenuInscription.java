package inscriptions;

import java.util.ArrayList;
import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;

public class MenuInscription
{
	public static void main(String[] args)
	{
		// Creates the root menu of the application
		Menu rootMenu = new Menu("Root Menu");
		
		// Creates two options
		//Option competitionOption = new Option("Competition", "C");
		Menu candidatMenu = new Menu("Candidat Sub-Menu", "Candidat", "can");
		Menu equipeMenu = new Menu("Equipe Sub-Menu", "Equipe", "equ");
		Menu competitionMenu = new Menu("Competition Sub-Menu", "Competition", "com");
		
		// Adds an option to the rootMenu 
		//rootMenu.add(competitionOption);
		
		// Adds the sub-menu sayHelloMenu to the rootMenu
		// Please notice that since Menu extends Option, polymorphism allows us to pass the Menu sayHelloMenu where an Option was expected.
		rootMenu.add(candidatMenu);
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
		candidatMenu.add(				
				new Option("Ajoute un candidat", "a", new Action()
				{
					public void optionSelected()
					{
						System.out.println("fonction pour ajouter un candidat ");
					}
				}));
		
		candidatMenu.add(				
				new Option("Sélectionner un candidat", "m", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des candidat : ");
					}
				}));
		 	
		equipeMenu.add(				
				new Option("Ajoute une équipe", "A", new Action()
				{
					public void optionSelected()
					{
						System.out.println("fonction pour ajouter une equipe ");
					}
				}));
		
		equipeMenu.add(				
				new Option("Sélectionner une équipe", "m", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des équipes : ");
					}
				}));
		
		competitionMenu.add(				
				new Option("Ajoute une competition", "a", new Action()
				{
					public void optionSelected()
					{
						System.out.println("v ");
					}
				}));
		
		competitionMenu.add(				
				new Option("Sélectionner une competition", "M", new Action()
				{
					public void optionSelected()
					{
						System.out.println("Liste des competition : ");
					}
				}));
		
		// Adds an option to go back to the rootMenu
		candidatMenu.addBack("r");
		equipeMenu.addBack("r");
		competitionMenu.addBack("r");
		
		// Once an option has been selected in sayHelloMenu, and the associated action is done, we will automatically go back to the rootMenu. 
		candidatMenu.setAutoBack(true);
		equipeMenu.setAutoBack(true);
		competitionMenu.setAutoBack(true);
		
		rootMenu.start();
	}
}
