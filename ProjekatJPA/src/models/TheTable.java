package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TheTable database table.
 * 
 */
@Entity
@NamedQuery(name="TheTable.findAll", query="SELECT t FROM TheTable t")
public class TheTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTheTable;

	private int numberOfSeats;

	private byte status;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="theTable")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="Restaurant_idRestaurant")
	private Restaurant restaurant;

	//bi-directional many-to-one association to TheOrder
	@OneToMany(mappedBy="theTable")
	private List<TheOrder> theOrders;

	public TheTable() {
	}

	public int getIdTheTable() {
		return this.idTheTable;
	}

	public void setIdTheTable(int idTheTable) {
		this.idTheTable = idTheTable;
	}

	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setTheTable(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setTheTable(null);

		return reservation;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<TheOrder> getTheOrders() {
		return this.theOrders;
	}

	public void setTheOrders(List<TheOrder> theOrders) {
		this.theOrders = theOrders;
	}

	public TheOrder addTheOrder(TheOrder theOrder) {
		getTheOrders().add(theOrder);
		theOrder.setTheTable(this);

		return theOrder;
	}

	public TheOrder removeTheOrder(TheOrder theOrder) {
		getTheOrders().remove(theOrder);
		theOrder.setTheTable(null);

		return theOrder;
	}

}