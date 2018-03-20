package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64, name = "ID")
	private Integer id;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CREATION")
	private String creation;
	
	@OneToMany
	private List<Order> orders;
	
	public Customer() {
		super();
	}

	public Customer(Integer id, String email, String name, String address, String password, String creation, List<Order> orders) throws NoSuchAlgorithmException {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.address = address;
		this.password = new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(password.getBytes())));
		this.creation = Calendar.getInstance().getTime().toString();;
		this.orders = orders;
	}

	public Customer(Integer id, String email, String name, String address, String password, String creation) throws NoSuchAlgorithmException {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.address = address;
		this.password = new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(password.getBytes())));
		this.creation = Calendar.getInstance().getTime().toString();;
	}

	public Customer(String email, String name, String address, String password, String creation) throws NoSuchAlgorithmException {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.password = new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(password.getBytes())));
		this.creation = Calendar.getInstance().getTime().toString();;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws NoSuchAlgorithmException {
		this.password = new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(password.getBytes())));;
	}

}