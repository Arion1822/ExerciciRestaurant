package view;
import java.util.Scanner;

import application.ControllerRestaurant;
import domain.Restaurant;

public class Main {

static Scanner sc=  new Scanner(System.in);
	
	public static void main (String[] args) {
		try {
			String id= createRestaurant();
			addPeople(id);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	private static String createRestaurant()  throws Exception {
		String name= askName();
		return new ControllerRestaurant().createRestaurant(name);
		
	}
	private static void addPeople(String id) throws Exception{
		int capacity= Restaurant.MAXCAPACITY;
		String[] tables= new String[24];
		int cont=1;
		
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
			}
			
		}
		
	}
	
	public static String askName() {
		
		System.out.println("Introdueix el nom del restaurant: ");
		
		return sc.nextLine();
	}
	
	public static int askPeople() {
		
		System.out.println("Introdueix el numero d'integrants del grup: ");
		
		return sc.nextInt();
	}
	
}
