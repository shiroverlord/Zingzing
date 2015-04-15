package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="autoriser")
public class Autoriser implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	@EmbeddedId
	private AutoriserID autoriserId = null;
	
	public Autoriser(){}
	
	public Autoriser(AutoriserID attribuerId) {
		this.autoriserId = attribuerId;
	}
	
	public AutoriserID getId() {
		return autoriserId;
	}

	public void setId(AutoriserID id) {
		this.autoriserId = id;
	}
	
	@Transient
	@Override
	public String toString() {
		return "Code:{ autoriserId: \'"+autoriserId+"\'}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((autoriserId == null) ? 0 : autoriserId.hashCode());
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
		Autoriser other = (Autoriser) obj;
		if (autoriserId == null) {
			if (other.autoriserId != null)
				return false;
		} else if (!autoriserId.equals(other.autoriserId))
			return false;
		return true;
	}
}
