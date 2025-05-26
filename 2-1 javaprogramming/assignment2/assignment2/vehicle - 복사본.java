package assignment2;

public class vehicle extends Rental_agency {
	
	protected String brand;
	protected String model;
	protected String ID;
	protected double rentalprice;
	protected boolean IsAvailable;
	
	vehicle() {
		brand="";
		model="";
		ID="";
		rentalprice=0;
		IsAvailable=true;
	}
	public vehicle(String ID, String brand, String model, double rentalprice, boolean IsAvailable)
	{
		this.brand=brand; this.model=model; 
		this.ID=ID; this.rentalprice=rentalprice; 
		this.IsAvailable=IsAvailable;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getRentalprice() {
		return rentalprice;
	}
	public void setRentalprice(double rentalprice) {
		this.rentalprice = rentalprice;
	}
	public boolean isIsAvailable() {
		return IsAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		IsAvailable = isAvailable;
	}
	public String toString()
	{
		String avornot="";
		if(IsAvailable==true) {
			avornot="Available";
		}
		else {
			avornot="not Available";
		}
		return String.format("%s - %s %s ($%.2f perday) - %s", ID, brand, model, rentalprice, avornot);
	}
}
