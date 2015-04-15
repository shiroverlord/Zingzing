package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Transient;

@Embeddable
public class AttribuerID implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	protected Long id_utilisateur;
	protected Long id_code;
	
	public AttribuerID(){}
	
	public AttribuerID(Long id_utilisateur, Long id_code) {
		this.id_utilisateur = id_utilisateur;
		this.id_code = id_code;
	}

	@Id
	@Column(name="id_utilisateur", nullable=false)
	public Long getIdUtilisateur() {
		return id_utilisateur;
	}

	public void setIdUtilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	
	@Id
	@Column(name="id_code", nullable=false)
	public Long getIdCode() {
		return id_code;
	}
	
	public void setIdCode(Long id_code) {
		this.id_code = id_code;
	}
	
	@Transient
	@Override
	public String toString() {
		return "AttribuerID:{ idUtilisateur:"+id_utilisateur+"\', idCode: \'"+id_code+"\'}";
	}
}
