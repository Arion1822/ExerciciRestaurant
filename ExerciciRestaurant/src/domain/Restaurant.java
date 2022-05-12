package domain;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

	private static int count=0;
	public String id;
	public String nameRestaurant;
	public int actualCapacity;
	public static final int MAXCAPACITY= 24;
	
	public List<Table> tables= new ArrayList<>();
	
	
	
	public Restaurant(String name) {
		
		this.actualCapacity=0;
		this.nameRestaurant= name;
		this.id= ""+count++;
	}
	
	public int addPeople(int number) {
		actualCapacity+=number;
		return MAXCAPACITY- actualCapacity;
	
	}
	public String  createTable(int number) {
		Table table= new Table(number);
		tables.add(table);
		return table.getId();
	}
	public void removeTable(int number) {
		System.out.println("UWU");
		tables.remove(number);
	}
	public String getName() {
		
		return this.nameRestaurant;
	}
	public int getActualCapacity() {
		return this.actualCapacity;
				
	}
	public List<Table> updateList() {
		return this.tables;
	}
	public String getId() {
		return this.id;
	}
}
