package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TheOrder database table.
 * 
 */
@Entity
@NamedQuery(name="TheOrder.findAll", query="SELECT t FROM TheOrder t")
public class TheOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder;

	private String orderDate;

	//bi-directional many-to-one association to OrderItem
	@OneToMany(mappedBy="theOrder")
	private List<OrderItem> orderItems;

	//bi-directional many-to-one association to TheTable
	@ManyToOne
	@JoinColumn(name="TheTable_idTheTable")
	private TheTable theTable;

	public TheOrder() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderItem addOrderItem(OrderItem orderItem) {
		getOrderItems().add(orderItem);
		orderItem.setTheOrder(this);

		return orderItem;
	}

	public OrderItem removeOrderItem(OrderItem orderItem) {
		getOrderItems().remove(orderItem);
		orderItem.setTheOrder(null);

		return orderItem;
	}

	public TheTable getTheTable() {
		return this.theTable;
	}

	public void setTheTable(TheTable theTable) {
		this.theTable = theTable;
	}

}