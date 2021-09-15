package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OrderItem database table.
 * 
 */
@Entity
@NamedQuery(name="OrderItem.findAll", query="SELECT o FROM OrderItem o")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrderItem;

	private int quantity;

	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="FoodMenu_idFoodMenu")
	private FoodItem foodItem;

	//bi-directional many-to-one association to TheOrder
	@ManyToOne
	@JoinColumn(name="TheOrder_idOrder")
	private TheOrder theOrder;

	public OrderItem() {
	}

	public int getIdOrderItem() {
		return this.idOrderItem;
	}

	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FoodItem getFoodItem() {
		return this.foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public TheOrder getTheOrder() {
		return this.theOrder;
	}

	public void setTheOrder(TheOrder theOrder) {
		this.theOrder = theOrder;
	}

}