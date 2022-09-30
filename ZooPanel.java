package homework4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 * The area of the animals in the zoo.
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 *
 */

public class ZooPanel extends JPanel implements Runnable {
	/**
	 * array of animals
	 */
	private static Animal[] animal_array = new Animal[10];
	/**
	 * Plant - cabbage or lettuce which are food for the animals in the zoo.
	 */
	private static Plant plant;
	
	/**
	 * food for bears and lions in the zoo.
	 */
	private static Meat meat ;
	
	/** 
	 * States if an animal is edible by another animal in the zoo.
	 */
	private static boolean isEdible = true;
	
	/**
	 * The thread of the zoo panel.
	 */
	private Thread controller;
	
	/**
	 * ID for each background of the panel:
	 * 1 for the savanna.
	 * 2 for green background.
	 * 3 for default background.
	 */
	private static int image_identifier;
	
	private static ZooPanel zoo_panel = null;
	
	/**
	 * constructor of zooPanel
	 */
	private ZooPanel() {
		super();
		this.controller = new Thread(this);
		this.controller.start();
	}
	
	public static ZooPanel getInstance() {
		if(zoo_panel == null)
			zoo_panel = new ZooPanel();
		return zoo_panel;
	}
	
	
	
	/**
	 * 
	 * @param animal - new animal to add to the array of animals in the zoo.
	 * @return true if succeeded to add the new animal to the array. Else,return false.
	 */
	public static boolean set_animal_array(Animal animal) {
			for(int i=0 ; i<= AddAnimalDialog.get_counter();i++) {
				if(animal_array[i] == null) {
					animal_array[i] = animal;
				System.out.println("added");
					break;
				}
			}
			return true;
	}
	
	/**
	 * Returns the animal in a specific index in the array of the animals in the zoo.
	 * @param index - index in the animal array.
	 * @return the animal in the parameter index of the animals array.
	 */
	public static Animal getAnimal(int index) { 
		return animal_array[index];
	}
	
	
	/**
	 * Removes an animal from the animals array.
	 * @param animal - an animal to remove from the array of animals.
	 */
	public void remove_object(Animal animal) {
		synchronized(this) {
			int i;
			for(i=0;i<AddAnimalDialog.get_counter();i++) {
				if(animal_array[i] == animal) {
					animal_array[i] = animal_array[AddAnimalDialog.get_counter()];
					animal_array[AddAnimalDialog.get_counter()] = null;
					AddAnimalDialog.set_counter(AddAnimalDialog.get_counter()-1);
					break;
				}
			}
		
		}
	}
	
	/**
	 * 
	 * @return plant-food of herbivore.
	 */
	public static Plant get_plant_food() {
		return plant;
	}
	
	/**
	 * Returns food for lions and bears in the zoo.
	 * @return food for lions and bears in the zoo.
	 */
	public static Meat get_meat() {
		return meat;
	}
	
	
	/**
	 * Returns the zoo panel thread.
	 * @return the zoo panel thread.
	 */
	public Thread get_controller() {
		return this.controller;
	}
	
	
	
	/**
	 * 
	 * @param p -food of herbivore(luttece or cabbege)
	 * @return true if succeeded to initialize the field 'plant'.
	 */
	public static boolean set_plant_food(Plant p) {
			if(p.get_name_of_class() == "Lettuce")
				plant = new Lettuce(5,new Point(300,200),5);
			else if(p.get_name_of_class() == "Cabbage")
				plant = new Cabbage(5,new Point(300,200),5);
			else
				plant = null;
			return true;
		
	}
	
	
	/**
	 * 
	 * @param m - object of class Meat
	 * @return true if succeeded to initialize the field 'meat'.
	 */
	public static Boolean set_meat(Meat m) {
		if(m!= null) {
			meat = Meat.getInstance(5.0,new Point(300,200),5.0);
		}
		else {
			meat = Meat.getInstance(0,new Point(300,200),0);
			System.out.println("set meat to nulll");
		}
		return true;
		
	}
	
