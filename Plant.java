package homework4;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import homework4.EFoodType;
import homework4.IEdible;
import homework4.Ilocatable;
import homework4.Point;
import homework4.Mobile;
import homework4.MessageUtility;

/**
 * @author baroh
 *
 */
 
public abstract class Plant implements IEdible, Ilocatable,IDrawable {
	/**
	 * the height of the plant
	 */
	private double height;
	/**
	 * the location of the plant
	 */
	private Point location;
	/**
	 * the weight of the plant
	 */
	private double weight;

	/**
	 * the image of the plant
	 */
	
	private BufferedImage img;
	/**
	 * the zoo panel
	 */
	private ZooPanel zoo_panel;
	/**
	 * the name of the class
	 * @return the name of the class
	 */
	public abstract String get_name_of_class();
	
	/**
	 *default constructor of the plant
	 */
	public Plant() {
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		MessageUtility.logConstractor("Plant", "Plant");
	}

	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}

	/**
	 * @return the height of the plant
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}
    /**
     * return the location of the plant
     */
	@Override
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}

	/**
	 * @return the weight of the plant
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * update the height of the plant and return true if is success
	 * @param height- the height of the plant
	 * @return the height of the plant
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.cheackBounderies(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	/**
	 * @param weight
	 * @return the weight of the plant
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}
	
	
	/**
	 * load the image of plant
	 * @nm - string of the short name of the type of plant
	 */
	public void loadImages(String nm) {
		try {
		img = ImageIO.read(new File(IDrawable.PICTURE_PATH+"/"+nm+".png"));
		}
		catch(IOException e) {System.out.println("Cannot load image");}
	}
	/**
	 * Draws the passed Object2D object into the Graphics object.
	 */
	public void drawObject (Graphics g) {
			g.drawImage(img, 500, 300, 25, 50, this.zoo_panel);
		
	}
        
}