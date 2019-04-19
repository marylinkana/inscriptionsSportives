package Hibernates;

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

@Table(name = "Equipe")
class Equipe
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_equipe")
	private int id_equipe;

	@Column(name = "num_equipe")
	private int num_equipe;
	
	@Column(name = "nom_equipe")
	private String nom_equipe;

	public Equipe(int num_equipe, String nom_equipe)
	{
		this.num_equipe = num_equipe;
		this.nom_equipe = nom_equipe;
	}
}

@Table(name = "Candidat")
class Candidat
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_candidat")
	private int id_candidat;

	@Column(name = "num_candidat")
	private int num_candidat;
	
	@Column(name = "nom_candidat")
	private String nom_candidat;

	public Candidat(int num_candidat, String nom_candidat)
	{
		this.num_candidat = num_candidat;
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

	@Column(name = "num_competition")
	private int num_competition;

	@Column(name = "nom_competition")
	private String nom_competition;
	
	@Column(name = "date_cloture")
	private String date_cloture;
	
	@Column(name = "type")
	private String type;

	public Competition(int num_competition, String nom_competition, String date_cloture, String type)
	{
		this.num_competition = num_competition;
		this.nom_competition = nom_competition;
		this.date_cloture = date_cloture;
		this.type = type;
	}
}

@Table(name = "Appartenir")
class Appartenir
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_appartenir")
	private int id_appartenir;

	@Column(name = "num_personne")
	private int num_personne;
	
	@Column(name = "num_equipe")
	private int num_equipe;

	public Appartenir(int num_personne, int num_equipe)
	{
		this.num_personne = num_personne;
		this.num_equipe = num_equipe;
	}
}

@Table(name = "Inscrire")
class Inscrire
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_inscrire")
	private int id_inscrire;

	@Column(name = "num_candidat")
	private int num_candidat;
	
	@Column(name = "num_competition")
	private int num_competition;

	public Inscrire(int num_candidat, int num_competition)
	{
		this.num_candidat = num_candidat;
		this.num_competition = num_candidat;
	}
}

public class PremierExemple
{
	private static Session getSession() throws HibernateException
	{
		Configuration configuration = new Configuration()
				.configure("Hibernates/PremierExemple.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}

	public static void main(String[] args)
	{
		try
		{
			Session s = getSession();
			Personne amandine = new Personne("amandine", "thivet", "amandine@thivet");
			Transaction t = s.beginTransaction();
			s.persist(amandine);
			t.commit();
			s.close();
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Probleme de configuration : "
					+ ex.getMessage(), ex);
		}
	}
}
