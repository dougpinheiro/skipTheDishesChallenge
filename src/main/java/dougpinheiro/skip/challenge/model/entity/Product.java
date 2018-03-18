package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long idProduct;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name="COST")
	private double cost;	
	
	@OneToMany
	private Set<ClientOrders> clientOrders; 
	
	public Long getId() {
		return this.idProduct;
	}
	
	public Product(String description, double cost) {
		super();
		this.description = description;
		this.cost = cost;
	}
	
	public Product() {
		super();
	}

	public void setId(final Long id) {
		this.idProduct = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		if (idProduct != null) {
			if (!idProduct.equals(other.idProduct)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
		return result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (description != null && !description.trim().isEmpty())
			result += "description: " + description;
		DecimalFormat df = new DecimalFormat("$#.##");
		result += ", cost: " + df.format(cost);
		return result;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Set<ClientOrders> getClientOrders() {
		return clientOrders;
	}

	public void setClientOrders(Set<ClientOrders> clientOrders) {
		this.clientOrders = clientOrders;
	}

}