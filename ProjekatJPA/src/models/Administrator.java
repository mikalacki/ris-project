package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Administrator database table.
 * 
 */
@Entity
@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrator;

	@Column(name="lastname_admin")
	private String lastnameAdmin;

	@Column(name="name_admin")
	private String nameAdmin;

	@Column(name="password_admin")
	private String passwordAdmin;

	@Column(name="username_admin")
	private String usernameAdmin;

	public Administrator() {
	}

	public int getIdAdministrator() {
		return this.idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public String getLastnameAdmin() {
		return this.lastnameAdmin;
	}

	public void setLastnameAdmin(String lastnameAdmin) {
		this.lastnameAdmin = lastnameAdmin;
	}

	public String getNameAdmin() {
		return this.nameAdmin;
	}

	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}

	public String getPasswordAdmin() {
		return this.passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public String getUsernameAdmin() {
		return this.usernameAdmin;
	}

	public void setUsernameAdmin(String usernameAdmin) {
		this.usernameAdmin = usernameAdmin;
	}

}