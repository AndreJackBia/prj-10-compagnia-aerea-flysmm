package sale;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	private Aircraft aircraft;
	private String idFlight;
	private Date departureDate;
	private Time departureTime;
	private Airport departureAirport;
	private Date arrivalDate;
	private Time arrivalTime;
	private Airport arrivalAirport;
	private Price price;
	private int distance;
	private int remainingSeats;

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public Flight() {
		super();
	}

	public Flight(Aircraft aircraft, Time arrivalTime, Time departureTime, String idFlight, Date departureDate,
			Airport departureAirport, Date arrivalDate, Airport arrivalAirport, Price price, int remainingSeats) {

		this.aircraft = aircraft;
		this.idFlight = idFlight;
		this.departureDate = departureDate;
		this.departureAirport = departureAirport;
		this.arrivalDate = arrivalDate;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.remainingSeats = remainingSeats;
	}

	public Flight(Flight f, Price p) {
		this.aircraft = f.getAircraft();
		this.idFlight = f.getIdFlight();
		this.departureDate = f.getDepartureDate();
		this.departureAirport = f.getDepartureAirport();
		this.arrivalDate = f.getArrivalDate();
		this.arrivalAirport = f.getArrivalAirport();
		this.departureTime = f.getDepartureTime();
		this.arrivalTime = f.getArrivalTime();
		this.price = p;
		this.remainingSeats = f.getRemainingSeats();
	}

	public Flight(String idFlight, Airport departureAirport, Airport arrivalAirport) {
		super();
		this.idFlight = idFlight;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public String getIdFlight() {
		return idFlight;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public void setIdFlight(String idFlight) {
		this.idFlight = idFlight;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Flight findFlightFromIdAndTariff(List<Flight> flights, String id, String tariff) {
		for (Flight temp : flights) {
			if (temp.getIdFlight().equals(id) && temp.getPrice().getSeats().getTariff().equals(tariff))
				return temp;
		}
		return null;
	}

}
