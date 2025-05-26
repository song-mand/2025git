package assignment2;

import java.util.Scanner;

public class main {

	public void printmenu()
	{
		System.out.println("=====Vehicle Rental System=====");
		System.out.println("1. View Available Vehicles");
		System.out.println("2. Rent a Vehicle");
		System.out.println("3. Return a Vehicle");
		System.out.println("4. View Total Cost");
		System.out.println("5. Exit");
		System.out.println("Enter your choice: ");

	}
	
	public static void main(String[] args) {
		
		String menu="=====Vehicle Rental System=====\n1. View Available Vehicles\n2. Rent a Vehicle\n3. Return a Vehicle\n"
				+ "4. View Total Cost\n5. Exit\nEnter your choice: "
		;
		System.out.printf("%s", menu);
		int input;
		Scanner sc=new Scanner(System.in);
		input=sc.nextInt();
		Rental_agency rentalagency=new Rental_agency();
		rentalagency.addVehicle(new Car("aaa","toyota","dragon",50,true,4));
		rentalagency.addVehicle(new Motorcycle("bbb","harley","davison",70,true,false));
		rentalagency.addVehicle(new Truck("ccc","ford","hippo",100,true,2000));
		while (input!=5)
		{
			switch (input) {
			case 1: 
				rentalagency.display_available_vehicles();
				System.out.printf("%s", menu);
				input=sc.nextInt();
				break;
			case 2:
				System.out.print("Enter Vehicle ID to rent: ");
				String ID=sc.next();
				System.out.print("Enter number of days: ");
				int days=sc.nextInt();
				rentalagency.rent_vehicle(ID, days);
				System.out.printf("%s", menu);
				input=sc.nextInt();
				break;
			case 3:
				System.out.print("Enter Vehicle ID to return: ");
				String id=sc.next();
				System.out.print("Enter number of days rented: ");
				int Days=sc.nextInt();
				rentalagency.return_vehicle(id, Days);
				System.out.printf("%s", menu);
				input=sc.nextInt();
				break;
			case 4:
				double cost=rentalagency.get_total_rentalcost();
				System.out.printf("Total Amount Due: %.1f\n", cost);
				System.out.printf("%s", menu);
				input=sc.nextInt();
				break;
			}
			
		}
		
		if (input==5) {
			System.out.println("Exitting ... Thank You!");
		}
		
		
		
	}

}
