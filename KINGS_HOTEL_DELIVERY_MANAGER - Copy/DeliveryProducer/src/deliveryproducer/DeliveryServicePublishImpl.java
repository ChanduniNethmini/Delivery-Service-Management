package deliveryproducer;

import java.util.ArrayList;

public class DeliveryServicePublishImpl  implements DeliveryServicePublish{
	
	ArrayList<String> district = new ArrayList<String>();
	ArrayList<Float> price = new ArrayList<Float>();
		
		public void defaultList() {
			
			district.add("Colombo district for bike per km");
			price.add((float) 150.00);
			
			district.add("Colombo district for lorry per km");
			price.add((float) 200.00);
			
			district.add("Colombo district for car per km");
			price.add((float) 200.00);
			
			district.add("Gampaha district for bike per km");
			price.add((float) 200.00);
			
			district.add("Gampaha district for car per km");
			price.add((float) 300.00);
			
			district.add("Gampaha district for lorry per km");
			price.add((float) 300.00);
		}

		public void printItemList() {
			System.out.println("********** Delivery Area List **********");
			System.out.println("*We accept orders within Colombo & Gampaha*");
			System.out.println(" ");
			for (int i = 0; i < price.size(); i++)
			  {
		        System.out.println(i+1 + "  " +district.get(i) +"  Rs:"+price.get(i));
		      }
			System.out.println("------------------END-------------------");
		}

	@Override
	public String publicService() {
		return "Execute the Delivery service of ServicePublisher";
	}

	
	
	@Override
	public String LoginVerification(String username, String password) {
		// TODO Auto-generated method stub
		if((username.equals("admin")) && (password.equals("123"))){
			return "admin";
		}
		else if((username.equals("cashier")) && (password.equals("789"))) {
			return "cashier";
		}else {
			return "invalid";
		}
	}


	public void addItem(String dName, float dCost) {
		district.add(dName);
		price.add((float) dCost);
	}
	
	public void removeItem(int dId) {
		district.remove(dId-1);
		price.remove(dId-1);
	}
	
	public float calculateBill(int dId, int Qty,int count) {
		float dCost = price.get(dId-1);
		float total = (dCost*Qty);
		System.out.println((count+1) +") "+ district.get(dId-1) +" * "+ Qty + " = " + total);
		return total;
	}
	
	public float calcSubTotal(float total, float discount) {
		float subtotal = (total-((total/100)*discount));
		return subtotal;
	}

	public int getListSize() {
		
		return district.size();
	}
	
	public float calcBalance(float subTotal, float cash) {
		
		return (cash - subTotal);
	}


}
