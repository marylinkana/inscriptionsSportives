package menus;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.*;

public class MenuInscription
{
	private Menu getCompetitionMenu()
	{
		Menu competitionMenu = new Menu("Competition Sub-Menu", "competition", "com");
		competitionMenu.add(getCompetitionList());
		competitionMenu.add(creerCompetitionOption());
		competitionMenu.addBack("r");

		return competitionMenu;
	}
	
	private Menu getEquipeMenu()
	{
		Menu equipeMenu = new Menu("Equipe Sub-Menu", "Equipe", "equ");
		equipeMenu.add(getEquipeList());
		equipeMenu.add(creerEquipeOption());
		equipeMenu.addBack("r");

		return equipeMenu;
	}
	
	private Menu getPersonneMenu()
	{
		Menu personneMenu = new Menu("Personne Sub-Menu", "Personne", "per");
		personneMenu.add(getPersonneList());
		personneMenu.add(creerPersonneOption());
		personneMenu.addBack("r");

		return personneMenu;
	}
	
	public MenuInscription(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;

		
		Menu rootMenu = new Menu("Root Menu");
		
		rootMenu.add(getCompetitionMenu());
		rootMenu.add(getEquipeMenu());
		rootMenu.add(getPersonneMenu());
		rootMenu.addQuit("q");
		
		rootMenu.start();

	}
	

	private Inscriptions inscriptions;
	
	void CompetitionListOptions()
	{
		List<Competition> list = getCompetitionList();
		list.start();
	}
	
    // Returns the list to print
	private List<Competition> getCompetitionList()
	{
		List<Competition> liste = new List<>("Select competition", "s", 
				getListDataCompetition(),
				getOptionListCompetition());
		liste.setAutoBack(false);
		liste.addQuit("q");
		return liste;
	}
	
	private ListData<Competition> getListDataCompetition()
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
	
	private ListOption<Competition> getOptionListCompetition()
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
	private Option getCompetitionMenu(final Competition competition)
	{
		Menu competitionMenu = new Menu("Edit " + competition.getNom(), competition.getNom(), null);
		competitionMenu.add(afficheCompetition(competition));
		competitionMenu.add(supprimeCompetition(competition));
		competitionMenu.setAutoBack(true);
		return competitionMenu;
	}
	
	// Returns the option to display someone
	private Option afficheCompetition(Competition competition)
	{
		return new Option("show", "s", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("You must give the man a name : " + competition + ".");
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
	
	
	
	
	void PersonneListOptions()
	{
		List<Personne> list = getPersonneList();
		list.start();
	}
	
    // Returns the list to print
	private List<Personne> getPersonneList()
	{
		List<Personne> liste = new List<>("Select personne", "s",
				getListPersonne(),
				getOptionListPersonne());
		liste.setAutoBack(false);
		liste.addQuit("q");
		return liste;
	}
	
	private ListData<Personne> getListPersonne()
	{
		return new ListData<Personne>()
		{
			@Override
			public java.util.List<Personne> getList()
			{
				return new ArrayList<>(inscriptions.getPersonnes());
			}
		};
	}
	
	private ListOption<Personne> getOptionListPersonne()
	{
		return new ListOption<Personne>()
		{
			// Each person will become an option
			// The following method returns the option 
			// associated with each one. 
			public Option getOption(Personne personne)
			{
				return getPersonneMenu(personne);
			}
		};
	}
	
	// Creates an sub-menu for someone. 
	private Option getPersonneMenu(final Personne personne)
	{
		Menu personneMenu = new Menu("Edit " + personne.getPrenom(), personne.getPrenom(), null);
		personneMenu.add(affichePersonne(personne));
		personneMenu.add(supprimePersonne(personne));
		personneMenu.setAutoBack(true);
		return personneMenu;
	}
	
	// Returns the option to display someone
	private Option affichePersonne(Personne personne)
	{
		return new Option("show", "s", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("You must give the man a name : " + personne + ".");
			}
		});
	}
	
	private static Option supprimePersonne(Personne personne)
	{
		return new Option("delete", "d", new Action()
		{
			@Override
			public void optionSelected()
			{
				personne.delete();
				System.out.println(personne + " has been deleted.");
			}
		});
	}
	
	
	void EquipeListOptions()
	{
		List<Personne> list = getPersonneList();
		list.start();
	}
	
    // Returns the list to print
	private List<Equipe> getEquipeList()
	{
		List<Equipe> liste = new List<>("Select equipe", "s",
				getListEquipe(),
				getOptionListEquipe());
		liste.setAutoBack(false);
		liste.addQuit("q");
		return liste;
	}
	
	private ListData<Equipe> getListEquipe()
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
	
	private ListOption<Equipe> getOptionListEquipe()
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
	private Option getEquipeMenu(final Equipe equipe)
	{
		Menu equipeMenu = new Menu("Edit " + equipe.getNom(), equipe.getNom(), null);
		equipeMenu.add(afficheEquipe(equipe));
		equipeMenu.add(supprimeEquipe(equipe));
		equipeMenu.setAutoBack(true);
		return equipeMenu;
	}
	
	// Returns the option to display someone
	private Option afficheEquipe(Equipe equipe)
	{
		return new Option("show", "s", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("You must give the man a name : " + equipe + ".");
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
	
	private static  Option creerCompetitionOption() {
		return new Option("Créer une competition", "crcomp", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Enter le nom, le nombre de jour jusqu'a la ate de cloture puis true si la competition est en équipe ou sinon false  ");
				String nom = InOut.getString("Nom : ");
				System.out.print("nombre de jour :");
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

