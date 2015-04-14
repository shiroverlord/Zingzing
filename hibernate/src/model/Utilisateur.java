package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tools.Tools;

@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = -7351729135012380019L;

	private Long id;
	private String nom = null;
	private String prenom = null;
	private Calendar datenaissance = null;
	private String adresse = null;
	private String adresseMail = null;
	private String telephone = null;
	private TypeUtilisateur typeUtilisateur = null;
	private Connexion connexion = null;
	private Genre genre = null;
	
	public Utilisateur(){}
	
	public Utilisateur(Long id, String nom, String prenom, Calendar datenaissance, String adresse, String adresseMail, String telephone, TypeUtilisateur typeUtilisateur, Connexion connexion, Genre genre) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.adresseMail = adresseMail;
		this.telephone = telephone;
		this.typeUtilisateur = typeUtilisateur;
		this.connexion = connexion;
		this.genre = genre;
	}
	
	public Utilisateur(String nom, String prenom, Calendar datenaissance, String adresse, String adresseMail, String telephone, TypeUtilisateur typeUtilisateur, Connexion connexion, Genre genre) {
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.adresseMail = adresseMail;
		this.telephone = telephone;
		this.typeUtilisateur = typeUtilisateur;
		this.connexion = connexion;
		this.genre = genre;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nom")
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column(name="prenom")
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name="datenaissance")
	public Calendar getDateNaissance() {
		return datenaissance;
	}

	public void setDateNaissance(Calendar datenaissance) {
		this.datenaissance = datenaissance;
	}
	
	@Column(name="adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name="adresseMail")
	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	@Column(name="telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type_d_utilisateur", nullable = false)
	public TypeUtilisateur getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_connexion", nullable = false)
	public Connexion getConnexion() {
		return connexion;
	}

	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_genre", nullable = false)
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	@Transient
	@Override
	public String toString() {
		return "User:{ id:"+id+", prenom: \'"+prenom+"\' , nom: \'"+nom+"\', dateanniversaire: \'"+Tools.formatDateToDisplay(datenaissance)+"\'"+"\', connexion: \'"+connexion.toString()+"}";
	}
}
