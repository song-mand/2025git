package java_programming_assignment3;
//Because I can not write won symbol, I replaced with $

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Menu menu=new Menu();
		Customer king=new Customer();
		
		menu.printOrdering();//print main menu
		menu.askOption();//ask choice
		int input;
		input=sc.nextInt();
		while(input!=6) {
			switch (input) {//operation with input number
				case 1:
					menu.addFastFood(king, sc);//add fastfood option to customer's orders
					menu.printOrdering();
					menu.askOption();
					input=sc.nextInt();//
					continue;
				case 2:
					menu.addTraditionalMeal(king, sc);//add traditional meal to customer's order
					menu.printOrdering();
					menu.askOption();
					input=sc.nextInt();
					continue;
				case 3:
					menu.addHealthyMeal(king, sc);//add healthy meal to customer's order
					menu.printOrdering();
					menu.askOption();
					input=sc.nextInt();
					continue;
				case 4:
					menu.viewOrders(king);//view whole orders of the customer
					menu.printOrdering();
					menu.askOption();
					input=sc.nextInt();
					continue;
				case 5:
					menu.checkout(king);//calculate total pay of customer and reset orders
					menu.printOrdering();
					menu.askOption();
					input=sc.nextInt();
					continue;
			}
		}
		if(input==6)
		{
			menu.goodBye();//goodbye
		}
	}

}
class Menu{    //Menu class-print orderlists ,ask for some needs and accept order
	Menu(){} 
	public void printOrdering()//print list of operation
	{
		System.out.println("--- Online Food Ordering ---");
		System.out.println("1. Order Fast Food");
		System.out.println("2. Order Traditional Meal");
		System.out.println("3. Order Healthy Meal");
		System.out.println("4. View Orders");
		System.out.println("5. Checkout");
		System.out.println("6. Exit");
	}
	public void askOption()//ask the customer to choose one of the six
	{
		System.out.print("Choose an option: ");
	}
	public void askfoodNum()//if customer chose 1 or 2 or 3 ask the specific dish
	{
		System.out.print("Enter food number: ");
	}
	public void askQuantity()//ask food amount customer wanting
	{
		System.out.print("Quantity: ");
	}
	public void askCombo() //if customer chose fastfood ask about combo
	{
		System.out.printf("Add combo (+$2.0 each)? (true/false): ");
	}
	public void askSoup() //if customer chose traditional meal ask about soup
	{
		System.out.printf("Add soup (+$1.5 each)? (true/false): ");
	}
	public void askOrganic() //if customer chose healthy meal ask about organic
	{
		System.out.printf("Add combo (+$1.0 each)? (true/false): ");
	}
	public void printFastFoodAdded()
	{
		System.out.println("Fast food added! ");
	}
	public void printTraditionalMealAdded()
	{
		System.out.println("Traditonal meal added! ");
	}
	public void printHealthyMealAdded()
	{
		System.out.println("Healthy meal added! ");
	}
	public void printTotalpay(double totalprice)//if customer chose to checkout(5) print total price
	{
		System.out.printf("Total to pay: $%.2f\nThank you for ordering!\n", totalprice);
	}
	public void goodBye()
	{
		System.out.println("Exitting...... Bye!");
	}
	
	public void addFastFood(Customer c, Scanner sc)
	{
		System.out.print("1. Cheeseburger ($8.00)\n2. Hot Dog ($7.50)\n3. Fried Chicken ($9.00)\n");
		askfoodNum();
		FoodItem item=new FastFood();//initialize fooditem data as fastfood
		String name="";//item's name
		double basePrice=0;//item's price
		int foodnum=sc.nextInt();
		switch (foodnum) {
		case 1://if cheeseburger
			name="Cheeseburger";
			basePrice=8;
			break;
		case 2://if hot dog
			name="Hot Dog";
			basePrice=7.5;
			break;
		case 3://if fried chicken
			name="Fried Chicken";
			basePrice=9;
			break;
		}
		askQuantity();
		int quantity=sc.nextInt();
		askCombo();
		String combo=sc.next();
		switch (combo) 
		{
			case "true"://if combo is true 2$ will be added to price for each object
				FastFood item1=new FastFood(name, basePrice, quantity, true);
				item=item1;
				break;
			case "false"://don't add 2$
				FastFood item2=new FastFood(name, basePrice, quantity, false);
				item=item2;
				break;
		}
		c.addOrder(item);//add order to customer's order list
		printFastFoodAdded();

	}
	
	public void addTraditionalMeal(Customer c, Scanner sc)//has same structure as addfastfood() method
	{
		System.out.print("1. Bibimbap ($10.00)\n2. Kimchi Stew ($9.50)\n3. Bulgogi ($11.00)\n");
		askfoodNum();
		FoodItem item=new TraditionalMeal();
		String name="";
		double basePrice=0;
		int foodnum=sc.nextInt();
		switch (foodnum) {
		case 1:
			name="Bibimbap";
			basePrice=10;
			break;
		case 2:
			name="Kimchi Stew";
			basePrice=9.5;
			break;
		case 3:
			name="Bulgogi";
			basePrice=11;
			break;
		}
		askQuantity();
		int quantity=sc.nextInt();
		askSoup();
		String soup=sc.next();
		switch (soup) 
		{
			case "true"://if soup is true 1.5$ will be added to price for each object
				TraditionalMeal item1=new TraditionalMeal(name, basePrice, quantity, true);
				item=item1;
				
				break;
			case "false":
				TraditionalMeal item2=new TraditionalMeal(name, basePrice, quantity, false);
				item=item2;
				break;
		}
		c.addOrder(item);
		printTraditionalMealAdded();
	}
	
	public void addHealthyMeal(Customer c, Scanner sc) //has same structure as addfastfood() method
	{
		System.out.print("1.Tofu salad ($8.00)\n2. Grilled Fish ($9.00)\n3. Brown Rice Bowl ($9.50)\n");
		askfoodNum();
		FoodItem item=new HealthyMeal();
		String name="";
		double basePrice=0;
		int foodnum=sc.nextInt();
		switch (foodnum) {
		case 1:
			name="Tofu salad";
			basePrice=8;
			break;
		case 2:
			name="Grilled Fish";
			basePrice=9;
			break;
		case 3:
			name="Brown Rice Bowl";
			basePrice=9.5;
			break;
		}
		askQuantity();
		int quantity=sc.nextInt();
		askOrganic();
		String soup=sc.next();
		switch (soup) 
		{
			case "true":
				HealthyMeal item1=new HealthyMeal(name, basePrice, quantity, true);
				item=item1;
				break;
			case "false":
				HealthyMeal item2=new HealthyMeal(name, basePrice, quantity, false);
				item=item2;
				break;
		}
		c.addOrder(item);
		printHealthyMealAdded();
	}
	
	public void viewOrders(Customer c)//print whole accepted order
	{
		for(int i=0;i<c.ordersize;i++)
		{
			System.out.println(c.order[i]);//print toString
		}
	}
	
	public void checkout(Customer c)//print total price and reset orderlist
	{
		double totalprice;
		totalprice=c.checkout();
		printTotalpay(totalprice);
		
	}
	
	public void exit()
	{
		goodBye();
	}
	
}
