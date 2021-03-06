package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class AttribuerID implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_utilisateur", nullable=false)
	private Utilisateur linkedUtilisateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_code", nullable=false)
	private Code linkedCode;
	
	public AttribuerID(){}
	
	public AttribuerID(Utilisateur utilisateur, Code code) {
		this.linkedUtilisateur = utilisateur;
		this.linkedCode = code;
	}

	public Utilisateur getUtilisateur() {
		return linkedUtilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.linkedUtilisateur = utilisateur;
	}
	
	public Code getCode() {
		return linkedCode;
	}
	
	public void setCode(Code code) {
		this.linkedCode = code;
	}
	
	@Transient
	@Override
	public String toString() {
		return "AttribuerID:{ linkedUtilisateur:"+linkedUtilisateur+"\', linkedCode: \'"+linkedCode+"\'}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((linkedCode == null) ? 0 : linkedCode.hashCode());
		result = prime
				* result
				+ ((linkedUtilisateur == null) ? 0 : linkedUtilisateur
						.hashCode());
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
		AttribuerID other = (AttribuerID) obj;
		if (linkedCode == null) {
			if (other.linkedCode != null)
				return false;
		} else if (!linkedCode.equals(other.linkedCode))
			return false;
		if (linkedUtilisateur == null) {
			if (other.linkedUtilisateur != null)
				return false;
		} else if (!linkedUtilisateur.equals(other.linkedUtilisateur))
			return false;
		return true;
	}
}
