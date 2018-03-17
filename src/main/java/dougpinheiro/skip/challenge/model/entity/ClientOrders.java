package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_ORDERS")
public class ClientOrders implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "ID_PRODUCT")
	private Long id_product;

	@Column(name = "ID_ORDER")
	private Long id_order;

	public ClientOrders(Long id_product, Long id_order) {
		super();
		this.id_product = id_product;
		this.id_order = id_order;
	}

	public ClientOrders() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ClientOrders)) {
			return false;
		}
		ClientOrders other = (ClientOrders) obj;
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

	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public Long getId_order() {
		return id_order;
	}

	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id_product != null)
			result += "id_product: " + id_product;
		if (id_order != null)
			result += ", id_order: " + id_order;
		return result;
	}
}