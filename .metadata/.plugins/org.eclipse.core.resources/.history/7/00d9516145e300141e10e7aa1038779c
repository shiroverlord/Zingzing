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
@Table(name="type_d_utilisateur")
public class TypeUtilisateur implements Serializable {
	private static final long serialVersionUID = -1118303401403366726L;
	
	private Long id;
	private String libelle = null;
	
	public TypeUtilisateur(){}
	
	public TypeUtilisateur(Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	public TypeUtilisateur(String libelle) {
		this.libelle = libelle;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="libelle")
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Transient
	@Override
	public String toString() {
		return "TypeUtilisateur:{ id:"+id+"\', libelle: \'"+libelle+"\'}";
	}
}
