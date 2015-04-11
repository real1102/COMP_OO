package comp_oo_project;

import java.util.Hashtable;

import comp_oo_project_model.Decorator;
import comp_oo_project_model.IC_flavor;

public class Start {
	public static void main(String[] args){
		Hashtable<String,IC_flavor> IC_data=new Hashtable<>();
		Hashtable<String,Decorator> DE_data=new Hashtable<>();
		IC_data.put("Chocolate",new IC_flavor("Chocolate",20));
		IC_data.put("Mango",new IC_flavor("Mango",20));
		IC_data.put("Seasonal",new IC_flavor("Seasonal",22));
		DE_data.put("chocolate chips",new Decorator("chocolate chips"));
		DE_data.put("marshmallow",new Decorator("marshmallow"));
		
		POS_UI pos=new POS_UI(IC_data,DE_data);
		pos.show_layout();
		
	}
}
