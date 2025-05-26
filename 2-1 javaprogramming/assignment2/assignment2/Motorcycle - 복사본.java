package assignment2;

public class Motorcycle extends vehicle {
	private boolean hassidecar;

	Motorcycle(){}
	
	Motorcycle(String ID, String brand, String model, double rentalprice, boolean IsAvailable, boolean hassidecar)
	{
		this.brand=brand; this.model=model; 
		this.ID=ID; this.rentalprice=rentalprice; 
		this.IsAvailable=IsAvailable; this.hassidecar=hassidecar;
	}
	
	public boolean hassidecar() {
		return hassidecar;
	}

	
}
