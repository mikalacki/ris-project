package managers;

import javax.persistence.EntityManager;

import models.User;

public class UserManager {

	static EntityManager em = JPAUtil.getEntityManager();

	public User loginUser(String username, String password) {

		try {
			User u = (User) em
					.createQuery("SELECT u FROM User u WHERE username_user=:username AND password_user=:password",
							User.class)
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static String registerUser(String name, String lastname, String username, String password) {
		try {

			em.getTransaction().begin();

			User u = new User();
			u.setNameUser(name);
			u.setLastnameUser(lastname);
			u.setUsernameUser(username);
			u.setPasswordUser(password);

			em.persist(u);
			em.getTransaction().commit();
			return "User is successfully registered";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "neuspeh";
		}

	}
	
public static void main(String[] args) {
		
		String a = registerUser("Milos", "Mikalacki", "miki", "123456");
		
	}

}
