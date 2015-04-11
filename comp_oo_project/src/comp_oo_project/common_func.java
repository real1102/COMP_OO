package comp_oo_project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class common_func {
	public void prop_JComp_in_array(ArrayList Arr,boolean enable){
		Iterator itr = Arr.iterator();
		while(itr.hasNext()){
    		JComponent this_object= (JComponent) itr.next();
    		this_object.setEnabled(enable);
    	}
	}
	public void prop_JComp_in_array(ArrayList Arr){
		prop_JComp_in_array(Arr,true);
	}
	public void set_center(JFrame JF){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JF.setLocation(dim.width/2-JF.getSize().width/2, dim.height/2-JF.getSize().height/2);
	}
}
