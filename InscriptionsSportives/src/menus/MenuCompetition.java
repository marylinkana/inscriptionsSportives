package menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.ListData;
import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

public class MenuCompetition {
	
	void CompetitionListOptions(Inscriptions inscriptions)
	{
		List<Competition> list = getCompetitionList(inscriptions);
		list.start();
	}
	
    // Returns the list to print
	public static List<Competition> getCompetitionList(Inscriptions inscriptions)
	{
		List<Competition> liste = new List<>("Select competition", "s", 
				getListDataCompetition(inscriptions),
				getOptionListCompetition());
		liste.setAutoBack(true);
		liste.addQuit("q");
		liste.addBack("r");
		return liste;
	}
	
	private static ListData<Competition> getListDataCompetition(Inscriptions inscriptions)
	{
		return new ListData<Competition>()
		{
			@Override
			public java.util.List<Competition> getList()
			{
				return new ArrayList<>(inscriptions.getCompetitions());
			}
		};
	}
	
	private static ListOption<Competition> getOptionListCompetition()
	{
		return new ListOption<Competition>()
		{
			// Each person will become an option
			// The following method returns the option 
			// associated with each one. 
			public Option getOption(Competition competition)
			{
				return getCompetitionMenu(competition);
			}
		};
	}
	
	// Creates an sub-menu for someone. 
	private static Option getCompetitionMenu(final Competition competition)
	{
		Menu competitionMenu = new Menu("Edit " + competition.getNom(), competition.getNom(), null);
		competitionMenu.add(afficheCompetition(competition));
		competitionMenu.add(supprimeCompetition(competition));
		competitionMenu.add(modifieNomCompetition(competition));
		competitionMenu.add(modifieDateCompetition(competition));
		competitionMenu.add(ajoutePersonneCompetition(competition));
		competitionMenu.setAutoBack(true);
		competitionMenu.addBack("r");
		return competitionMenu;
	}
	
	// Returns the option to display someone
	private static Option afficheCompetition(Competition competition)
	{
		return new Option("show", "sh", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Nom : " +competition.getNom());
				if (competition.inscriptionsOuvertes() == true) 
					System.out.println("Inscription ouverte " );
				else
					System.out.println("Inscription cloturé " );
				System.out.println("Date cloture : " +competition.getDateCloture());
				if (competition.estEnEquipe() == true) 
					System.out.println("Competition en équipe" );
				else
					System.out.println("Competition solo" );
			}
		});
	}
	
	private static Option modifieNomCompetition(Competition competition)
	{
		return new Option("set nom", "sn", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("veillez saisir le nouveau nom");
				String nom = InOut.getString("Nom : ");
				competition.setNom(nom);
				System.out.println("le nouveau nom est : "+competition.getNom());
			}
		});
	}
	
	
	private static Option modifieDateCompetition(Competition competition)
	{
		return new Option("set date", "sd", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("enter le nombre de jour");
				Scanner scanner = new Scanner(System.in);
		        int day = scanner.nextInt();
				competition.setDateCloture(competition.getDateCloture().plusDays(day));	
				System.out.println("la nouvelle date est : "+competition.getDateCloture());
			}
		});
	}
	
	private static Option ajoutePersonneCompetition(Competition competition)
	{
		return new Option("add candidat", "ac", new Action()
		{
			@Override
			public void optionSelected()
			{
//				final ArrayList<Personne> lesPersonnes = new ArrayList<>();
//				lesPersonnes.add((Personne)competition.getCandidatsAInscrire());
//				List<Personne> candidatAInscrire = new List<Personne>("People list", 
//						new ListData<Personne>()		
//						{
//							// Returns the data needed to refresh the list 
//							// each time it is displayed. 
//							public java.util.List<Personne> getList()
//							{
//								System.out.println("Sélectionner la personne que vous souhaitez inscrire");
//								return lesPersonnes;
//							}	
//						},
//						new ListAction<Personne>()
//						{				
//							// Triggered each time an item is selected
//							public void itemSelected(int index, Personne unePersonne)
//							{
//								competition.add(unePersonne);
//								System.out.println(unePersonne 
//										+ " a bien été inscrit à la compétition " 
//										+ competition.getCandidatsAInscrire());
//							}
//						});
				
			}
		});
	}
	
	
	private static Option supprimeCompetition(Competition competition)
	{
		return new Option("delete", "d", new Action()
		{
			@Override
			public void optionSelected()
			{
				competition.delete();
				System.out.println(competition + " has been deleted.");
			}
		});
	}
	
	public static  Option creerCompetitionOption(Inscriptions inscriptions) {
		return new Option("Créer une competition", "c", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Enter le nom de la compétition  ");
				String nom = InOut.getString("Nom : ");
				System.out.print("Entez le nombre de jour avant la cloture :");
				Scanner scanner = new Scanner(System.in);
		        int day = scanner.nextInt();
		        LocalDate date = LocalDate.now().plusDays(day);
				System.out.println("si la competition est en équipe, entrez : oui sinon entez : nom");
				String enEquipe = InOut.getString("En équipe : ");
				boolean type;
				if(enEquipe == "oui")
		        	type = true;
		        else
		        	type = false;
				
                inscriptions.createCompetition(nom, date, type);
			}
		});
	}

}