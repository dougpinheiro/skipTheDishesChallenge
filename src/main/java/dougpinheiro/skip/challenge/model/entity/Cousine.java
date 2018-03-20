package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COUSINE")
public class Cousine implements Serializable {

	private static final long serialVersionUID = 1L;

	public Cousine(Integer id, String type, List<StoreCousine> storecousine) {
		super();
		this.id = id;
		this.type = type;
		this.storecousine = storecousine;
	}

	public Cousine(String type, List<StoreCousine> storecousine) {
		super();
		this.type = type;
		this.storecousine = storecousine;
	}

	public Cousine(String type) {
		super();
		this.type = type;
	}

	public Cousine() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 64, name = "ID")
	private Integer id;

	@Column(name = "TYPE")
	private String type;
	
	@OneToMany(mappedBy="cousine")
	private List<StoreCousine> storecousine;
	
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public List<StoreCousine> getStorecousine() {
		return storecousine;
	}

	public void setStorecousine(List<StoreCousine> storecousine) {
		this.storecousine = storecousine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}