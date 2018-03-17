package dougpinheiro.skip.challenge.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dougpinheiro.skip.challenge.model.data.Status;

@Entity
@Table(name = "CLIENTORDER")
public class ClientOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column
	@Temporal(TemporalType.DATE)
	private Date orderTime;

	@Enumerated
	@Column(name = "STATUS")
	private Status status;

	@Column(name = "DELIVERY_TIME")
	@Temporal(TemporalType.DATE)
	private Date deliveryTime;
	
	@OneToMany
	private Set<ClientOrders> clientOrders;

	public ClientOrder(Date orderTime, Status status) {
		super();
		this.orderTime = orderTime;
		this.status = status;
	}

	public ClientOrder() {
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
		if (!(obj instanceof ClientOrder)) {
			return false;
		}
		ClientOrder other = (ClientOrder) obj;
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

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

}