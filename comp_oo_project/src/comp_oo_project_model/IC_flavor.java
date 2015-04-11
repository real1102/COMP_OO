package comp_oo_project_model;

public class IC_flavor {
	private String flavor;
	private int price;
	
	public IC_flavor(String flavor , int price){
		this.flavor = flavor;
		this.price=price;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
}
