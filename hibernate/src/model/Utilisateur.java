package model;

import java.io.Serializable;

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

@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = -7351729135012380019L;

	private Long id;
	private String nom = null;
	private String prenom = null;
	private Droit droit = null;
	private Section section = null;
	
	public Utilisateur(){}
	
	public Utilisateur(Long id, String nom, String prenom, Droit droit, Section section) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.droit = droit;
		this.section = section;
	}
	
	public Utilisateur(String nom, String prenom, Droit droit, Section section) {
		this.nom = nom;
		this.prenom = prenom;
		this.droit = droit;
		this.section = section;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Droit", nullable = false)
	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Section", nullable = false)
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	@Transient
	@Override
	public String toString() {
		return "User:{ id:"+id+", prenom: \'"+prenom+"\' , nom: \'"+nom+"\', droit: \'"+droit.toString()+"}";
	}
}
