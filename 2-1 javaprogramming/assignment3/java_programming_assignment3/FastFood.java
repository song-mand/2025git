package java_programming_assignment3;

public class FastFood extends FoodItem{
	private boolean combo;
	FastFood(){}//constructor
	FastFood(String name, double basePrice, int quantity, boolean combo)//constructor with variables
	{
		setName(name);
		setBasePrice(basePrice);
		setQuantity(quantity);
		setIsCombo(combo);
	}
	
	public boolean isCombo()//return value of combo
	{
		return combo;
	}
	public void setIsCombo(boolean torf)
	{
		this.combo=torf;
	}
	public double calculatePrice()//calculate price of 'this' order
	{
		double price;
		if(isCombo()==true)// if the customer added combo, each meal price increases 2$
		{
			price=(2+getBasePrice())*getQuantity();
		}
		else
		{
			price=getBasePrice()*getQuantity();
		}
		return price;
	}
	
}

