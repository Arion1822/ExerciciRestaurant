package view;
import java.util.Scanner;

import application.ControllerRestaurant;
import domain.Restaurant;

public class Main {

static Scanner sc=  new Scanner(System.in);
private static String[] tables= new String[24];
private static int cont=1;
	
	public static void main (String[] args) {
		try {
			String id= createRestaurant();
			selection(id);
						
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	private static void selection(String id) throws Exception {
		System.out.println("Que vols fer? (1: Mirar taules, 2: Afegir persones, 3:Elimnar persones)");
		int selection= sc.nextInt();
		
		switch(selection) {
		
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


	private static String createRestaurant()  throws Exception {
		String name= askName();
		return new ControllerRestaurant().createRestaurant(name);
		
	}
	private static void addPeople(String id) throws Exception{
		int capacity= Restaurant.MAXCAPACITY;
		
		while(capacity>0) {
			int people= askPeople();
			capacity= new ControllerRestaurant().addPeople(id, people);
			if(capacity==-1) {
				System.out.println("Numero massa gran");
				capacity=24;
			}  
			else {
				tables[cont-1]= new ControllerRestaurant().addTable(id, people);
				for(int i=0; i<cont; i++) {
					System.out.println(tables[i]);
				}
				cont++;
				System.out.println("Queda un espai de "+capacity+" persones");
				selection(id);
			}
			
		}
		
	}
	
	private static void removeTables(String id) throws Exception{
		int table= askTable();
		new ControllerRestaurant().RemoveTable(id, table);
		tables=new ControllerRestaurant().updateList(id);
		
		viewTables(id);
			
		
	}
	
	private static void viewTables(String id) throws Exception {
	
		for(int i=1; i<cont; i++) {
		System.out.println(tables[i-1]);
		}
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
