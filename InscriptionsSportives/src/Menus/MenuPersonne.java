package Menus;

import java.util.ArrayList;
import java.util.SortedSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

public class MenuPersonne {

	void PersonneListOptions(Inscriptions inscriptions)
	{
		List<Personne> list = getPersonneList(inscriptions);
		list.start();
	}
	
    // Returns the list to print
	public static List<Personne> getPersonneList(Inscriptions inscriptions)
	{
		List<Personne> liste = new List<>("Select personne", "s",
				getListPersonne(inscriptions),
				getOptionListPersonne());
		liste.setAutoBack(false);
		liste.addQuit("q");
		liste.addBack("r");
		return liste;
	}
	
	private static ListData<Personne> getListPersonne(Inscriptions inscriptions)
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
	
	private static ListOption<Personne> getOptionListPersonne()
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
	private static Option getPersonneMenu(final Personne personne)
	{
		Menu personneMenu = new Menu("Edit " + personne.getNom(), personne.getNom(), null);
		personneMenu.add(affichePersonne(personne));
		personneMenu.add(afficheEquipePersonne(personne));
		personneMenu.add(setNomPersonne(personne));
		personneMenu.add(setPrenomPersonne(personne));
		personneMenu.add(setMailPersonne(personne));
		personneMenu.add(editEquipe(personne));
		personneMenu.add(editCompetition(personne));
		personneMenu.add(supprimePersonne(personne));
		personneMenu.setAutoBack(true);
		personneMenu.addBack("r");
		return personneMenu;
	}
	
	private static Menu editEquipe(Personne personne)
	{
		Menu competitionMenu = new Menu("edit equipe of personne Sub-Menu", "Edit equipe", "ed");
		competitionMenu.add(getEquipeOfPerson(personne));
		competitionMenu.add(addPersonToEquipe(personne));
		competitionMenu.add(removePersonToEquipe(personne));
		competitionMenu.addBack("r");

		return competitionMenu;
	}
	
	private static Menu editCompetition(Personne personne)
	{
		Menu competitionMenu = new Menu("edit competition of personne Sub-Menu", "Edit competition", "co");
		competitionMenu.add(getCompetitionOfPerson(personne));
		competitionMenu.add(addPersonToCompetition(personne));
		competitionMenu.add(removePersonToCompetition(personne));
		competitionMenu.addBack("r");

		return competitionMenu;
	}
	
	private static Option getCompetitionOfPerson(Personne personne)
	{
		return new Option("show Competition", "1", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Liste des membres :");
				System.out.println(personne.getCompetitions());

			}
		});
	}
	
	private static Option addPersonToCompetition(Personne personne) {
        return new List<>(
                "Ajouter ce candidat à une competition", "2",
                new ListData<Competition>()
                {
                    @Override
                    public java.util.List<Competition> getList() {
                        return new ArrayList<>(Inscriptions.getInscriptions().getCompetitions());
                    }
                },
                new ListAction<Competition>()
                {
                    @Override
                    public void itemSelected(int i, Competition competition) {
                        competition.add(personne);
                    }
                }
        );
    }
	private static Option removePersonToCompetition(Personne personne) {
        return new List<>(
                "Supprémer ce candidat d'une competition ", "3",
                new ListData<Competition>()
                {
                    @Override
                    public java.util.List<Competition> getList() {
                        return new ArrayList<>(personne.getCompetitions());
                    }
                },
                new ListAction<Competition>()
                {
                    @Override
                    public void itemSelected(int i, Competition competition) {
                        competition.remove(personne);
                    }

                }
        );
    }
	private static Option getEquipeOfPerson(Personne personne)
	{
		return new Option("show Equipe", "1", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Liste des équipes :");
				System.out.println(personne.getEquipes());

			}
		});
	}
	
	private static Option addPersonToEquipe(Personne personne) {
        return new List<>(
                "Ajouter ce membre à une équipe", "2",
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
                        equipe.add(personne);
                    }

                }
        );
    }
	
	private static Option removePersonToEquipe(Personne personne) {
        return new List<>(
                "Supprimer ce membre d'une équipe", "3",
                new ListData<Equipe>()
                {
                    @Override
                    public java.util.List<Equipe> getList() {
                        return new ArrayList<>(personne.getEquipes());
                    }
                },
                new ListAction<Equipe>()
                {
                    @Override
                    public void itemSelected(int i, Equipe equipe) {
                        equipe.remove(personne);
                    }

                }
        );
    }
	
	private static Option setNomPersonne(Personne personne) {
		return new Option("set Nom", "stn", new Action()
				
				{
					@Override
					public void optionSelected()
					{
						System.out.println("veillez saisir le nouveau nom");
						String nom = InOut.getString("Nom : ");
						personne.setNom(nom);
						System.out.println("le nom a bien été changé");
					}
				});
	}
	
	private static Option setPrenomPersonne(Personne personne) {
		return new Option("set Prenom", "spp", new Action()
				
				{
					@Override
					public void optionSelected()
					{
						System.out.println("veillez saisir le nouveau prenom");
						String prenom = InOut.getString("Prenom : ");
						personne.setPrenom(prenom);
						System.out.println("le prénom a bien été changé");
					}
				});
	}
	
	private static Option setMailPersonne(Personne personne) {
		return new Option("set Mail", "stm", new Action()
				
				{
					@Override
					public void optionSelected()
					{
						System.out.println("veillez saisir le nouveau nom");
						String mail = InOut.getString("Nom : ");
						personne.setMail(mail);
						System.out.println("le mail a bien été changé");
					}
				});
	}
	
	private static Option afficheEquipePersonne(Personne personne) {
		return new Option("show groupe", "shg", new Action()
				
				{
					@Override
					public void optionSelected()
					{
						System.out.println("Equipe : " + personne.getEquipes() + ".");
						System.out.println("competition : " + personne.getCompetitions() + ".");

					}
				});
	}

	// Returns the option to display someone
	private static Option affichePersonne(Personne personne)
	{
		return new Option("show", "sh", new Action()
		
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Name : " + personne.getNom() + ".");
				System.out.println("Prenom : " + personne.getPrenom() + ".");
				System.out.println("Email : " + personne.getMail() + ".");
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
	
	public static  Option creerPersonneOption(Inscriptions inscriptions) {
		return new Option("créer une personne", "c", new Action()
		{
			public void optionSelected()
			{
				System.out.println("Enter le nom, le prenom et l'adresse email de la personne que vous voulez ajouter ");
				String nom = InOut.getString("Nom : ");
				String prenom = InOut.getString("Prénom : ");
                String mail = InOut.getString("Email : ");
                Personne personne = inscriptions.createPersonne(nom, prenom, mail);
                try
        		{
        			Session s = Hibernates.bdd.getSession();
        			Transaction t = s.beginTransaction();
        			s.persist(Hibernates.bdd.setPersonne(nom, prenom, mail	));
        			t.commit();
        			s.close();
        		}
        		catch (HibernateException ex)
        		{
        			throw new RuntimeException("Probleme de configuration : "
        					+ ex.getMessage(), ex);
        		}
			}
		});
	}
}
