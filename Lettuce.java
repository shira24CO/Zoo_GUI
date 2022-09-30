package homework4;

import homework4.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	private static Lettuce lettuce = null;
	
	private Lettuce() {
		super.loadImages("lettuce");
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}
	
	public static Lettuce getInstance(){
		if(lettuce == null)
			lettuce = new Lettuce();
		return lettuce;
		
	}
	/**
	 * Constructor with double height,Point point,double weight
	 * @param height- the height of the lettuce
	 * @param point- the point of the lettuce
	 * @param weight- the weight of the lettuce
	 */
	public Lettuce(double height,Point point,double weight) {
		this.setLocation(point);
		this.setHeight(height);
		this.setWeight(weight);
		super.loadImages("lettuce");
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}
	/**
	 * return the name of class
	 */
	public String get_name_of_class()
	{
		return "Lettuce";
	}
	/**
	 * return the color of lettuce
	 */
	public String getColor() {
		return "Green";
	}
}

