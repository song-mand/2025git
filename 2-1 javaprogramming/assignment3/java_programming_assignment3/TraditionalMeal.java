package java_programming_assignment3;

public class TraditionalMeal extends FoodItem {
	private boolean soup;
	TraditionalMeal(){}//constructor
	TraditionalMeal(String name, double basePrice, int quantity, boolean soup)//constructor with variables
	{
		setName(name);
		setBasePrice(basePrice);
		setQuantity(quantity);
		setIsSoup(soup);
	}
	
	private boolean isSoup()
	{
		return soup;
	}
	private void setIsSoup(boolean torf)
	{
		this.soup=torf;
	}
	public double calculatePrice()//calculate price of 'this' order
	{
		double price;
		if(isSoup()==true)// if the customer added soup, each meal price increases 1.5$
		{
			price=(1.5+getBasePrice())*getQuantity();
		}
		else
		{
			price=getBasePrice()*getQuantity();
		}
		return price;
	}
}
