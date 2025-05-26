package assignment2;

public class Truck extends vehicle {

	private double loadcapacity;

	Truck(){}
	Truck(String ID, String brand, String model, double rentalprice, boolean IsAvailable, double loadcapacity)
	{
		this.brand=brand; this.model=model; 
		this.ID=ID; this.rentalprice=rentalprice; 
		this.IsAvailable=IsAvailable; this.loadcapacity=loadcapacity;
	}
	
	public double getLoadcapacity() {
		return loadcapacity;
	}

	
	

}
