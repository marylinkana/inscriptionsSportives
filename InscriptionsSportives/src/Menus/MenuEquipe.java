package Menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

import Inscriptions.Candidat;
import Inscriptions.Competition;
import Inscriptions.Equipe;
import Inscriptions.Inscriptions;
import Inscriptions.Personne;
import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;

public class MenuEquipe {

	void EquipeListOptions(Inscriptions inscriptions)
	{
		List<Equipe> list = getEquipeList(inscriptions);
		list.start();
	}
	
	 // Returns the list to print
		public static List<Equipe> getEquipeList(Inscriptions inscriptions)
		{
			List<Equipe> liste = new List<>("Select equipe", "s",
					getListEquipe(inscriptions),
					getOptionListEquipe());
			liste.setAutoBack(false);
			liste.addQuit("q");
			liste.addBack("r");
			return liste;
		}
		
		private static ListData<Equipe> getListEquipe(Inscriptions inscriptions)
		{
			return new ListData<Equipe>()
			{
				@Override
				public java.util.List<Equipe> getList()
				{
					return new ArrayList<>(inscriptions.getEquipes());
				}
			};
		}
		
		private static ListOption<Equipe> getOptionListEquipe()
		{
			return new ListOption<Equipe>()
			{
				// Each person will become an option
				// The following method returns the option 
				// associated with each one. 
				public Option getOption(Equipe equipe)
				{
					return getEquipeMenu(equipe);
				}
			};
		}
		
		// Creates an sub-menu for someone. 
		private static Option getEquipeMenu(final Equipe equipe)
		{
			Menu equipeMenu = new Menu("Edit " + equipe.getNom(), equipe.getNom(), null);
			equipeMenu.add(afficheNomEquipe(equipe));
			equipeMenu.add(afficheCompetitionEquipe(equipe));
			equipeMenu.add(editMemberEquipe(equipe));
			equipeMenu.add(supprimeEquipe(equipe));
			equipeMenu.setAutoBack(true);
			return equipeMenu;
		}
		
		private static Menu editMemberEquipe(Equipe equipe)
		{
			Menu competitionMenu = new Menu("edit member to équipe Sub-Menu", "Membres", "me");
			competitionMenu.add(getMembreOfEquipe(equipe));
			competitionMenu.add(addMemberToEquipe(equipe));
			competitionMenu.add(removeMemberToEquipe(equipe));
			competitionMenu.addBack("r");

			return competitionMenu;
		}
		
		// Returns the option to display someone
		private static Option afficheCompetitionEquipe(Equipe equipe) {
			return new Option("show groupe", "shg", new Action()
					
					{
						@Override
						public void optionSelected()
						{
							System.out.println("competition : " + equipe.getCompetitions() + ".");

						}
					});
		}
		
		private static Option getMembreOfEquipe(Equipe equipe)
		{
			return new Option("show Member", "1", new Action()
			{
				@Override
				public void optionSelected()
				{
					System.out.println("Liste des membres :");
					System.out.println(equipe.getMembres());

				}
			});
		}
		
		private static Option addMemberToEquipe(Equipe equipe) {
	        return new List<>(
	                "Ajouter un membre à l'équipe", "2",
	                new ListData<Personne>()
	                {
	                    @Override
	                    public java.util.List<Personne> getList() {
	                        return new ArrayList<>(equipe.getPersonnesAAjouter());
	                    }
	                },
	                new ListAction<Personne>()
	                {
	                    @Override
	                    public void itemSelected(int i, Personne personne) {
	                        equipe.add(personne);
	                    }

	                }
	        );
	    }
		
		private static Option removeMemberToEquipe(Equipe equipe) {
	        return new List<>(
	                "Supprimer un candidat de l'equipe", "3",
	                new ListData<Personne>()
	                {
	                    @Override
	                    public java.util.List<Personne> getList() {
	                        return new ArrayList<>(equipe.getMembres());
	                    }
	                },
	                new ListAction<Personne>()
	                {
	                    @Override
	                    public void itemSelected(int i, Personne personne) {
	                        equipe.remove(personne);
	                    }
	                }
	        );
	    }
		
		private static Option afficheNomEquipe(Equipe equipe)
		{
			return new Option("show Name", "shn", new Action()
			{
				@Override
				public void optionSelected()
				{
					System.out.println("You must give the equipe a name : ");
					System.out.println(equipe.getNom());
				}
			});
		}
		
		
		
		private static Option supprimeEquipe(Equipe equipe)
		{
			return new Option("delete", "d", new Action()
			{
				@Override
				public void optionSelected()
				{
					equipe.delete();
					System.out.println(equipe + " has been deleted.");
				}
			});
		}
		
		public static  Option creerEquipeOption(Inscriptions inscriptions) {
			return new Option("Créer une équipe", "c", new Action()
			{
				public void optionSelected()
				{
					System.out.println("Enter le nom de l'équipe  ");
					String nom = InOut.getString("Nom : ");
	                inscriptions.createEquipe(nom);
				}
			});
		}
}
