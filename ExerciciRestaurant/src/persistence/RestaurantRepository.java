package persistence;

import java.util.ArrayList;
import java.util.List;

import domain.Restaurant;

public class RestaurantRepository {

	public static List<Restaurant> restaurants = new ArrayList<>();

	public void addRestaurant(Restaurant restaurant) {

		restaurants.add(restaurant);
	}

	public Restaurant findRestaurantById(String id) {

		return restaurants.stream().filter(x -> x.getId().equals(id)).findAny().get();

	}

}
