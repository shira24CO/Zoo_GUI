package homework4;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Ilocatable;
import homework4.Mobile;
import homework4.Point;
import homework4.Plant;
import homework4.MessageUtility;

import java.awt.Color;

import homework4.Omnivore;
/**
 * The bear is all food(Omnivore). The initial weight is 408.2 kilograms, 
 * its initial location is x=100, y=5
 *  the color of the fur of the bears can be only black or white or gray. Default gray
 *  @author Shira Cohen 211777834 & Ilan Shklover 206753550
 *
 */
public class Bear extends RoarAnimals{
	/**
	 * default location
	 */
	private static final Point default_location = new Point(100, 5);
	/**
	 * fur color of the bear
	 */
	private String furColor; 
	/**
	 * Constructor with name, point and fur color. The initial weight is 408.2 kilograms,  
	 * the color of the fur of the bears can be only black or white or gray. Default gray
	 * @param name- name of the bear
	 * @param point- the location of the bear
	 * @param furColor- the fur color of the bear
	 */
	public Bear(String name, Point point, String furColor) {
		super(name,point);
		super.set_weight(308.2);
		
		if(furColor.equals(FurColor.BLACK) || furColor.equals(FurColor.WHITE) || furColor.equals(FurColor.GRAY))
			this.furColor = furColor;
		else {
			this.furColor = FurColor.GRAY.toString();
		}
		super.set_diet(new Omnivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());

	}
	/**
	 * Constructor with name, point and fur color.
	 * @param name- name of the bear
	 * @param point- the location of the bear
	 */
	public Bear(String name,Point point) {
		super(name,point);
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
		super.set_diet(new Omnivore());
	}
    /**
     * Constructor with name.
     * @param name - name of the bear
     */
	public Bear(String name) {
		super(name, default_location);
		this.furColor = FurColor.GRAY.toString();
		super.set_weight(308.2);
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
		super.set_diet(new Omnivore());

	}
	
	/**
	 * Constructor with the size of the bear,its horizontal and vertical speed,its color and the panel it is located.
	 * @param size - size of the bear in pixels.
	 * @param speedHor - the horizontal speed of the bear.
	 * @param speedVer - the vertical speed of the bear.
	 * @param color - the color of the bear(red,blue or natural).
	 * @param zp - the zoo panel.
	 */
	public Bear(int size,int speedHor,int speedVer,String color,ZooPanel zp) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 1.5);
		super.setZooPanel(zp);
		super.loadImages("bea");
		super.setChanges(true);
		super.set_diet(new Omnivore());
		this.get_zoo_panel().repaint();
		
	}
	
	/**
	 * Constructor with the size of the bear,its horizontal and vertical speed and its color.
	 * @param size - size of the bear in pixels.
	 * @param speedHor - the horizontal speed of the bear.
	 * @param speedVer - the vertical speed of the bear.
	 * @param color - the color of the bear(red,blue or natural).
	 */
	public Bear(int size,int speedHor,int speedVer,String color) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 1.5);
	}
	
	
	@Override
	public void changing_color(String col) {
		super.changing_color(col);
		super.loadImages("bea");
		super.get_zoo_panel().repaint();
	}
	
	
	/**
	 * Returns the type of bear(type of food the bear is).
	 * @return the type of food the bear is.
	 */
	//public EFoodType getFoodtype() {
		//MessageUtility.logGetter(this.get_name(), "getFoodtype", EFoodType.MEAT);
		//return EFoodType.MEAT;
	//}
	/**
	 * Returns the name of class
	 * @return the name of class
	 */
	public String get_name_of_class() {
		MessageUtility.logGetter(this.get_name(), "get_name_of_class", "Bear");
		return "Bear";
	}
	
	/**
	 * prints the sound of bear after he ate
	 */
	public void roar() {
		MessageUtility.logSound(super.get_name(),"Stands on its hind legs, roars and scratches its belly");
	}
    /**
     * Return the name of bear and the class- Bear
     * @return the name of bear and the class
     */
	public String toString() {
		return "[" + this.get_name_of_class() +"]:\n"+"Size:"+super.getSize()+"\n"
				+"Speed horizontal:"+super.get_speedHor()+"\n"
				+"Speed vertical:"+super.get_speedVer()+"\n"
				+"Color:"+super.get_color()+"\n";
	}
	
	
	/**
	 * checks if a valid color was chosen.
	 * @param col - color of the animal
	 * @return True if the color is valid,else returns false.
	 */
	public boolean check_color(Color col) {
		return col == new Color(153,102,0) || col == Color.BLUE || col == Color.RED;
	}
	
		
	
}
