package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import tools.Tools;

@Entity
@Table(name="historique")
public class Historique implements Serializable {
	private static final long serialVersionUID = -7351729135012380019L;

	private Long id;
	private Calendar date = null;
	private Utilisateur utilisateur = null;
	private Code code = null;
	private Salle salle = null;
	
	public Historique(){}
	
	public Historique(Long id, Calendar date, Utilisateur utilisateur, Code code, Salle salle) {
		this.id = id;
		this.date = date;
		this.utilisateur = utilisateur;
		this.code = code;
		this.salle = salle;
	}
	
	public Historique(Calendar date, Utilisateur utilisateur, Code code, Salle salle) {
		this.date = date;
		this.utilisateur = utilisateur;
		this.code = code;
		this.salle = salle;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="date")
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utilisateur", nullable = false)
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_code", nullable = false)
	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_salle", nullable = false)
	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@Transient
	@Override
	public String toString() {
		return "User:{ id:"+id+", date: \'"+Tools.formatDateToDisplay(date)+", utilisateur: \'"+utilisateur.toString()+"\' , code: \'"+code.toString()+"\', salle: \'"+salle.toString()+"}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((salle == null) ? 0 : salle.hashCode());
		result = prime * result
				+ ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		Historique other = (Historique) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}
}
