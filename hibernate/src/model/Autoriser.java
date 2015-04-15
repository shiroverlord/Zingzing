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
	private AutoriserID autoriserId;
	
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
		return "Code:{ attribuerId:"+autoriserId.toString()+"\'}";
	}
}
