package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import tools.Tools;

@Entity
@Table(name="attribuer")
public class Attribuer implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	@EmbeddedId
	private AttribuerID attribuerId;
	private Calendar date_debut = null;
	private Calendar date_fin = null;
	
	public Attribuer(){}
	
	public Attribuer(AttribuerID attribuerId, Calendar date_debut) {
		this(attribuerId, date_debut, null);
	}
	
	public Attribuer(AttribuerID attribuerId, Calendar date_debut, Calendar date_fin) {
		this.attribuerId = attribuerId;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	
	public Attribuer(Calendar date_debut) {
		this(date_debut, null);
	}
	
	public Attribuer(Calendar date_debut, Calendar date_fin) {
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	
	public AttribuerID getId() {
		return attribuerId;
	}

	public void setId(AttribuerID id) {
		this.attribuerId = id;
	}
	
	@Column(name="date_debut")
	public Calendar getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Calendar date_debut) {
		this.date_debut = date_debut;
	}

	@Column(name="date_fin")
	public Calendar getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Calendar date_fin) {
		this.date_fin = date_fin;
	}

	@Transient
	@Override
	public String toString() {
		return "Code:{ attribuerId:"+attribuerId.toString()+"\', dateDebut: \'"+Tools.formatDateToDisplay(date_debut)+"\', dateDebut: \'"+Tools.formatDateToDisplay(date_fin)+"\'}";
	}
}
