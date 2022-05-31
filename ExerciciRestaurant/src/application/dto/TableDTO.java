package application.dto;

import domain.Table;

public class TableDTO {
	

	private String id;
	private int numPeople;
	
	public TableDTO(int numPeople){
		
	
		this.numPeople=numPeople;
		
	}
	
	public TableDTO(Table table){
		this.id= table.getId();
	
		this.numPeople=table.getPeople();
		
	}

	public String getId() {
		return id;
	}

	public int getNumPeople() {
		return numPeople;
	}
}
