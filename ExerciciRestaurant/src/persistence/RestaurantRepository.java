package persistence;

import java.util.ArrayList;
import java.util.List;

import domain.Restaurant;

public class RestaurantRepository {
	
	public static List<Restaurant> restaurants= new ArrayList<>();

	
	
	
	public void addRestaurant (Restaurant restaurant) {
		
		restaurants.add(restaurant);
	}
	
	public Restaurant findRestaurantByName(String name) {
		
		return restaurants.stream().filter(x -> x.getName().equals(name)).findAny().get();
		
	}
	
}


