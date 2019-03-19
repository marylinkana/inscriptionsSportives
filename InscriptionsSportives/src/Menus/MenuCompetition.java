package Menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

import Inscriptions.Candidat;
import Inscriptions.Competition;
import Inscriptions.Equipe;
import Inscriptions.Inscriptions;
import Inscriptions.Personne;
import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.ListAction;
import commandLineMenus.ListData;
import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;

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
		competitionMenu.add(editCandidatCompetition(competition));
		competitionMenu.add(supprimeCompetition(competition));
		competitionMenu.add(modifieNomCompetition(competition));
		competitionMenu.add(modifieDateCompetition(competition));
		competitionMenu.setAutoBack(true);
		competitionMenu.addBack("r");
		return competitionMenu;
	}
	
	private static Menu editCandidatCompetition(Competition competition)
	{
		Menu competitionMenu = new Menu("add Candidat to Competition Sub-Menu", "candidat", "ca");
		competitionMenu.add(getCandidatOfCompetition(competition));
		competitionMenu.add(addPersonToCompetition(competition));
		competitionMenu.add(addEquipeToCompetition(competition));
		competitionMenu.add(removeCandidatToCompetition(competition));
		competitionMenu.addBack("r");

		return competitionMenu;
	}
	
	private static Option getCandidatOfCompetition(Competition competition)
	{
		return new Option("show candidats", "1", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Candidats : ");
				System.out.println(competition.getCandidats());
				
			}
		});
	}
	
	private static Option addPersonToCompetition(Competition competition) {
        return new List<>(
                "Ajouter une personne à la competition", "2",
                new ListData<Personne>()
                {
                    @Override
                    public java.util.List<Personne> getList() {
                        return new ArrayList<>(Inscriptions.getInscriptions().getPersonnes());
                    }
                },
                new ListAction<Personne>()
                {
                    @Override
                    public void itemSelected(int i, Personne personne) {
                        competition.add(personne);
                    }

                }
        );
    }

    private static Option addEquipeToCompetition(Competition competition) {
        return new List<>(
                "Ajouter une équipe à la competition", "3",
                new ListData<Equipe>()
                {
                    @Override
                    public java.util.List<Equipe> getList() {
                        return new ArrayList<>(Inscriptions.getInscriptions().getEquipes());
                    }
                },
                new ListAction<Equipe>()
                {
                    @Override
                    public void itemSelected(int i, Equipe equipe) {
                        competition.add(equipe);
                    }
                }
        );
    }
    
    
    private static Option removeCandidatToCompetition(Competition competition) {
        return new List<>(
                "Supprimer un candidat de la competition", "4",
                new ListData<Candidat>()
                {
                    @Override
                    public java.util.List<Candidat> getList() {
                        return new ArrayList<>(competition.getCandidats());
                    }
                },
                new ListAction<Candidat>()
                {
                    @Override
                    public void itemSelected(int i, Candidat candidat) {
                        competition.remove(candidat);
                    }
                }
        );
    }
	
	// Returns the option to display someone
	
	private static Option afficheCompetition(Competition competition)
	{
		return new Option("show competition", "sh", new Action()
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
	
	private static Option supprimeCompetition(Competition competition)
	{
		return new Option("delete", "d", new Action()
		{
			@Override
			public void optionSelected()
			{
				competition.delete();
				System.out.println(competition.getNom() + " has been deleted of");
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
		        scanner.close();
				competition.setDateCloture(competition.getDateCloture().plusDays(day));	
				System.out.println("la nouvelle date est : "+competition.getDateCloture());
			}
		});
	}

	private static Option ajouteCandidatCompetition(Competition competition, Candidat candidats)
	{
		return new Option("add candidat", "ac", new Action()
		{
			@Override
			public void optionSelected()
			{
				if(competition.estEnEquipe() )
					competition.add((Equipe)candidats);
				else
					competition.add((Personne)candidats);
				System.out.println(candidats.getNom()+" à bien été ajouté à la compétition "
									+competition.getNom() );
			}
		});
	}
	
	private static Option supprimeCandidatCompetition(Competition competition, Candidat candidat)
	{
		return new Option("delete", "d", new Action()
		{
			@Override
			public void optionSelected()
			{
				competition.remove(candidat);
				System.out.println(candidat.getNom() + " has been deleted of " +competition.getNom());
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