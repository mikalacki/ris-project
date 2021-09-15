package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Restaurant database table.
 * 
 */
@Entity
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRestaurant;

	private String adress;

	private String city;

	@Column(name="name_restaurant")
	private String nameRestaurant;

	//bi-directional many-to-one association to TheTable
	@OneToMany(mappedBy="restaurant")
	private List<TheTable> theTables;

	public Restaurant() {
	}

	public int getIdRestaurant() {
		return this.idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNameRestaurant() {
		return this.nameRestaurant;
	}

	public void setNameRestaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}

	public List<TheTable> getTheTables() {
		return this.theTables;
	}

	public void setTheTables(List<TheTable> theTables) {
		this.theTables = theTables;
	}

	public TheTable addTheTable(TheTable theTable) {
		getTheTables().add(theTable);
		theTable.setRestaurant(this);

		return theTable;
	}

	public TheTable removeTheTable(TheTable theTable) {
		getTheTables().remove(theTable);
		theTable.setRestaurant(null);

		return theTable;
	}

}