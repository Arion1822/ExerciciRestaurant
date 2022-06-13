package application;

import application.dto.RestaurantDTO;
import domain.Restaurant;
import persistence.RestaurantRepository;

public class ControllerRestaurant {

	public Restaurant createRestaurant(RestaurantDTO restdto) {

		Restaurant restaurant = new Restaurant(restdto);

		new RestaurantRepository().addRestaurant(restaurant);

		return restaurant;
	}

	public String addTable(String id, int number) throws Exception {
		String tableId = null;
		Restaurant restaurant = new RestaurantRepository().findRestaurantById(id);
		tableId = restaurant.createTable(number);
		return "Taula " + tableId + " : " + number + " persones";

	}

	public void removeTable(String id, int number) {
		Restaurant restaurant = new RestaurantRepository().findRestaurantById(id);
		restaurant.removeTable(number);

	}

	public String updateList(String id) {
		Restaurant restaurant = new RestaurantRepository().findRestaurantById(id);
		return restaurant.updateList();
	}
	
	public int getNumberOfClients(String id) {
		Restaurant restaurant = new RestaurantRepository().findRestaurantById(id);
		return restaurant.getNumberOfClients();
	}

}