	/**
	 * Chooses the background for the zoo panel.
	 * @param num - 1,2 or 3- ID for each background as explained in the class attributes.
	 * @return true if we succeeded to update the background choice for the panel. Otherwise returns false.
	 */
	public boolean set_image_identifier(int num) {
		this.image_identifier = num;
		return true;
	}
	
	
	/**
	 * Sets the thread attribute of the class.
	 */
	public void setController() {
		this.controller = new Thread(new ZooPanel());
	}
	
	
	/**
	 * Identifies if we are feeding animals in the zoo. 
	 * For example, if we feed with lettuce, then if there are giraffes or elephants or turtles, they need to move towards the food.
	 * @return default point if there is not food on the zoo panel, otherwise the location of the food on the zoo panel.
	 */
	public static synchronized Point reactToFood() {
		for(int i=0;i<AddAnimalDialog.get_counter();i++)
		{
			if(Food.get_food_choice() == 3) {
				if(animal_array[i].eat(meat)== true) {
					if(animal_array[i].getLocation().get_x() - meat.getLocation().get_x() > 0 && animal_array[i].getX_dir() == 1) { //the animal moves right and passed the meat
						animal_array[i].set_X_dir(-1);
						return meat.getLocation();
					}
					else {
						if(animal_array[i].getLocation().get_x() - meat.getLocation().get_x() < 0 && animal_array[i].getX_dir() == -1) {
							animal_array[i].set_X_dir(1);
							return meat.getLocation();
						}
					}
				}
			}
			Food.set_food_choice(0);
			
			
			if(plant != null) {
				if(animal_array[i].eat(plant)== true) {
					if(animal_array[i].getLocation().get_x() - plant.getLocation().get_x() > 0 && ZooPanel.get_animal_array()[i].getX_dir() == 1) { //the animal moves right and passed the meat
						animal_array[i].set_X_dir(-1);
						return plant.getLocation();
					}
					else {
						if(animal_array[i].getLocation().get_x() - plant.getLocation().get_x() < 0 && ZooPanel.get_animal_array()[i].getX_dir() == -1) {
							ZooPanel.get_animal_array()[i].set_X_dir(1);
							return plant.getLocation();
						}
					}
				}
			}
			Food.set_food_choice(0);
		}
		return new Point(0,0);
	}

	
	
	@Override
	/**
	 * Paints all the animals and food on the zoo panel.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image_identifier == 1) {
			 try {
			 BufferedImage img = ImageIO.read(new File(IDrawable.PICTURE_PATH+"/savanna.jpg"));
			 g.drawImage(img,0,0,this);
			 }
			 catch(IOException eo) {System.out.println("Can not load image");}
			 
		 }
		for(int i=0;i<AddAnimalDialog.get_counter();i++) {	
			if(animal_array[i] != null) {
				animal_array[i].drawObject(g);
			}
			else {
				if(image_identifier == 1) {
					try {
					g.drawImage(ImageIO.read(new File(IDrawable.PICTURE_PATH+"/savanna.jpg")),0, 0, this);}
					catch(IOException eo) {System.out.println("Can not load image");}
				}
				else if(image_identifier == 2) {
					this.setBackground(Color.GREEN);
				}
				else
					this.setBackground(null);
				}
			
		}
		 
		 if(plant != null) {
			 plant.drawObject(g);
			 System.out.println("plant eat");
		 }
		 if(meat != null) {
			 System.out.println("meat eat");
			 meat.drawObject(g);
		 }
		
		
	}
	
	
		  
	/**
	 * 
	 * @param animal_prey - Prey animal
	 * @param animal_predator - predator animal
	 * @return true if the predator can eat the prey(according to the conditions requested)
	 */
	public boolean isCheck(Animal animal_prey,Animal animal_predator) {
		if(animal_predator.get_weight()-2*(animal_prey.get_weight())<0 && animal_predator.get_diet().canEat(animal_prey.getFoodtype())== false && isDistance(animal_prey,animal_predator) == false) {
			isEdible = false;
			return false;
		}
		return true;	
	}
	
	/**
	 * 
	 * @param animal_prey - Prey animal
	 * @param animal_predator -Predator animal
	 * @return true if the distance between the two animals is bigger than the size of the prey.
	 */
	public boolean isDistance(Animal animal_prey,Animal animal_predator) {
		if(animal_prey.calcDistance(animal_predator.getLocation()) > animal_prey.getSize())
			return false;
		return true;
	}
	 
		 
	/**
	 * 
	 * @return true if there has to be a change in the area of the animals which is the ZooPanel.(change of location or animal to remove from the panel etc.)
	 */
	@SuppressWarnings("deprecation")
	public boolean isChange() {
		for(int i=0;i<AddAnimalDialog.get_counter() && AddAnimalDialog.get_counter()>=1;i++) {
			if(animal_array[i].getChanges() == false) {
				continue;
			}
			else { 
				if(AddAnimalDialog.get_counter() >= 1) {
					for(int k=0;k<AddAnimalDialog.get_counter() && i!=k;k++) {
						if(isCheck(animal_array[i],animal_array[k])==true) {
							System.out.println("checkkkkkkkkkkkkk");
							remove_object(animal_array[k]);
							ZooPanel.get_animal_array()[k].get_thread().stop();
							repaint();
							
						}
					}
				
				}
			}
			
			
			}
		return true;
	}
	
	
	
	/**
	 * The controller. Observes if there are  any changes in the zooPanel and updates by calling the repaint method.
	 */
	public void run() {
		while(true) {
		if(AddAnimalDialog.get_counter() >=1)
			isChange();
		}
	}
				 
		
	

	
		
		
    /**
     * 
     * @return The data structure in which all the animals of the zoo are located.
     */
	public static Animal[] get_animal_array() {
		return animal_array;
	}
	
	

	
	
}