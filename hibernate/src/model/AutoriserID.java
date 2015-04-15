package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class AutoriserID implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_droit", nullable=false)
	private Droit linkedDroit = null;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_salle", nullable=false)
	private Salle linkedSalle = null;
	
	public AutoriserID(){}
	
	public AutoriserID(Droit droit, Salle salle) {
		this.linkedDroit = droit;
		this.linkedSalle = salle;
	}
	
	public Droit getDroit() {
		return linkedDroit;
	}

	public void setDroit(Droit droit) {
		this.linkedDroit = droit;
	}
	
	public Salle getSalle() {
		return linkedSalle;
	}
	
	public void setSalle(Salle salle) {
		this.linkedSalle = salle;
	}
	
	@Transient
	@Override
	public String toString() {
		return "AutoriserID:{ linkedDroit: \'"+linkedDroit+"\', linkedSalle: \'"+linkedSalle+"\'}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((linkedDroit == null) ? 0 : linkedDroit.hashCode());
		result = prime * result
				+ ((linkedSalle == null) ? 0 : linkedSalle.hashCode());
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
		AutoriserID other = (AutoriserID) obj;
		if (linkedDroit == null) {
			if (other.linkedDroit != null)
				return false;
		} else if (!linkedDroit.equals(other.linkedDroit))
			return false;
		if (linkedSalle == null) {
			if (other.linkedSalle != null)
				return false;
		} else if (!linkedSalle.equals(other.linkedSalle))
			return false;
		return true;
	}
}
