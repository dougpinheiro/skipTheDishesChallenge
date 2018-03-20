package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STORECOUSINE")
public class StoreCousine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 64, name = "ID")
	private Integer id;
	
	@ManyToOne
	private Store store;
	
	@ManyToOne
	private Cousine cousine;

	public StoreCousine(Integer id, Store store, Cousine cousine) {
		super();
		this.id = id;
		this.store = store;
		this.cousine = cousine;
	}

	public StoreCousine(Store store, Cousine cousine) {
		super();
		this.store = store;
		this.cousine = cousine;
	}

	public StoreCousine() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Cousine getCousine() {
		return cousine;
	}

	public void setCousine(Cousine cousine) {
		this.cousine = cousine;
	}


}