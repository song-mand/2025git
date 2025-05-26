package java_programming_assignment3;

public class HealthyMeal extends FoodItem {
	private boolean organic;
	HealthyMeal(){}
	HealthyMeal(String name, double basePrice, int quantity, boolean organic)
	{
		setName(name);
		setBasePrice(basePrice);
		setQuantity(quantity);
		setIsOrganic(organic);
	}
	private boolean isOrganic()
	{
		return organic;
	}
	private void setIsOrganic(boolean torf)
	{
		this.organic=torf;
	}
	public double calculatePrice()//calculate price of 'this' order
	{
		double price;
		if(isOrganic()==true)// if the customer added organic, each meal price increases 1$
		{
			price=(1+getBasePrice())*getQuantity();
		}
		else
		{
			price=getBasePrice()*getQuantity();
		}
		return price;
	}
}
