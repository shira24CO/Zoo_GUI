package homework4;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * Class which represents the meat eaten by the animals in the zoo
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 *
 */
public class Meat implements IEdible,IDrawable{
	
	/**
	 * height of the meat
	 */
	private double height;
	/**
	 * location of the meat in the zoo.
	 */
	private Point location;
	
	
	/**
	 * the weight of the meat
	 */
	private double weight;
	
	/**
	 * the image of the meat.
	 */
	private static BufferedImage img_meat;
	
	/**
	 * the area of the animals in the zoo.
	 */
	private ZooPanel zooPanel;
	
	
	private static Meat meat = null;
	
	/**
	 * Constructor of meat
	 * @param height the height of the meat
	 * @param point the location of the meat
	 * @param weight the weight of the meat
	 */
	private Meat(double height,Point point,double weight) {
		this.setLocation(point);
		this.setHeight(height);
		this.setWeight(weight);
		this.loadImages("meat");
		MessageUtility.logConstractor("Meat", "Meat");
	}
	
	public static Meat getInstance(double height,Point point,double weight) {
		if(meat == null)
			meat = new Meat(height,point,weight);
		return meat;
	}
	
	/**
	 * Initializes the field of image of the meat
	 */
	public void loadImages(String nm) {
		try {
		img_meat = ImageIO.read(new File(IDrawable.PICTURE_PATH+"/"+nm+".gif"));
		}
		catch(IOException e) {System.out.println("Cannot load image");}
		
	}
	
	
	
	
	/**
	 * @param g - Graphics object
	 * draws the meat on the zoo panel.
	 */
	public void drawObject (Graphics g) {
		g.drawImage(img_meat, 300, 200, 25, 50, this.zooPanel);
	}
	
	
	/**
	 * @return the type of food the animal eats.(meat or vegetables)
	 */
	public EFoodType getFoodtype() {
		return EFoodType.MEAT;
		
	}
	
	
	/**
	 * @return the color of the meat.
	 */
	public String getColor() {
		return "Red";
	}

	
	/**
	 * 
	 * @param height - height of the meat
	 * @return true of succeeded to set the height of the meat.Else,false.
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}
	
	
	/**
	 * 
	 * @param newLocation - location of the meat
	 * @return true if succeeded to set the location of the meat.Else,false.
	 */
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.cheackBounderies(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}
	
	
	/**
	 * 
	 * @return the current location of the meat
	 */
	public Point getLocation() {
		return new Point(this.location);
	}
	
	
	/**
	 * 
	 * @param weight the weight of the meat
	 * @return true if succeeded to set the weight of the meat.Else,false.
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

		return isSuccess;
	}
	
	
	
	/**
	 * 
	 * @param zp - object of ZooPanel
	 * @return true if succeeded to initialize the field of ZooPanel. Else,false.
	 */
	public boolean setZooPanel(ZooPanel zp) {
		this.zooPanel = zp;
		return true;
	}
	
	public String toString() {
		return getLocation()+"meat111";
	}
}
