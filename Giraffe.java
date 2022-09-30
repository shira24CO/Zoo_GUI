package homework4;
import homework4.Herbivore;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Ilocatable;
import homework4.Mobile;
import homework4.Point;
import homework4.Plant;
import homework4.MessageUtility;
/**
 * The giraffe is a herbivore. Its initial weight is 450 kg and its location is x=50, y=0
 * The length of the giraffe's neck is 1 - 2.5. 1.5 cm default
 *  @author Shira Cohen 211777834 & Ilan Shklover 206753550 
 *
 */
public class Giraffe extends ChewAnimals {
	/**
	 * neck length of the giraffe
	 */
	private double neckLength;
	/**
	 * default location
	 */
	private static final Point default_location = new Point(0,50);
	/**
	 * Constructor with name, neckLength. the location, neckLngth and weight they are by default values
	 * @param name- name of giraffe
	 * @param neckLength- the length of neck as a double
	 */
	public Giraffe(String name,double neckLength) {
		super(name,default_location);
		if(this.check_length(neckLength))
			this.neckLength = neckLength;
		else
			this.neckLength = 1.5;
		this.set_weight(450);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name, point and neckLength. the neck and weight they are by default values
	 * @param name- name of giraffe
	 * @param point- the location of the giraffe
	 * @param neckLength- the length of neck as a double
	 */
	public Giraffe(String name,Point point,double neckLength) {
		super(name,point);
		if(this.check_length(neckLength))
			this.neckLength = neckLength;
		else
			this.neckLength = 1.5;
		this.set_weight(450);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name. the neck and weight they are by default values
	 * @param name- name of giraffe
	 */
	public Giraffe(String name) {
		super(name,default_location);
		this.neckLength = 1.5;
		this.set_weight(450);
		super.set_diet(new Herbivore());
		MessageUtility.logConstractor(this.get_name_of_class(), this.get_name());
	}
	/**
	 * Constructor with name and point. the neck and weight they are by default values
	 * @param name- name of giraffe
	 * @param point- the location of the giraffe
	 */
	public Giraffe(String name,Point point) {
		super(name,point);
		this.neckLength = 1.5;
		this.set_weight(450);
		super.set_diet(new Herbivore());
	}
	/**
	 * Constructor with int size,int speedHor,int speedVer,String color,ZooPanel zp
	 * @param size - size of the animal
	 * @param speedHor- horvertical speed of the animal
	 * @param speedVer- vertical speed of the animal
	 * @param color- color of the animal
	 * @param zp- zoo panel
	 */
	
	public Giraffe(int size,int speedHor,int speedVer,String color,ZooPanel zp) {
		super(size,default_location);
		//super.set_size(size);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 2.2);
		super.setZooPanel(zp);
		super.loadImages("grf");
		super.setChanges(true);
		super.set_diet(new Herbivore());
		this.get_zoo_panel().repaint();
		//this.get_zoo_panel().repaint();
		//this.setZooPanel(super.get_zoo_panel());
	}
	/**
	 * Constructor with int size,int speedHor,int speedVer,String color
	 * @param size - size of the animal
	 * @param speedHor- horvertical speed of the animal
	 * @param speedVer- vertical speed of the animal
	 * @param color- color of the animal
	 */
	public Giraffe(int size,int speedHor,int speedVer,String color) {
		super(size,default_location);
		super.set_speedHor(speedHor);
		super.set_speedVer(speedVer);
		super.set_color(color);
		super.set_weight(size* 2.2);
		super.loadImages("grf");
		super.setChanges(true);
		this.setZooPanel(super.get_zoo_panel());
	}
	
	/**
	 * Return true if the values of neck length are correct, else return false
	 * @param neck length of the giraffe
	 * @return true if the values of neck length are correct, else return false
	 */
	public boolean check_length(double length) {
		MessageUtility.logBooleanFunction(this.get_name(), "check_length", length, length>=1 && length<=2.5);
	    return length>=1 && length<=2.5;
	}
	
	/**
	 * Return the type of giraffe
	 * @return the type of giraffe
	 */
	//public EFoodType getFoodtype() {
		//MessageUtility.logGetter(this.get_name(), "getFoodtype", EFoodType.MEAT);
		//return EFoodType.MEAT;
	//}
	
	/**
	 * @param col - Desired color of the animal
	 * This method changes the color of the giraffe while it is moving in the zoo.
	 */
	@Override
	public void changing_color(String col) {
		super.changing_color(col);
		super.loadImages("grf");
		super.get_zoo_panel().repaint();
	}
	
	/**
	 * Return the name of class
	 * @return the name of class
	 */
	public String get_name_of_class() {
		MessageUtility.logGetter(this.get_name(), "get_name_of_class", "Giraffe");
		return "Giraffe";
	}
	/**
	 * print the sound of giraffe after he ate
	 */
	public void chew() {
		MessageUtility.logSound(super.get_name(),"Bleats and Stomps its legs, then chews");
	}
	/**
     * Return the name of giraffe and the class- Giraffe
     * @return the name of giraffe and the class
     */
	public String toString() {
		return "[" + this.get_name_of_class() +"]:\n"+"Size:"+super.getSize()+"\n"
				+"Speed horizontal:"+super.get_speedHor()+"\n"
				+"Speed vertical:"+super.get_speedVer()+"\n"
				+"Color:"+super.get_color()+"\n";
	}
	

}