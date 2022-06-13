package domain;

import java.util.UUID;

import application.dto.TableDTO;

public class Table {

	private static int count = 1;
	public String id;
	public int numPeople;
	public static final int MAXPEOPLEPERTABLE = 6;

	public Table(TableDTO table) {
		this.id = UUID.randomUUID().toString();

		this.numPeople = table.getNumPeople();

	}

	public String getId() {
		return this.id;
	}

	public int getPeople() {
		return this.numPeople;
	}
	
}
