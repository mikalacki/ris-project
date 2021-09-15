package managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import models.FoodItem;
import models.OrderItem;
import models.Reservation;
import models.Restaurant;
import models.TheOrder;
import models.TheTable;
import models.User;

public class ReservationManager {

	static EntityManager em = JPAUtil.getEntityManager();

	static Date date = new Date();

	public static boolean reserveTheTable(User u, TheTable t) {

		try {

			em.getTransaction().begin();

			Reservation r = new Reservation();
			r.setDateAndTime(date);
			r.setUser(u);
			r.setTheTable(t);

			em.merge(r);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean reserveTheTableAndOrderFood(User u, TheTable t) {

		try {

			em.getTransaction().begin();
			TheOrder o = new TheOrder();
			Reservation r = new Reservation();
			byte status = 1;

			r.setDateAndTime(date);
			r.setUser(u);
			r.setTheTable(t);

			em.merge(r);

			o = addTheOrder(date, t);

			em.merge(o);

			t.setNumberOfSeats(2);
			t.setStatus(status);
			t.setRestaurant(em.find(Restaurant.class, 2));
			em.persist(t);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.close();
			return false;
		}

	}

	public static TheOrder addTheOrder(Date d, TheTable t) {

		List<OrderItem> orders = new ArrayList<OrderItem>();
		for (int i = 0; i < t.getNumberOfSeats(); i++) {
			int fi = 6;
			int q = 1;
			OrderItem oi = addOrderItem(fi, q);
			orders.add(oi);
		}

		TheOrder order = new TheOrder();

		order.setOrderDate(date.toString());
		order.setTheTable(t);
		order.setOrderItems(orders);

		return order;
	}

	public static OrderItem addOrderItem(int fiid, int q) {

		try {

			FoodItem fi = em.find(FoodItem.class, fiid);
			OrderItem oi = new OrderItem();

			oi.setFoodItem(fi);
			oi.setQuantity(q);
			oi.setTheOrder(em.find(TheOrder.class, 1));

			return oi;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		User u = em.find(User.class, 3);
		TheTable t = em.find(TheTable.class, 6);

		boolean b = reserveTheTable(u, t);

	}
}
