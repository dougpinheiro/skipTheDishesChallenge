package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ORDERITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64, name = "ID")
	private Integer id;
	
	@OneToOne
	@JsonIgnore
	private Order order;

	@OneToOne
	private Product product;

	@Column(name = "PRICE", precision=2)
	private double price;

	@Column(name = "TOTAL", precision=2)
	private double total;

	@Column(length = 64, name = "QUANTITY")
	private Integer quantity;

	public OrderItem(Integer id, Product product, double price, double total,
			Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.total = total;
		this.quantity = quantity;
	}

	public OrderItem(Product product, double price, double total,
			Integer quantity) {
		super();
		this.product = product;
		this.price = price;
		this.total = total;
		this.quantity = quantity;
	}

	public OrderItem() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}