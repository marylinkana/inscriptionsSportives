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

public class MenuCandidat {


		public MenuCandidat()
		{
			
					// Creates the root menu of the application
					Menu rootMenu = new Menu("Root Menu");
					
					// Creates two options
					//Option competitionOption = new Option("Competition", "C");
					Menu candidat = new Menu("Candidat Sub-Menu", "Candidat", "can");
					
					// Adds an option to the rootMenu 
					//rootMenu.add(competitionOption);
					
					// Adds the sub-menu sayHelloMenu to the rootMenu
					// Please notice that since Menu extends Option, polymorphism allows us to pass the Menu sayHelloMenu where an Option was expected.
					rootMenu.add(candidat);

					
					// Adds the quit option
					rootMenu.addQuit("q");
					
					// Defines the action that will be triggered if the calculator is selected.
//					competitionOption.setAction(new Action()
//					{
//						// Method triggered if the calculatorOption is selected 
//						public void optionSelected()
//						{
//							int a = InOut.getInt("Input the first operand : "),
//									b = InOut.getInt("Input the second operand : ");
//							System.out.println("" + a + " + " + b + " = " + (a+b));
//						}
//					});
//					
					// Please notice that the action can be passed to the constructor of Option 
					
					
					candidat.add(afficherCandidatOption());
					
					
					// Adds an option to go back to the rootMenu
					candidat.addBack("r");

					
					// Once an option has been selected in sayHelloMenu, and the associated action is done, we will automatically go back to the rootMenu. 
					candidat.setAutoBack(true);

					rootMenu.start();
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
				

}


