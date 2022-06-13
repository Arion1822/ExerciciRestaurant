package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import application.dto.RestaurantDTO;
import application.dto.TableDTO;

public class Restaurant {

	public String id;
	public String nameRestaurant;
	public int numberOfClients=0;

	public static final int MAXCAPACITY = 24;
	public static final int MAXTABLES = 4;

	public List<Table> tables = new ArrayList<>();

	public Restaurant(RestaurantDTO restaurant) {

		this.nameRestaurant = restaurant.getNameRestaurant();
		this.id = UUID.randomUUID().toString();
		
	}

	public String createTable(int number) throws Exception {
		if (tables.size() >= MAXTABLES)
			throw new Exception("Mesas llenas");

		else {
			if(checkAmountPeople(number + numberOfClients)) {
				while (number > Table.MAXPEOPLEPERTABLE) {
				Table table = new Table(new TableDTO(Table.MAXPEOPLEPERTABLE));
				tables.add(table);
				numberOfClients=Table.MAXPEOPLEPERTABLE+ numberOfClients;
				System.out.println(numberOfClients);
				number = number - Table.MAXPEOPLEPERTABLE;
			}
			Table table = new Table(new TableDTO(number));
			tables.add(table);
			return table.getId();
			}
			throw new Exception("Error personas");
			
		}
	}

	public void removeTable(int number) {
		numberOfClients= numberOfClients-tables.remove(number - 1).getPeople();
	

	}
	
	public boolean checkAmountPeople(int number) throws Exception {

		if (number > 24) return false;
		
		else return true;
		
	}

	public String getName() {

		return this.nameRestaurant;
	}

	public String updateList() {
		String aux = "";

		for (int i = 0; i < tables.size(); i++) {
			aux += "Taula " + tables.get(i).getId() + " : " + tables.get(i).getPeople() + " persones \n";
		}
		return aux;
	}

	public String getId() {
		return this.id;
	}

	public int getNumberOfClients() {
		return numberOfClients;
	}
}
