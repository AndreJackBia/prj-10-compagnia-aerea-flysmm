package sale;

import java.io.Serializable;

public class Airport implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String icao;
	private String name;
	private Address airportAndress; 

	public Airport() {
		super();
	}

	public Airport(String icao, String name, Address airportAndress) {
		super();
		this.icao = icao;
		this.name = name;
		this.airportAndress = airportAndress;
	}

	public Airport(String icao, String name) {
		super();
		this.icao = icao;
		this.name = name;
	}

	public String getIcao() {
		return icao;
	}

	public String getName() {
		return name;
	}
	
	public Address getAirportAndress() {
		return airportAndress;
	}
	
	public void setIcao(String icao) {
		this.icao = icao;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAirportAddress(Address airportAndress) {
		this.airportAndress = airportAndress;
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + "]";
	}

}
