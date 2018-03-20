package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 64, name = "ID")
	private Integer id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CREATION")
	private String creation;
	
	@OneToMany
	private List<Order> orders;

	
	
	public Customer(Integer id, String email, String name, String address, String creation, Login login,
			List<Order> orders) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.address = address;
		this.creation = creation;
		this.orders = orders;
	}

	public Customer(String email, String name, String address, String creation, Login login,
			List<Order> orders) {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.creation = creation;
		this.orders = orders;
	}

	public Customer(String email, String name, Login login) {
		super();
		this.email = email;
		this.name = name;
		this.creation = Calendar.getInstance().getTime().toString();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}