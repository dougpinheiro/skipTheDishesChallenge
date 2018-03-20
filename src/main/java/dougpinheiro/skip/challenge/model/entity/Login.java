package dougpinheiro.skip.challenge.model.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 64, name = "ID")
	private Integer id;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToOne
	private Customer customer;
	
	public Login(Integer id, Customer customer, String password) {
		super();
		this.id = id;
		this.login = customer.getEmail();
		this.password = generatePassword(password);
		this.customer = customer;
	}

	public Login(Customer customer, String password) {
		super();
		this.login = customer.getEmail();
		this.password = generatePassword(password);
		this.customer = customer;
	}

	protected String generatePassword(String clearPassword) {
		try {
			return new String(Base64.getEncoder().encode(MessageDigest.getInstance("MD5").digest(clearPassword.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = generatePassword(password);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", password=" + password + ", customer=" + customer + "]";
	}
	
}
