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
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column
	private double cost;	
	
	@OneToMany
	private Set<ClientOrders> clientOrders; 
	
	public Long getId() {
		return this.id;
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
		this.id = id;
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
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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

}