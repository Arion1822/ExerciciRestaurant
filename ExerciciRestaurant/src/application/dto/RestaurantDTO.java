package application.dto;

import domain.Restaurant;

public class RestaurantDTO {

	private String id;
	private String nameRestaurant;
	private int numberOfClients;

	public RestaurantDTO(String name) {

		this.nameRestaurant = name;

	}

	public RestaurantDTO(Restaurant restaurant) {

		this.numberOfClients = restaurant.getNumberOfClients();
		this.nameRestaurant = restaurant.getName();
		this.id = restaurant.getId();
	}

	public String getId() {
		return id;
	}

	public String getNameRestaurant() {
		return nameRestaurant;
	}

	public int getNumberOfClients() {
		return numberOfClients;
	}

}
