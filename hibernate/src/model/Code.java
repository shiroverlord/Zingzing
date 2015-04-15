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
@Table(name="code")
public class Code implements Serializable {
	private static final long serialVersionUID = -2381710710838826641L;
	
	private Long id;
	private String value = null;
	
	public Code(){}
	
	public Code(Long id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public Code(String value) {
		this.value = value;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="value")
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Transient
	@Override
	public String toString() {
		return "Code:{ id:"+id+"\', value: \'"+value+"\'}";
	}
}
