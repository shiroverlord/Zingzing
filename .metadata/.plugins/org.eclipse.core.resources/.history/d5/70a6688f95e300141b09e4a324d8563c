package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Transient;

@Embeddable
public class AutoriserID implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	protected Long id_droit;
	protected Long id_salle;
	
	public AutoriserID(){}
	
	public AutoriserID(Long id_droit, Long id_salle) {
		this.id_droit = id_droit;
		this.id_salle = id_salle;
	}

	@Id
	@Column(name="id_droit", nullable=false)
	public Long getIdDroit() {
		return id_droit;
	}

	public void setIdDroit(Long id_droit) {
		this.id_droit = id_droit;
	}
	
	@Id
	@Column(name="id_salle", nullable=false)
	public Long getIdSalle() {
		return id_salle;
	}
	
	public void setIdSalle(Long id_code) {
		this.id_salle = id_code;
	}
	
	@Transient
	@Override
	public String toString() {
		return "AutoriserID:{ idDroit:"+id_droit+"\', idSalle: \'"+id_salle+"\'}";
	}
}
