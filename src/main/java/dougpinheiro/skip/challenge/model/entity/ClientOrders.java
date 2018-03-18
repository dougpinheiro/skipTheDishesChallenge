package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_ORDERS")
public class ClientOrders implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long idClientOrders;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idClientOrder")
	private ClientOrder clientOrder;

	public ClientOrders() {
		super();
	}

	public Long getId() {
		return this.idClientOrders;
	}

	public void setId(final Long id) {
		this.idClientOrders = id;
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
		if (idClientOrders != null) {
			if (!idClientOrders.equals(other.idClientOrders)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClientOrders == null) ? 0 : idClientOrders.hashCode());
		return result;
	}


	public ClientOrders(Long idClientOrders, Product product, ClientOrder clientOrder) {
		super();
		this.idClientOrders = idClientOrders;
		this.product = product;
		this.clientOrder = clientOrder;
	}

	public ClientOrders(Product product, ClientOrder clientOrder) {
		super();
		this.product = product;
		this.clientOrder = clientOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getIdClientOrders() {
		return idClientOrders;
	}

	public void setIdClientOrders(Long idClientOrders) {
		this.idClientOrders = idClientOrders;
	}

	public ClientOrder getClientOrder() {
		return clientOrder;
	}

	public void setClientOrder(ClientOrder clientOrder) {
		this.clientOrder = clientOrder;
	}
}