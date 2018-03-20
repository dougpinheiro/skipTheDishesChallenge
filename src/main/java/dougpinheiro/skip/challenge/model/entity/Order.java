package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64, name = "ID")
	private Integer id;

	@Column(name = "DATE")
	private String date;


	@Column(name = "DELIVERYADDRESS")
	private String deliveryAddress;

	@Column(name = "CONTACT")
	private String contact;
	
	@Column(name = "TOTAL")
	private double total;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "LASTUPDATE")
	private String lastUpdate;

	@ManyToOne
	private Store store;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems;

	public Order(Integer id, String date, Customer customer, String deliveryAddress, String contact, Store store,
			double total, String status, String lastUpdate, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.contact = contact;
		this.store = store;
		this.total = total;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.orderItems = orderItems;
	}

	public Order(String date, Customer customer, String deliveryAddress, String contact, Store store,
			double total, String status, String lastUpdate, List<OrderItem> orderItems) {
		super();
		this.date = date;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.contact = contact;
		this.store = store;
		this.total = total;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.orderItems = orderItems;
	}

	public Order() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}


}