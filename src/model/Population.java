package model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Population {
	
	List<Solution> allSolution;
	List<City> allCity;
	
	public Population(){
		allCity = new ArrayList<City>();
		allSolution = new ArrayList<Solution>();	
		this.readJson();
	}
	
	public void createSolution(int maxOfIteration){
		int numberOfIteration = 0;
        
		while (numberOfIteration < maxOfIteration){
			
            Solution solution = new Solution();
			solution.create(this.getAllCity());
			this.addSolutionToList(solution);
			
			numberOfIteration += 1;
		}
	}
	
	public void readJson(){
		JSONParser parser = new JSONParser();
        try {
 
            Object obj = parser.parse(new FileReader("voyageur_commerce.git/data/city_sample.json"));
 
            JSONArray jsonArray = (JSONArray) obj;

            @SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = jsonArray.iterator();
            
            while (iterator.hasNext()) {
                 JSONObject object = iterator.next();
                 String name = (String) object.get("name");
                 Double lat = (Double) object.get("lat");
                 Double lon = (Double) object.get("lon");
                 City city = new City(name,lat,lon);
                 this.addCityToList(city);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void calculDistanceOfSolution(){
		
		int x = 0;
		
		while(x < this.getAllSolution().size()){
			Solution solution = this.getAllSolution().get(x);
			solution.setDistance(solution.getDistanceOfList());
			x += 1;
		}
		
	}
	
	public void mutateList(){
		int x = 0;

		while(x < this.getAllSolution().size() - 1){
			Solution solution = this.getAllSolution().get(x);
			solution.mutation();
			x += 1;
		}
	}

	public void selectList(){
		List<Solution> tempList = new ArrayList<>();

		for (Solution item : allSolution) {
		  tempList.add(item);
		  if(tempList.size() == Math.round(allSolution.size()/2))
			  break;
		}
		allSolution.clear();
		allSolution = new ArrayList<>(tempList);
	}
	
	public void displayBestList(){
		
		for(int i = 0; i < 10; i++){
			System.out.println(allSolution.get(i).toString());
			System.out.println(allSolution.get(i).getDistance());
		}
		
	}
	
	public void addCityToList(City city){
		allCity.add(city);
	}
	
	public void sortList(){
		Collections.sort(allSolution, new Comparator<Solution>() {

			@Override
			public int compare(Solution o1, Solution o2) {
				// TODO Auto-generated method stub
				return o1.getDistance() < o2.getDistance() ? -1 :o1.getDistance()  == o2.getDistance() ? 0 : 1;
			}
		});
	}
	
	public void addSolutionToList(Solution solution){
		allSolution.add(solution);
	}

	public List<Solution> getAllSolution() {
		return allSolution;
	}

	public void setAllSolution(List<Solution> allSolution) {
		this.allSolution = allSolution;
	}

	public List<City> getAllCity() {
		return allCity;
	}

	public void setAllCity(List<City> allCity) {
		this.allCity = allCity;
	}
}
