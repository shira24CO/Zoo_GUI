package homework4;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * This class represents the window which is opened to allow the user to feed the animals in the zoo.
 * @author Ilan Shklover 206753550 , Shira Cohen 211777834
 *
 */

public class Food extends JDialog {
	/**
	 * all the animal types in the zoo.
	 */
	private JComboBox animals;
	
	/**
	 * Buttons of the food available for the animals in the zoo.
	 */
	private JButton cabbage,lettuce,meat,save;
	private Component[] components;
	
	/**
	 * Represents the choice of the food when feeding the animals:
	 * 1 for cabbage
	 * 2 for lettuce
	 * 3 for meat
	 */
	private static int food_choice;
	
	/**
	 * Constructor of the window of choosing the food for the animal we want to feed in the zoo.
	 */
	public Food() {
		super();
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 2));
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
	
		cabbage = new JButton("Cabbage");
		cabbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == cabbage) {
					food_choice = 1; 
					ZooPanel.set_plant_food(new Cabbage(5,new Point(300,200),5));
					JOptionPane.showMessageDialog(null, "Saved");
					ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_zoo_panel().repaint();
					//component = new Component();
					if(e.getSource()== meat || e.getSource()== lettuce) {
						ZooPanel.set_plant_food(null);
						
					}
				}	
			}
			});
				
					
		
		lettuce = new JButton("Lettuce");
		lettuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == lettuce) {
					food_choice = 2;
					ZooPanel.set_plant_food(new Lettuce(5,new Point(300,200),5));
					JOptionPane.showMessageDialog(null, "Saved");
					ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_zoo_panel().repaint();
					if(e.getSource()== meat || e.getSource()== cabbage) {
						ZooPanel.set_plant_food(null);
						
					}
				}	
			}
			});
		
		
		meat = new JButton("Meat");
		meat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == meat) {
					food_choice =3;
					//ZooPanel.set_meat(new Meat(5.0,new Point(300,200),5.0));
					ZooPanel.set_meat(Meat.getInstance(5.0, new Point(300,200), 5.0));
					JOptionPane.showMessageDialog(null, "Saved");
					ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_zoo_panel().repaint();
				}	if(e.getSource() == cabbage || e.getSource() == lettuce) {
						ZooPanel.set_meat(null);

				}
			}
			});
		
		
		
		
		animals = new JComboBox(ZooPanel.get_animal_array());
		save = new JButton("Save animal");
		Object[] options_food_car = {meat};
		Object[] options_food_om = {cabbage,lettuce,meat};
		Object[] options_food_her = {cabbage,lettuce};
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == save) {
					JOptionPane.showMessageDialog(null, "Saved");
					switch(ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_name_of_class()) {
					case("Lion"):
						JOptionPane.showOptionDialog(save,//parent container of JOptionPane
						        "Please choose food ",
						        "Food for animals",
						        JOptionPane.YES_NO_CANCEL_OPTION,
						        JOptionPane.QUESTION_MESSAGE,
						        null,//do not use a custom Icon
						        options_food_car,//the titles of buttons
						        null);//default button title	
					    break;
					case("Bear"):
						JOptionPane.showOptionDialog(save,//parent container of JOptionPane
						        "Please choose food ",
						        "Food for animals",
						        JOptionPane.YES_NO_CANCEL_OPTION,
						        JOptionPane.QUESTION_MESSAGE,
						        null,//do not use a custom Icon
						        options_food_om,//the titles of buttons
						        null);//default button title	
					    break;
					case("Giraffe"):
						JOptionPane.showOptionDialog(save,//parent container of JOptionPane
						        "Please choose food ",
						        "Food for animals",
						        JOptionPane.YES_NO_CANCEL_OPTION,
						        JOptionPane.QUESTION_MESSAGE,
						        null,//do not use a custom Icon
						        options_food_her,//the titles of buttons
						        null);//default button title	
					    break;
					case("Turtle"):
						JOptionPane.showOptionDialog(save,//parent container of JOptionPane
						        "Please choose food ",
						        "Food for animals",
						        JOptionPane.YES_NO_CANCEL_OPTION,
						        JOptionPane.QUESTION_MESSAGE,
						        null,//do not use a custom Icon
						        options_food_her,//the titles of buttons
						        null);//default button title	
					    break;
					case("Elephant"):
						JOptionPane.showOptionDialog(save,//parent container of JOptionPane
						        "Please choose food ",
						        "Food for animals",
						        JOptionPane.YES_NO_CANCEL_OPTION,
						        JOptionPane.QUESTION_MESSAGE,
						        null,//do not use a custom Icon
						        options_food_her,//the titles of buttons
						        null);//default button title	
					    break;
					}
				}
				}
			});
		this.add(animals);
		this.add(save);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * returns the choice of the food(1,2 or 3).
	 * @return the choice of the food to feed the animal in the zoo.
	 */
	public static synchronized int get_food_choice() {return food_choice;}
	
	/**
	 * 
	 * @param choice - the choice of the food when feeding an animal in the zoo.
	 * @return the choice of the food when feeding an animal in the zoo.
	 */
	public static synchronized boolean set_food_choice(int choice) {
		food_choice = choice;
		return true;
	}

}
