package managers;

import java.util.List;

import javax.persistence.EntityManager;

import models.Administrator;
import models.FoodItem;

public class MeniManager {

	static EntityManager em = JPAUtil.getEntityManager();

	public static boolean addFood(String mealName, String type) {

		try {
			em.getTransaction().begin();

			FoodItem fm = new FoodItem();
			fm.setMealName(mealName);
			fm.setType(type);

			em.merge(fm);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static List<FoodItem> getAllFoodItem() {
		EntityManager em = JPAUtil.getEntityManager();
		List<FoodItem> menu = em.createQuery("SELECT fi FROM FoodItem fi").getResultList();
		return menu;
	}
	
	public static void main(String[] args) {
		
		boolean b = addFood("Karadjordjeva snicla", "peceno meso");
		boolean a = addFood("Karbonare", "pasta");
		boolean c = addFood("Pileca supa", "supa");
	}

}
