package Hibernates;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


@Entity
@Table(name = "Personne")
class Personne
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_personne")
	private int id_personne;

	@Column(name = "nom_personne")
	private String nom_personne;

	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "email")
	private String email;

	public Personne(String nom, String prenom, String email)
	{
		this.nom_personne = nom;
		this.prenom = prenom;
		this.email = email;

	}
}

@Entity
@Table(name = "Equipe")
class Equipe
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_equipe")
	private int id_equipe;

	
	@Column(name = "nom_equipe")
	private String nom_equipe;

	public Equipe(String nom_equipe)
	{
		this.nom_equipe = nom_equipe;
	}
}

@Entity
@Table(name = "Candidat")
class Candidat
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidat")
	private int id_candidat;
	
	@Column(name = "nom_candidat")
	private String nom_candidat;

	public Candidat(int num_candidat, String nom_candidat)
	{
		this.nom_candidat = nom_candidat;
	}
}

@Entity
@Table(name = "Competition")
class Competition
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_competition")
	private int id_competition;

	@Column(name = "nom_competition")
	private String nom_competition;
	
	@Column(name = "date_cloture")
	private LocalDate date_cloture;
	
	@Column(name = "type")
	private boolean type;

	public Competition(String nom_competition, LocalDate date_cloture, boolean type)
	{
		this.nom_competition = nom_competition;
		this.date_cloture = date_cloture;
		this.type = type;
	}

}

@Entity
@Table(name = "Appartenir")
class Appartenir
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_appartenir")
	private int id_appartenir;

	@Column(name = "id_personne")
	private int id_personne;
	
	@Column(name = "id_equipe")
	private int id_equipe;

	public Appartenir(int id_personne, int id_equipe)
	{
		this.id_personne = id_personne;
		this.id_equipe = id_equipe;
	}
}

@Entity
@Table(name = "Inscrire")
class Inscrire
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_inscrire")
	private int id_inscrire;

	@Column(name = "id_candidat")
	private int id_candidat;
	
	@Column(name = "id_competition")
	private int id_competition;

	public Inscrire(int id_candidat, int id_competition)
	{
		this.id_candidat = id_candidat;
		this.id_competition = id_candidat;
	}
}


public class bdd
{	 
	public static Competition setCompetition(String nom_competition, LocalDate date_cloture, boolean type) {
		
		return new Competition(nom_competition,date_cloture,type);
	}
	
	public static Equipe setEquipe(String nom_equipe) {
		
		return new Equipe(nom_equipe);
	}
	
	public static Candidat setCandidat(int num_candidat, String nom_candidat)
	{
		return new Candidat(num_candidat, nom_candidat);
	}
	
	public static Personne setPersonne(String nom, String prenom, String email) {
		
		return new Personne(nom, prenom, email);
	}
	
	public static Appartenir setAppartenir(int id_personne, int id_equipe)
	{
		return new Appartenir(id_personne, id_equipe);
	}
	
	public static Inscrire setInscrire(int id_candidat, int id_competition)
	{
		return new Inscrire(id_candidat, id_competition);

	}
	
	
	public static Session getSession() throws HibernateException
	{
		Configuration configuration = new Configuration()
				.configure("Hibernates/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}

}
