package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Solution {

	List<City> citySolution;
	double distance;
	
	public Solution(){
		citySolution = new ArrayList<City>();
		distance = this.getDistanceOfList();
	}
	
	public void addCityToList(City city){
		citySolution.add(city);
	}
	
	public void create(List<City> allCity){
		citySolution = new ArrayList<City>(allCity);
		this.randomizeList();
	}
	
	public void randomizeList(){
		Collections.shuffle(citySolution);
	}
	
	public Double getDistance(City city1, City city2){
		
		double earthRadius = 6371000;
        double dLat = Math.toRadians(city1.getLat()-city2.getLat());
        double dLng = Math.toRadians(city1.getLon()-city2.getLon());
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(city2.getLat())) * Math.cos(Math.toRadians(city1.getLat())) *
                   Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = (float) (earthRadius * c/ 1000);

        return dist;
	}
	
	public Double getDistanceOfList(){
		
		int index = 0;
		
		int listSize = citySolution.size();
		
		while(index <= listSize - 2){
			distance += getDistance(citySolution.get(index), citySolution.get(index + 1));
			index++;
		}
		return distance;
	}
	
	public void printList(){
		
		int index = 0;
		int listSize = citySolution.size();		
		while(index <= listSize - 2){
        	System.out.println(citySolution.get(index).getName());
			index++;
		}
	}
	
	public void printCitySolution(){
		
		int index = 0;
		int listSize = citySolution.size();	
		while(index <= listSize - 2){
        	System.out.println(citySolution.get(index).getName());
			index++;
		}
	}
	
	public void mutation(){
		Random rand = new Random();
		
		int max = citySolution.size()-1;
		int min = 0;
		
		int nombreAleatoire = rand.nextInt(max - min + 1) + min;
		int nombreAleatoire2 = rand.nextInt(max - min + 1) + min;
		
		while(nombreAleatoire == nombreAleatoire2){
			nombreAleatoire = rand.nextInt(max - min + 1) + min;
			nombreAleatoire2 = rand.nextInt(max - min + 1) + min;		
		}
		 Collections.swap(citySolution, nombreAleatoire, nombreAleatoire2);
		
	}
	
	public List<City> getAllCity() {
		return citySolution;
	}

	public void setAllCity(List<City> citySolution) {
		this.citySolution = citySolution;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<City> getCitySolution() {
		return citySolution;
	}

	public void setCitySolution(List<City> citySolution) {
		this.citySolution = citySolution;
	}
	
	public String toString(){
		
		String string = "";
		for (City item : citySolution) {
			string += item.getName() + " ";
		}
		return string;
	}
	
}
