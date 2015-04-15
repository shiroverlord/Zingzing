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
@Table(name="section")
public class Section implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	private Long id;
	private String libelle = null;
	
	public Section(){}
	
	public Section(Long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	
	public Section(String libelle) {
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
		return "Section:{ id:"+id+"\', libelle: \'"+libelle+"\'}";
	}
}
