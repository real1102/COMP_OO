package comp_oo_project_model;

public class Decorator {
	private String decorator;
	private int price = 4;
	
	public Decorator(String decorator ){
		this.decorator = decorator;
	}
	
	public Decorator(String decorator , int price){
		this.decorator = decorator;
		this.price=price;
	}
	
	public String getDecorator() {
		return decorator;
	}
	public void setDecorator(String decorator) {
		this.decorator = decorator;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
