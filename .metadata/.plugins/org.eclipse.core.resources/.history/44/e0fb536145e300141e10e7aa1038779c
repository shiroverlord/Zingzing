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
	private static final long serialVersionUID = -7601578587341446093L;
	
	private Long id;
	private String motdepasse = null;
	
	public Connexion(){}
	
	public Connexion(Long id, String motdepasse) {
		this.id = id;
		this.motdepasse = motdepasse;
	}
	
	public Connexion(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="motdepasse")
	public String getPassword() {
		return motdepasse;
	}
	
	public void setPassword(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	@Transient
	@Override
	public String toString() {
		return "Connexion:{ id:"+id+"\', password: \'"+motdepasse+"\'}";
	}
}
