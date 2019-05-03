package Inscriptions;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

/**
 * Représente une compétition, c'est-à-dire un ensemble de candidats
 * inscrits à un événement, les inscriptions sont closes à la date dateCloture.
 *
 */

public class Competition implements Comparable<Competition>, Serializable
{
	private static final long serialVersionUID = -2882150118573759729L;
	private Inscriptions inscriptions;
	private String nom;
	private Set<Candidat> candidats;
	private LocalDate dateCloture;
	private boolean enEquipe = false;

	Competition(Inscriptions inscriptions, String nom, LocalDate dateCloture, boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		this.inscriptions = inscriptions;
		this.nom = nom;
		this.dateCloture = dateCloture;
		candidats = new TreeSet<>();
	}
	
	Competition(){}

	/**
	 * Retourne le nom de la compétition.
	 * @return
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom de la compétition.
	 */

	public void setNom(String nom)
	{
		this.nom = nom ;
	}

	/**
	 * Retourne vrai si les inscriptions sont encore ouvertes,
	 * faux si les inscriptions sont closes.
	 * @return
	 */

	public boolean inscriptionsOuvertes()
	{
		if(dateCloture.isAfter(LocalDate.now()))
		{
			return true;
		}
		else
		return false;
	}
	

	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 */

	public LocalDate getDateCloture()
	{
		return dateCloture;
	}

	/**
	 * Est vrai si et seulement si les inscriptions sont réservées aux équipes.
	 * @return
	 */

	public boolean estEnEquipe()
	{
		return enEquipe;
	}

	/**
	 * Modifie la date de cloture des inscriptions. Il est possible de la reculer
	 * mais pas de l'avancer.
	 * @param dateCloture
	 */

	public void setDateCloture(LocalDate dateCloture)
	{
		if(dateCloture.isAfter(this.dateCloture) || dateCloture.equals(this.dateCloture))
			this.dateCloture = dateCloture;
		else
			throw new RuntimeException("Impossible d'avancer la date de clôture");
	}

	/**
	 * Retourne l'ensemble des candidats inscrits.
	 * @return
	 */

	public Set<Candidat> getCandidats()
	{
		return Collections.unmodifiableSet(candidats);
	}

	/**
	 * Inscrit un candidat de type Personne à la compétition. Provoque une
	 * exception si la compétition est réservée aux équipes ou que les
	 * inscriptions sont closes.
	 * @param personne
	 * @return
	 */

	public boolean add(Personne personne)
	{
		if (enEquipe)
			throw new RuntimeException("Attention : Cette competition est reserv� aux �quipes");
		if(inscriptionsOuvertes())
		{
			personne.add(this);
			return candidats.add(personne);
		}
		else
			throw new RuntimeException("Attention : Les inscriptions sont fini");
	}

	/**
	 * Inscrit un candidat de type Equipe à la compétition. Provoque une
	 * exception si la compétition est réservée aux personnes ou que
	 * les inscriptions sont closes.
	 * @param personne
	 * @return
	 */

	public boolean add(Equipe equipe)
	{
		if (!enEquipe)
			throw new RuntimeException("Attention : Cette competition est r�serv� aux personnes");
		if(inscriptionsOuvertes())
			equipe.add(this);
		return candidats.add(equipe);
	}

	/**
	 * Retourne les personnes que l'on peut inscrire à cette competition.
	 * @return les personnes que l'on peut inscrire à cette compétition.
	 */
	
	public Set<Candidat> getCandidatsAInscrire() {
		// les candidats que l'on peut inscrire � cette comp�tition.
		Set<Candidat> candidats = new HashSet<>();
		for (Candidat candidat : inscriptions.getCandidats()) {

			if (enEquipe && (candidat instanceof Personne))
				continue;
			if (!enEquipe && (candidat instanceof Equipe))
				continue;
			boolean estInscrit = false;

			for (Competition cmpt : inscriptions.getCompetitions()) {
				if (cmpt.getCandidats().contains(candidat)) {
					estInscrit = true;
					break;
				}
			}
			if (!estInscrit)
				candidats.add(candidat);

		}
		return candidats;
	}

	/**
	 * Désinscrit un candidat.
	 * @param candidat
	 * @return
	 */

	public boolean remove(Candidat candidat)
	{
		candidat.remove(this);
		return candidats.remove(candidat);
	}

	/**
	 * Supprime la compétition de l'application.
	 */

	public void delete()
	{
		for (Candidat candidat : candidats)
			remove(candidat);
		inscriptions.delete(this);
	}

	@Override
	public int compareTo(Competition o)
	{
		return getNom().compareTo(o.getNom());
	}

	@Override
	public String toString()
	{
		return getNom();
	}
}
