package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FoodItem database table.
 * 
 */
@Entity
@NamedQuery(name="FoodItem.findAll", query="SELECT f FROM FoodItem f")
public class FoodItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFoodMenu;

	private String mealName;

	private int priceOfFood;

	private String type;

	//bi-directional many-to-one association to OrderItem
	@OneToMany(mappedBy="foodItem")
	private List<OrderItem> orderItems;

	public FoodItem() {
	}

	public int getIdFoodMenu() {
		return this.idFoodMenu;
	}

	public void setIdFoodMenu(int idFoodMenu) {
		this.idFoodMenu = idFoodMenu;
	}

	public String getMealName() {
		return this.mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public int getPriceOfFood() {
		return this.priceOfFood;
	}

	public void setPriceOfFood(int priceOfFood) {
		this.priceOfFood = priceOfFood;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderItem addOrderItem(OrderItem orderItem) {
		getOrderItems().add(orderItem);
		orderItem.setFoodItem(this);

		return orderItem;
	}

	public OrderItem removeOrderItem(OrderItem orderItem) {
		getOrderItems().remove(orderItem);
		orderItem.setFoodItem(null);

		return orderItem;
	}

}