package application;

import domain.Restaurant;
import persistence.RestaurantRepository;
import utilities.RestaurantUtilities;

public class ControllerRestaurant {

	
	public String createRestaurant(String name) {
		
		Restaurant restaurant= new Restaurant(name);
		new RestaurantRepository().addRestaurant(restaurant);
		
		return name;
	}
	
	
	public int addPeople(String name, int number) {
		
		Restaurant restaurant= new RestaurantRepository().findRestaurantByName(name);
		
		return restaurant.addPeople(number);
		
		
	}
	
	
}
