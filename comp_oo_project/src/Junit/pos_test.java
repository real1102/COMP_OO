package Junit;

import java.util.ArrayList;

import junit.framework.TestCase;
import comp_oo_project.*;
import comp_oo_project_model.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class pos_test extends TestCase{

	private ICE_CREAM ice_cream;
	private IC_flavor IC;
	private Decorator DE;
	
	public void setUp()
	{
		ice_cream = new ICE_CREAM();
		ice_cream.setFlavor("IC_flavor", 20);
		ice_cream.addDecorators("decorator1", 3);
		ice_cream.addDecorators("decorator2", 4);
		
		IC = new IC_flavor("Test Flavor",10);
		DE = new Decorator("Test Decorator",3);
	}
	
	
	
	@Test
	public void test() {
		
		ArrayList<String> expected_arraylist= new ArrayList<String>();
		expected_arraylist.add("decorator1");
		expected_arraylist.add("decorator2");
		//Decorator
		assertEquals(3, DE.getPrice());
		assertEquals("Test Decorator",DE.getDecorator());
		//flavor
		assertEquals(10, IC.getPrice());
		assertEquals("Test Flavor",IC.getFlavor());
		//ice_cream
		assertEquals("IC_flavor", ice_cream.getFlavor());
		assertEquals(expected_arraylist,ice_cream.getDecorators());
		assertEquals(27,ice_cream.getPrice());
		
		
		
		ice_cream.addDecorators("decorator2", 4);//if select Yes then follow test should pass
		expected_arraylist.add("decorator2");
		assertEquals(expected_arraylist,ice_cream.getDecorators());
		
		assertEquals(31,ice_cream.getPrice());
		
		System.out.println(ice_cream.icecream_to_string());
		
	}

}
