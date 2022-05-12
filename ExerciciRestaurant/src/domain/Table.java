package domain;

public class Table {

	private static int count=1;
	public String id;
	public int numPeople;
	
	
	public Table(int numPeople) {
		this.id= ""+count++;
		this.numPeople=numPeople;
		
	}
	
	public String getId() {
		return this.id;
	}
}
