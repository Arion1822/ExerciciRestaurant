package view;

import java.util.Scanner;

import application.ControllerRestaurant;
import application.dto.RestaurantDTO;
import domain.Restaurant;
import domain.Table;

public class Main {

	static Scanner sc = new Scanner(System.in);
	private static String tables;
	public static int capacity;

	public static void main(String[] args) {
		try {
			capacity = Restaurant.MAXCAPACITY;
			Restaurant restaurant = createRestaurant();
			selection(restaurant.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void selection(String id) throws Exception {
		System.out.println("Que vols fer? (1: Mirar taules, 2: Afegir persones, 3:Elimnar persones)");
		int selection = sc.nextInt();

		switch (selection) {

		case 1:
			viewTables(id);
			break;
		case 2:
			addPeople(id);
			break;

		case 3:
			removeTables(id);

		default:
			throw new IllegalArgumentException("selection incorrect");
		}

	}

	private static Restaurant createRestaurant() throws Exception {
		String name = askName();
		return new ControllerRestaurant().createRestaurant(new RestaurantDTO(name));

	}

	private static void addPeople(String id) throws Exception {
				
		while (capacity > 0) {
			int people = askPeople();
			
			while (people > 6) {
				
				capacity = capacity - Table.MAXPEOPLEPERTABLE;
				tables = new ControllerRestaurant().addTable(id, Table.MAXPEOPLEPERTABLE);
				people= people-Table.MAXPEOPLEPERTABLE;
			} 	

			if (capacity == -1) {
				System.out.println("Numero massa gran");
				capacity = 24;
			} else {
				capacity = capacity - Table.MAXPEOPLEPERTABLE;
				tables = new ControllerRestaurant().addTable(id, people);

				System.out.println(tables);

				System.out.println("Queda un espai de " + capacity + " persones");
				selection(id);
			}

		}

	}

	private static void removeTables(String id) throws Exception {
		int table = askTable();
		new ControllerRestaurant().removeTable(id, table);
		tables = new ControllerRestaurant().updateList(id);
		viewTables(id);

	}

	private static void viewTables(String id) throws Exception {

		tables = new ControllerRestaurant().updateList(id);
		System.out.println(tables);

		selection(id);
	}

	public static String askName() {

		System.out.println("Introdueix el nom del restaurant: ");

		return sc.nextLine();
	}

	public static int askPeople() {

		System.out.println("Introdueix el numero d'integrants del grup: ");

		return sc.nextInt();
	}

	public static int askTable() {

		System.out.println("Introdueix el numero de taula a eliminar: ");

		return sc.nextInt();
	}

}
