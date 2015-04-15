package comp_oo_project;

import javax.swing.*;

import comp_oo_project_model.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.*;


public class POS_UI {
	private JTextField price_text= new JTextField();
	private Hashtable<String,IC_flavor> IC_data=new Hashtable<>();
	private Hashtable<String,Decorator> DE_data=new Hashtable<>();
	private ArrayList<JButton> IC_button = new ArrayList<JButton>();
	private ArrayList<JButton> DE_button = new ArrayList<JButton>();
	//commun function class
	private common_func common_func = new common_func();
	//The current ice cream
	private ICE_CREAM this_ice_cream;
	private JTextArea ice_desc=new JTextArea(8,40);

	public void setDE_data(Hashtable<String,Decorator> dE_data) {
		DE_data = dE_data;
	}

	public void setIC_data(Hashtable<String,IC_flavor> iC_data) {
		IC_data = iC_data;
	}
	
	public POS_UI(Hashtable<String, IC_flavor> IC_data , Hashtable<String, Decorator> DE_data) {
		this.setIC_data(IC_data);
		this.setDE_data(DE_data);
    }
	
	public void show_layout(){
		final JFrame main_frame = new JFrame("Ice Crean POS");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(500, 500);
        common_func.set_center(main_frame);
        main_frame.setLayout(new BorderLayout());
       
        update_price_text(0);
        update_iceDesc("");
		price_text.setEnabled(false);
		ice_desc.setEnabled(false);
//Top bar 
		JPanel top_bar = new JPanel(new BorderLayout());
		JButton new_btn = new JButton("New Sales");
	        
        new_btn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		common_func.prop_JComp_in_array(IC_button);
        		common_func.prop_JComp_in_array(DE_button,false);
        		this_ice_cream = new ICE_CREAM();
        		update_price_text();
        		update_iceDesc("");
        		//auto_ic();
            }
        });
        
        top_bar.add(new_btn,BorderLayout.NORTH);
		
		JPanel menu_bar = new JPanel(new GridLayout(1,2));
		
		menu_bar.add(new JLabel("ICE-Cream Flavor",SwingConstants.CENTER));
		menu_bar.add(new JLabel("Decorator",SwingConstants.CENTER));
		top_bar.add(menu_bar,BorderLayout.SOUTH);
        		
		JPanel content_bar = new JPanel(new GridLayout(1,2)); 
		JPanel IC_bar = new JPanel(new GridLayout(3,1));
		JPanel DE_bar = new JPanel(new GridLayout(3,1));
		
		for (IC_flavor IC : IC_data.values()) {
			JButton btn=new JButton(IC.getFlavor());
			btn.setToolTipText("$"+Integer.toString(IC.getPrice()));
			btn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String this_IC = ((JButton) e.getSource()).getText();
	                common_func.prop_JComp_in_array(DE_button);
	                this_ice_cream.setFlavor(this_IC, IC_data.get(this_IC).getPrice());
	                update_price_text();
	                update_iceDesc();
	            }
	        });
			btn.setEnabled(false);
			IC_button.add(btn);
            IC_bar.add(btn);
		}

		for (Decorator DE : DE_data.values()) {
			JButton btn=new JButton(DE.getDecorator());
			btn.setToolTipText("$"+Integer.toString(DE.getPrice()));
			btn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String this_DE = ((JButton) e.getSource()).getText();
	                this_ice_cream.addDecorators(this_DE, DE_data.get(this_DE).getPrice());
	                update_price_text();
	                update_iceDesc();
	            }
	        }); 
			btn.setEnabled(false);
			DE_button.add(btn);
            DE_bar.add(btn);
		}
        content_bar.add(IC_bar,BorderLayout.WEST);
        content_bar.add(DE_bar,BorderLayout.EAST);
