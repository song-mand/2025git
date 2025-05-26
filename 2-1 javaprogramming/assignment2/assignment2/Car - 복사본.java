package assignment2;

public class Car extends vehicle{
	private int doors;
	
	Car(){}
	
	Car(String ID, String brand, String model, double rentalprice, boolean IsAvailable, int doors)
	{
		this.brand=brand; this.model=model; 
		this.ID=ID; this.rentalprice=rentalprice; 
		this.IsAvailable=IsAvailable; this.doors=doors;
	}
	
	public int getdoors()
	{
		return doors;
	}
	

}
