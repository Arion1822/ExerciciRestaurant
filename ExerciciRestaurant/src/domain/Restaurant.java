package domain;

public class Restaurant {

	
	public String nameRestaurant;
	public int actualCapacity;
	public static final int MAXCAPACITY= 24;
	
	public Restaurant( String name) {
		
		this.actualCapacity=0;
		this.nameRestaurant= name;
	}
	
	public int addPeople(int number) {
		actualCapacity+=number;
		return MAXCAPACITY- actualCapacity;
	
	}

	public String getName() {
		
		return this.nameRestaurant;
	}
	public int getActualCapacity() {
		return this.actualCapacity;
				
	}
}
