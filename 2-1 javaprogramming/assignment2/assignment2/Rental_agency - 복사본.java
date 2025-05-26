package assignment2;
import java.util.ArrayList;
public class Rental_agency {
		
		ArrayList<vehicle> availablevehicles= new ArrayList<>();
		

		double totalrentalcost=0;
		Rental_agency(){}
		
		public void addVehicle(vehicle V)
		{
			availablevehicles.add(V);
			
		}
		public void display_available_vehicles()
		{
			int numofvehicle=availablevehicles.size();
			for (int i=0;i<numofvehicle;i++)
			{
				if(availablevehicles.get(i).isIsAvailable()==true) {
					System.out.println(availablevehicles.get(i).toString());
				}
			}
		}
		public void rent_vehicle(String ID, int days)
		{
			
			int index=0;
			while (index<availablevehicles.size()&&!ID.equals(availablevehicles.get(index).getID()))
			{
				index=index+1;
				//System.out.print(index);
			}
			
			
			if (availablevehicles.get(index).isIsAvailable()==true) {
			System.out.printf("You rented %s %s\n", availablevehicles.get(index).getBrand(), availablevehicles.get(index).getModel());
			System.out.println("Total Cost: $"+days*availablevehicles.get(index).getRentalprice());
			totalrentalcost+=days*availablevehicles.get(index).getRentalprice();
			
			availablevehicles.get(index).setIsAvailable(false);
			}
			else {
				System.out.println("Vehicle not available!");
			}
			
		}
		public void return_vehicle(String ID, int days)
		{
			for(int i=0;i<availablevehicles.size();i++)
			{
				
				if(availablevehicles.get(i).getID().equals(ID))//availablevehicles.get(i).isIsAvailable()==false&&availablevehicles.get(i).getID()==ID)
				{
					availablevehicles.get(i).setIsAvailable(true);
					System.out.printf("Vehicle returned: %s\n", availablevehicles.get(i).getBrand());
					System.out.printf("Cost for %d days: $%.1f\n", days, days*availablevehicles.get(i).getRentalprice());
					totalrentalcost-=days*availablevehicles.get(i).getRentalprice();
				}
			}
		}
		public double get_total_rentalcost()
		{
			return totalrentalcost;
		}
		
}
