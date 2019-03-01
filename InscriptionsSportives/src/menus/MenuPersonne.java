package menus;

import java.util.SortedSet;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class MenuPersonne {

//	public static Menu getPersonneMenu()
//	{
//		Menu personneMenu = new Menu("Personne Sub-Menu", "Personne", "per");
//		return personneMenu;
//	}
//	
//	
//	getPersonneMenu().add(affichePersonneOption());
//	getPersonneMenu().add(creerPersonneOption());
//	
//	getPersonneMenu().addBack("r");
//	getPersonneMenu().setAutoBack(true);
//	
//	
//	private static  Option affichePersonneOption() {
//		return new Option("Afficher les personnes", "afpers", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Liste des personnes : ");
//        		Inscriptions inscriptions = Inscriptions.getInscriptions();
//				SortedSet<Personne> lesPersonnes = inscriptions.getPersonnes();
//				System.out.println( lesPersonnes );
//				
//			}
//		});
//	}
//	
//	
//	
//	
//	private static  Option creerPersonneOption() {
//		return new Option("créer une personne", "crpers", new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Enter le nom, le prenom et l'adresse email de la personne que vous voulez ajouter ");
//				String nom = InOut.getString("Nom : ");
//				String prenom = InOut.getString("Prénom : ");
//                String mail = InOut.getString("Email : ");
//        		Inscriptions inscriptions = Inscriptions.getInscriptions();
//                Personne personne = inscriptions.createPersonne(nom, prenom, mail);
//			}
//		});
//	}
//
}
