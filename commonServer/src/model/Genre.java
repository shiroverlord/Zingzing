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
@Table(name="genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	private Long id;
	private String genre = null;
	
	public Genre(){}
	
	public Genre(Long id, String genre) {
		this.id = id;
		this.genre = genre;
	}
	
	public Genre(String motdepasse) {
		this.genre = motdepasse;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="genre")
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Transient
	@Override
	public String toString() {
		return "Genre:{ id:"+id+"\', genre: \'"+genre+"\'}";
	}
}
