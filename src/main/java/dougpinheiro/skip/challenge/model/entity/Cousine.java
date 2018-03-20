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

	public Cousine(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Cousine(String type) {
		super();
		this.type = type;
	}

	public Cousine() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64, name = "ID")
	private Integer id;

	@Column(name = "TYPE")
	private String type;
	
	@OneToMany(mappedBy="cousine")
	private List<Store> stores;
	
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}