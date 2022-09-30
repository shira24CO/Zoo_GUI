package homework4;
import homework4.MessageUtility;
import homework4.Ilocatable;
import homework4.Point;
import homework4.RoarAnimals;
import homework4.Carnivore;
import homework4.Herbivore;
import homework4.Mobile;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Plant;
import homework4.Giraffe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * A lion is a type of predator - an omnivore. Its initial weight is 308.2 
 * and its initial position is x=20, y=0
A lion is not edible by other animals. Each time the lion eats there is a 50 percent probability that a scar will be added to it.
 *  @author Shira Cohen 211777834 & Ilan Shklover 206753550
 *
 */
public class Lion extends RoarAnimals{
	/**
	 * default location
	 */
	private static final Point default_location = new Point(20,0);
	/**
	 * amount of scars
	 */
	private int scarCount;
	/**
	 * Constructor with name, point. The initial weight is 308.2 kilograms,  
	 * At first the number of scars is 0. The weight gets a default value
	 * @param name- name of the lion
	 * @param point- the location of the lion
	 */
	
	public Lion(String name, Point point) {
		super(name, point);
		super.set_weight(408.2);
		int scarCount = 0;
		super.set_diet(new Carnivore());
		//this.set_img("Natural", 1);
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name.
	 * @param name- name of the lion
	 */
	public Lion(String name) {
		super(name,default_location);
		super.set_diet(new Carnivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	
	
	/**
	 * Constructor with the size of the lion,its horizontal and vertical speed,its color and the panel it is located.
	 * @param size - the size of the lion.
	 * @param speedHor - the horizontal speed of the lion
	 * @param speedVer - the vertical speed of the lion
	 * @param color - the color of the lion(red,blue or natural)
	 * @param zoo_panel - the zoo panel where all the animals in the zoo are located in.
	 */
	public Lion(int size,int speedHor,int speedVer,String color,ZooPanel zoo_panel) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 0.8);
	    this.setZooPanel(zoo_panel);
		super.loadImages("lio");
		super.set_diet(new Carnivore());
		super.setChanges(true);
		//this.thread.start();
		//this.get_zoo_panel().repaint();
		//this.set_img("Natural", 1);
		
	}
	
	/**
	 * Constructor with the size of the lion,its horizontal and vertical speed and its color.
	 * @param size - the size of the lion.
	 * @param speedHor - the horizontal speed of the lion.
	 * @param speedVer - the vertical speed of the lion.
	 * @param color - the color of the lion.
	 */
	public Lion(int size,int speedHor,int speedVer,String color) {
		super(size,default_location);
		super.set_size(size);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 0.8);
		super.loadImages("lio");
		super.setChanges(true);
		this.setZooPanel(super.get_zoo_panel());
	}
	  
	@Override
	public void changing_color(String col) {
		super.changing_color(col);
		super.loadImages("lio");
		super.get_zoo_panel().repaint();
	}

	/**
	 * Return the type of lion-which food type it is.
	 * @return the type of lion - which food type it is.
	 */
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.get_name(), "getFoodtype", EFoodType.NOTFOOD);
		return EFoodType.NOTFOOD;
	}
	
	
	
	/**
	 * 
	 * Returns true if the food that was received is the food the lion eats and updates the number of scars if necessary.else return false
	 * @param food - MEAT or PLANT
	 * @return - true if the food he received is the food the lion eats. else return false
	 */
	public boolean eat(IEdible food) {
		if(super.eat(food) == true) {
			Random rand = new Random();
			if(rand.nextInt(0, 2) == 1) 
				this.scarCount += 1;
			MessageUtility.logBooleanFunction(this.get_name(), "eat", food, true);
			return true;
		}
		MessageUtility.logBooleanFunction(this.get_name(), "eat", food, false);
		return false;		
	}
	/**
	 * @return the amount of scars as an integer
	 */
	public int get_scar_count() {
		MessageUtility.logGetter(this.get_name(), "get_scar_count", this.scarCount);
		return this.scarCount;
	}
	/**
	 * print the sound the lion produces after it ate
	 */
	public void roar() {
		MessageUtility.logSound(super.get_name(),"Roars, then stretches and shakes its mane");
	}
	/**
	 * Returns the name of class
	 * @return the name of class
	 */
	public String get_name_of_class() {
		MessageUtility.logGetter(this.get_name(), "get_name_of_class", "Lion");
		return "Lion";
	}
	/**
     * Return the name of lion and the class- Lion
     * @return name of lion and the class- Lion
     */
	public String toString() {
		return "[" + this.get_name_of_class() +"]:\n"+"Size:"+super.getSize()+"\n"
				+"Speed horizontal:"+super.get_speedHor()+"\n"
				+"Speed vertical:"+super.get_speedVer()+"\n"
				+"Color:"+super.get_color()+"\n";
	}

	
}

