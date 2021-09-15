package managers;

import javax.persistence.EntityManager;

import models.Administrator;

public class AdministratorManager {

	static EntityManager em = JPAUtil.getEntityManager();

	public static String register(String name, String lastname, String username, String password) {
		// ako je a true dodajemo Administratora, a ako je a false onda dodajemo usera
		// tako cemo razlikovati korisnike i admine

		try {

			em.getTransaction().begin();

			Administrator admin = new Administrator();

			admin.setNameAdmin(name);
			admin.setLastnameAdmin(lastname);
			admin.setUsernameAdmin(username);
			admin.setPasswordAdmin(password);

			em.merge(admin);
			em.getTransaction().commit();

			return "Admin successfully registerd";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "neuspeh";
		}

	}

	public Administrator loginAdmin(String username, String password) {
		try {

			Administrator a = (Administrator) em
					.createQuery(
							"SELECT a FROM Administrator a WHERE username_admin=:username AND password_admin=:password",
							Administrator.class)
					.setParameter("username", username).setParameter("password", password).getSingleResult();

			return a;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		String a = register("Milos", "Mikalacki", "miki", "123456");
		
	}
}
