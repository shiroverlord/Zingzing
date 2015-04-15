package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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

	@Column(name="id_utilisateur", nullable=false)
	public Long getIdUtilisateur() {
		return id_utilisateur;
	}

	public void setIdUtilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	
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

	@Transient
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_code == null) ? 0 : id_code.hashCode());
		result = prime * result
				+ ((id_utilisateur == null) ? 0 : id_utilisateur.hashCode());
		return result;
	}

	@Transient
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttribuerID other = (AttribuerID) obj;
		if (id_code == null) {
			if (other.id_code != null)
				return false;
		} else if (!id_code.equals(other.id_code))
			return false;
		if (id_utilisateur == null) {
			if (other.id_utilisateur != null)
				return false;
		} else if (!id_utilisateur.equals(other.id_utilisateur))
			return false;
		return true;
	}
}