//bottom bar 
        JPanel bottom_bar = new JPanel(new BorderLayout());
        JButton admin_btn = new JButton("Sys Admin");
        
        admin_btn.addActionListener(new ActionListener() {
        	public void actionPerformed (ActionEvent e) {
        		
        		final JFrame dialog_frame = new JFrame("Add New Item");
        		dialog_frame.setSize(300, 150);
        		common_func.set_center(dialog_frame);
        		dialog_frame.setLayout(new BorderLayout());
                
                JPanel left_bar = new JPanel(new GridLayout(3,1));
                JPanel right_bar = new JPanel(new GridLayout(3,1));
                left_bar.add(new JLabel("Name: ",SwingConstants.CENTER));
                final JTextField item_name=new JTextField();
                right_bar.add(item_name);
                left_bar.add(new JLabel("Price: ",SwingConstants.CENTER));

                final JTextField item_price = new JTextField();
                right_bar.add(item_price);
                
                
                final JComboBox<String> item_type = new JComboBox<String> ();
                item_type.addItem("Ice-Cream Flavor");
                item_type.addItem("Decorator");
                left_bar.add(item_type);
                JButton add_item=new JButton("Add item");
                add_item.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		if(item_name.getText().equals("") || item_price.getText().equals("")){
                			JOptionPane.showMessageDialog(dialog_frame, "Name and Price must be filled.");
                			if(item_name.getText().equals(""))
                				item_name.requestFocus();
                			else
                				item_price.requestFocus();
                			
                		}
                		else{
                			try {
                			     Integer.parseInt(item_price.getText());
                			     if(item_type.getSelectedItem().equals("Ice-Cream Flavor")){
     			                	if(IC_data.containsKey(item_name.getText())){
     			                		JOptionPane.showMessageDialog(dialog_frame, "\""+item_name.getText() + "\" already Exist in Ice Cream Flavor");
     			                	}
     			                	else{
     			                		IC_data.put(item_name.getText(),new IC_flavor(item_name.getText(),Integer.parseInt(item_price.getText())));
     			                		dialog_frame.dispose();
     			                		main_frame.dispose();
     			                        show_layout();
     			                	}
     			                }else{
     			                	if(DE_data.containsKey(item_name.getText())){
     			                		JOptionPane.showMessageDialog(dialog_frame, "\""+item_name.getText() + "\" already Exist in Decorator");
     			                	}
     			                	else{
     			                		DE_data.put(item_name.getText(),new Decorator(item_name.getText(),Integer.parseInt(item_price.getText())));
     			                		dialog_frame.dispose();
     			                		main_frame.dispose();
     			                        show_layout();
     			                	}
     			                }
                			}
                			catch (NumberFormatException nfe) {
                				JOptionPane.showMessageDialog(dialog_frame, "Please input integer in Price Field");
                				item_price.requestFocus();
                			}
			                
                		}
		            }
		        }); 
                
                right_bar.add(add_item);
                dialog_frame.add(left_bar,BorderLayout.WEST);
                dialog_frame.add(right_bar);
                dialog_frame.pack();
                dialog_frame.setResizable(false);
                dialog_frame.setVisible(true);

            }
        });

        bottom_bar.add(admin_btn,BorderLayout.SOUTH);
        
        JPanel price_bar=new JPanel(new GridLayout(1,2));
        price_bar.add(new JLabel("Total:"));
        price_bar.add(price_text);
        
        
        
        bottom_bar.add(price_bar,BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane( ice_desc );
        bottom_bar.add(scrollPane,BorderLayout.NORTH);
        
//add all bars in panel
        main_frame.add(top_bar,BorderLayout.NORTH);
        main_frame.add(content_bar,BorderLayout.CENTER);
        main_frame.add(bottom_bar,BorderLayout.SOUTH);
        main_frame.setResizable(false);
        main_frame.setVisible(true);
	}

	
	private void update_price_text(){
		price_text.setText(Integer.toString(this_ice_cream.getPrice()));
	}
	private void update_price_text(int price){
		price_text.setText(Integer.toString(price));
	}
	
	private void update_iceDesc(){
		ice_desc.setText(this_ice_cream.icecream_to_string());
	}
	private void update_iceDesc(String text){
		ice_desc.setText(text);
	}
	
	
	
}
