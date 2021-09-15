package managers;

import javax.persistence.EntityManager;

import models.Restaurant;
import models.TheTable;

public class TheTableManager {

	static EntityManager em = JPAUtil.getEntityManager();
	
	public static boolean addTheTable(int numberOfSeats, byte status) {
		
		try {
			em.getTransaction().begin();
			
			TheTable t = new TheTable();
			
			t.setNumberOfSeats(numberOfSeats);
			t.setStatus(status);
			t.setRestaurant(em.find(Restaurant.class, 2));
			
			em.merge(t);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static void main(String[] args) {
		byte s = 0;
		boolean b = addTheTable(4, s);
	}
}
