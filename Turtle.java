package homework4;
import homework4.Carnivore;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Ilocatable;
import homework4.Mobile;
import homework4.Point;
import homework4.Plant;
import homework4.MessageUtility;
import homework4.Herbivore;
/**
 * The turtle is a type of herbivore. Its initial weight is 1 kg 
 * and its initial location is x=80, y=0
 * Its age can range from 0 to 500 years. Default 1
 *  @author Shira Cohen 211777834 & Ilan Shklover 206753550
 *
 */

public class Turtle extends ChewAnimals{
	/**
	 * default location
	 */
	private static final Point default_location = new Point(80,0);
	/**
	 * age of the turtle
	 */
	private int age;
	/**
	 * Constructor with name, point and age. the weight is by default values
	 * @param name- name of turtle
	 * @param point- location of the turtle
	 * @param age- age of turtle as integer
	 */
	public Turtle(String name,Point point,int age) {
		super(name,point);
		if(check_age(age)== true)
			this.age = age;
		else
			this.age =1;
		this.set_weight(1);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());	
	}
	/**
	 * Constructor with name and age. the weight and location they are by default values
	 * @param name  - the name of the turtle.
	 * @param age- age of turtle as integer
	 */
	public Turtle(String name,int age) {
		super(name,default_location);
		if(check_age(age)== true)
			this.age = age;
		else
			this.age =1;
		this.set_weight(1);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name. the weight, location and age they are by default values
	 * @param name- name of turtle
	 */
	public Turtle(String name) {
		super(name,default_location);
		this.age =1;
		this.set_weight(1);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name and point. the weight and age they are by default values
	 * @param name- name of turtle
	 * @param point- location of the turtle
	 */
	public Turtle(String name, Point point) {
		super(name,point);
		this.age =1;
		this.set_weight(1);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	
	
	/**
	 * Constructor with the size,horizontal speed,vertical speed, color and the zoo panel of the turtle.
	 * @param size - the size of the turtle.
	 * @param speedHor - the horizontal speed of the turtle.
	 * @param speedVer - the vertical speed of the turtle.
	 * @param color  - the color of the animal.
	 * @param zp  - the zoo panel where all the animals in the zoo are located.
	 */
	public Turtle(int size,int speedHor,int speedVer,String color,ZooPanel zp) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 0.5);
		super.setZooPanel(zp);
		super.loadImages("trt");
		super.setChanges(true);
		super.set_diet(new Herbivore());
		this.get_zoo_panel().repaint();
		
	}
	
	
	/**
	 * Constructor with the size,horizontal speed, vertical speed and  the color of the turtle.
	 * @param size - the size of the turtle.
	 * @param speedHor - the horizontal speed of the turtle.
	 * @param speedVer - the vertical speed of the turtle.
	 * @param color - the color of the turtle.
	 */
	public Turtle(int size,int speedHor,int speedVer,String color) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 0.5);
	}
	
	@Override
	public void changing_color(String col) {
		super.changing_color(col);
		super.loadImages("trt");
		super.get_zoo_panel().repaint();
	}
	/**
	 * Return true if the age of the turtle is normal,else return false
	 * @param age
	 * @return- true if the age of the turtle is normal,else return false
	 */
	public boolean check_age(int age) {
		MessageUtility.logBooleanFunction(this.get_name(), "check_age", age, age>=0 && age<=500);
		return age>=0 && age<=500;
	}
	/**
	 * Return the type of turtle
	 * @return - the type of turtle
	 */
	//public EFoodType getFoodtype() {
		//MessageUtility.logGetter(this.get_name(), "getFoodtype", EFoodType.MEAT);
		//return EFoodType.MEAT;
	//}
	
	
	/**
	 * Returns the name of the class as a string.
	 * @return name of the class as a string.
	 */
	public String get_name_of_class() {
		MessageUtility.logGetter(this.get_name(), "get_name_of_class", "Turtle");
		return "Turtle";
	}
	/**
	 * print the sound of turtle after he ate
	 */
	public void chew() {
		MessageUtility.logSound(super.get_name(),"Retracts its head in then eats quietly");
	}
	
	
	/**
     * @return the name of turtle and the class- Turtle
     */
	public String toString() {
		return "[" + this.get_name_of_class() +"]:\n"+"Size:"+super.getSize()+"\n"
				+"Speed horizontal:"+super.get_speedHor()+"\n"
				+"Speed vertical:"+super.get_speedVer()+"\n"
				+"Color:"+super.get_color()+"\n";
	}
	
	
}
