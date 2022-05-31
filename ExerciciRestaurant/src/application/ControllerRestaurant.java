package application;

import application.dto.RestaurantDTO;
import domain.Restaurant;
import domain.Table;
import persistence.RestaurantRepository;


public class ControllerRestaurant {

	
	public Restaurant createRestaurant(RestaurantDTO restdto) {
		
		Restaurant restaurant= new Restaurant(restdto);
		
		new RestaurantRepository().addRestaurant(restaurant);
		
		return restaurant;
	}
	
	public String addTable(String id, int number) throws Exception {
		String tableId= null;
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		while(number>Table.MAXPEOPLEPERTABLE) {
			tableId=restaurant.createTable(Table.MAXPEOPLEPERTABLE);
			number= number-Table.MAXPEOPLEPERTABLE;
		}
		
		tableId=restaurant.createTable(number);
		
		
		return "Taula "+ tableId+" : "+ number+ " persones"; 
	
		
	}
	public void removeTable(String id, int number) {
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		restaurant.removeTable(number);
		
	}
	
	public int addPeople(String id, int number) throws Exception{
		
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		if(number> 24) {
			return -1;
		}
		return restaurant.addPeople(number);
		
		
	}
	public String updateList(String id) {
		Restaurant restaurant= new RestaurantRepository().findRestaurantById(id);
		return  restaurant.updateList();
	}
	
	
	
}
