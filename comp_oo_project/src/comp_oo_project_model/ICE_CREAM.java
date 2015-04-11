package comp_oo_project_model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ICE_CREAM {
	private String flavor;
	private int flavor_price;
	private ArrayList<String> decorators;
	private int price;
	
	public ICE_CREAM(){
		this.price=0;
		this.flavor="";
		this.flavor_price=0;
		this.decorators = new ArrayList<String>();
	}

	public int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}
	
	private int getFlavorPrice(){
		return flavor_price;
	}
	
	private void setFlavorPrice(int price){
		this.flavor_price = price;
	}
	
	private void addPrice(int price){
		int new_price = this.price + price;
		setPrice(new_price);
	}
	
	private void minusPrice (int price){
		int new_price = this.price - price;
		setPrice(new_price);
	}

	public String getFlavor() {
		return flavor;
	}

	private void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	public int setFlavor(String flavor, int price){
		if (this.flavor_price ==0){
			setFlavorPrice(price);
			addPrice(price);

			
		}else{
			minusPrice(getFlavorPrice());
			addPrice(price);
			setFlavorPrice(price);
		}
		setFlavor(flavor);
		return getPrice();
		
		
	}

	public ArrayList<String> getDecorators() {
		return decorators;
	}

	private void setDecorators(ArrayList<String> decorators) {
		this.decorators = decorators;
	}
	
	public int addDecorators(String new_decorator, int price){
		if(!this.decorators.contains(new_decorator)){
			this.decorators.add(new_decorator);
			addPrice(price);
		}
		else{
			int dialogResult=JOptionPane.showConfirmDialog(null, "You already got " + new_decorator + " as decorator, are you sure to add more?");
			if(dialogResult==JOptionPane.YES_OPTION){
				this.decorators.add(new_decorator);
				addPrice(price);
			}
		}
		
		return getPrice();
	}
	
	public String icecream_to_string(){
		String ice_cream="Flavor :\n" + getFlavor();
		String deco_string="";
		for(String de : getDecorators()){
			deco_string = deco_string + de + " \n";
		}
		if(!deco_string.equals("")){
			ice_cream = ice_cream + "\n\nDecorators:\n" + deco_string;
		}
		return ice_cream;
	}
	
}
