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
@Table(name = "STORE")
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 64, name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany
	private List<Order> orders;
	
	@OneToMany
	private List<Product> products;
	
	@OneToMany
	private List<StoreCousine> storeCousine;
	
	public Store(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Store(String name) {
		super();
		this.name = name;
	}

	public Store() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<StoreCousine> getStoreCousine() {
		return storeCousine;
	}

	public void setStoreCousine(List<StoreCousine> storeCousine) {
		this.storeCousine = storeCousine;
	}
	
}