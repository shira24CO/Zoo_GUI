package homework4;
import homework4.Omnivore;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Ilocatable;
import homework4.Mobile;
import homework4.Point;
import homework4.Plant;
import homework4.MessageUtility;
import homework4.Herbivore;
/**
 * The elephant is a herbivore. Its initial weight is 500 kg and its location is x=50, y=90
 * The length of an elephant's trunk can be between 0.5 - 3 cm. 1 cm default
 *  @author Shira Cohen 211777834 & Ilan Shklover 206753550
 *
 */
public class Elephant extends ChewAnimals{
	/**
	 * trunk length of the elephant
	 */
	private double trunkLength;
	/**
	 * default location
	 */
	private static final Point default_location = new Point(50, 90); 
	/**
	 * Constructor with name, trunkLength. the location and weight they are by default values
	 * @param name- name of elephant
	 * @param trunkLength- the length of trunk as a double
	 */
	public Elephant(String name, double trunkLength) {
		super(name, default_location);
		if(check_trunk_length(trunkLength) == true)
			this.trunkLength = trunkLength;
		else 
			this.trunkLength = 1;
		super.set_weight(500);
		super.set_diet(new Herbivore());
	}
	/**
	 * Constructor with name, point. the trunkLength and weight they are by default values
	 * @param name- name of elephant
	 * @param point- the location of elephant
	 */
	public Elephant(String name, Point point) {
		super(name, point);
		this.trunkLength = 1;
		super.set_weight(500);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name, point and trunkLength. 
	 * @param name- name of elephant
	 * @param point- the location of elephant
	 * @param trunkLength- the length of trunk as a double
	 */
	public Elephant(String name, Point point, double trunkLength) {
		super(name, point);
		if(check_trunk_length(trunkLength) == true)
			this.trunkLength = trunkLength;
		else 
			this.trunkLength = 1;
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name. the trunkLength, location and weight they are by default values
	 * @param name- name of elephant
	 * @param point- the location of elephant
	 */
	public Elephant(String name) {
		super(name, default_location);
		this.trunkLength = 1;
		super.set_weight(500);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	
	
	/**
	 * Constructor with the size,the horizontal and vertical speed,the color and the zoo panel.
	 * @param size - the size of the elephant.
	 * @param speedHor - the horizontal speed of the elephant. 
	 * @param speedVer - the vertical speed of the elephant.
	 * @param color - the color of the elephant.
	 * @param zp - the zoo panel.
	 */
	public Elephant(int size,int speedHor,int speedVer,String color,ZooPanel zp) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 10);
		super.setZooPanel(zp);
		super.loadImages("elf");
		super.setChanges(true);
		super.set_diet(new Herbivore());
		this.get_zoo_panel().repaint();
	}
	
	
	/**
	 * Constructor with the size,the horizontal and vertical speed and the color of the elephant.
	 * @param size - the size of the elephant.
	 * @param speedHor - the horizontal speed of the elephant. 
	 * @param speedVer - the vertical speed of the elephant.
	 * @param color- - the color of the elephant.
	 */
	public Elephant(int size,int speedHor,int speedVer,String color) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 10);
	}
	
	
	/**
	 * Return true if the values of trunk length are correct, else return false
	 * @param trunk length of the elephant
	 * @return true if the values of neck length are correct, else return false
	 */
	public boolean check_trunk_length(double trunk_length) {
		MessageUtility.logBooleanFunction(this.get_name(), "check_length",trunk_length, trunk_length >= 0.5 && trunk_length<= 3);
		return trunk_length >= 0.5 && trunk_length<= 3;
		
	}
	
	@Override
	public void changing_color(String col) {
		super.changing_color(col);
		super.loadImages("elf");
		super.get_zoo_panel().repaint();
	}
	/**
	 * Return the type of elephant
	 * @return type of elephant
	 */
	//public EFoodType getFoodtype() {
		//MessageUtility.logGetter(this.get_name(), "getFoodtype", EFoodType.MEAT);
		//return EFoodType.MEAT;
	//}
	/**
	 * Return the name of class
	 * @return the name of class
	 */
	public String get_name_of_class() {
		MessageUtility.logGetter(this.get_name(), "get_name_of_class", "Elephant");
		return "Elephant";
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
	 * print the sound of elephant after he ate
	 */
	public void chew() {
		MessageUtility.logSound(super.get_name(),"Trumpets with joy while flapping its ears, then chews");
	}
	
	

}

