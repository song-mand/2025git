package java_programming_assignment3;

public abstract class FoodItem {
	private String name;
	private double basePrice;
	private int quantity;

	FoodItem(){ }//constructor
	
	FoodItem(String name, double basePrice, int quantity) {//constructor with variables
		setName(name);
		setBasePrice(basePrice);
		setQuantity(quantity);
	}

	

	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected double getBasePrice() {
		return basePrice;
	}

	protected void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	protected int getQuantity() {
		return quantity;
	}

	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {//return information of the food
		return String.format("%d - %s = $%.2f\n", quantity, name, calculatePrice());
	}
	public abstract double calculatePrice();//depends on food type, not decided
	
	

}
