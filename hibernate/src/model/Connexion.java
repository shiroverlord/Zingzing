package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="connexion")
public class Connexion implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	private Long id;
	private String motDePasse = null;
	
	public Connexion(){}
	
	public Connexion(Long id, String value) {
		this.id = id;
		this.motDePasse = value;
	}
	
	public Connexion(String value) {
		this.motDePasse = value;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="mot_de_passe", length=10)
	public String getValue() {
		return motDePasse;
	}
	
	public void setValue(String value) {
		this.motDePasse = value;
	}
	
	@Transient
	@Override
	public String toString() {
		return "Code:{ id:"+id+"\', motDePasse: \'"+motDePasse+"\'}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
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
		Connexion other = (Connexion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		return true;
	}
}
