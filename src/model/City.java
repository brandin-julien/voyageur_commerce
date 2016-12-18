package model;

public class City {

	public String name;
	public Double lat;
	public Double lon;
	
	public City(String name, Double lat, Double lon){
		this.name = name;
		this.lat= lat;
		this.lon= lon;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Double getLat() {
		// TODO Auto-generated method stub
		return lat;
	}

	public Double getLon() {
		// TODO Auto-generated method stub
		return lon;
	}
	
}
