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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((droit == null) ? 0 : droit.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (droit == null) {
			if (other.droit != null)
				return false;
		} else if (!droit.equals(other.droit))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}
}
