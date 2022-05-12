package application;

import java.util.List;

import domain.Restaurant;
import domain.Table;
import persistence.RestaurantRepository;
import utilities.RestaurantUtilities;

public class ControllerRestaurant {

	
	public String createRestaurant(String name) {
		
		Restaurant restaurant= new Restaurant(name);
		new RestaurantRepository().addRestaurant(restaurant);
		
		return restaurant.getId();
	}
	
	public String addTable(String id, int number) {
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		
		String tableId=restaurant.createTable(number);
		return "Taula "+ tableId+" : "+ number+ " persones"; 
	
		
	}
	public void RemoveTable(String id, int number) {
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		restaurant.removeTable(number);
		
	}
	
	public int addPeople(String id, int number){
		
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		if(restaurant.actualCapacity+number> 24) {
			return -1;
		}
		return restaurant.addPeople(number);
		
		
	}
	public List<Table> updateList(String id) {
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		return restaurant.updateList();
	}
	
	
	
}
