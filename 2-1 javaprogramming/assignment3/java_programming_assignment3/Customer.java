package java_programming_assignment3;
import java.util.Arrays;
import java.util.ArrayList;

public class Customer {
	public static final int MAX=100; //max orderlist size
	FoodItem order[]=new FoodItem[MAX];//type FoodItem array with 100size
	int ordersize=0;//filled indices number
	
	
	Customer(){}
	public void addOrder(FoodItem newfood)
	{
		if(ordersize>=100)//if orderlist is full
		{
			System.out.println("Too many orders!");
		}
		else
		{
			order[ordersize]=newfood;//add new order at the tale of list
			ordersize++;//ordersize increment
		}
	}
	
	public void viewOrder()//view all order info
	{
		for(int i=0;i<ordersize;i++)
		{
			System.out.println(order[i].toString());
		}
	}
	
	public double checkout()//calculate price and reset orderlist
	{
		double totalPrice=0;
		
		for(int i=0;i<ordersize;i++)//summarize all order price
		{
			totalPrice+=order[i].calculatePrice();
		}
		ordersize=0;//reset orderlist
		return totalPrice;
	}
	public FoodItem[] getOrders()
	{
		return order;
	}
	public void setOrders(FoodItem[] order)
	{
		this.order=order;
	}
}
