package homework4;
import homework4.IEdible;
import homework4.EFoodType;
import homework4.Mobile;
import homework4.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observer;
import java.util.Observable;
import java.util.concurrent.locks.Lock;

import javax.imageio.ImageIO;

import homework4.IDiet;
/**
 * 
 * An abstract class that defines the characteristics common to all animals
 * @author Shira Cohen 211777834 & Ilan Shklover 206753550
 * 
 *
 */

@SuppressWarnings("deprecation")
public abstract class Animal extends Mobile implements IEdible,IDrawable, IAnimalBehavior,Runnable,ColorChange{
	
	/**
	 * name of the animal
	 */
	private String name; 
	/**
	 * weight of the animal
	 */
	private double weight; 
	/**
	 * Carnivore, Omnivore, Herbivore
	 */
	private IDiet diet; 
	/**
	 * the distance in pixel of the animal between the food
	 */
	private final int EAT_DISTANCE = 5;
	/**
	 * the size of the animal
	 */
	private int size;
	/**
	 * the color of the animal
	 */
	private String col;
	/**
	 * the horvertical speed of the animal
	 */
	private int horSpeed;
	/**
	 * the vertical speed of the animal
	 */
	private int verSpeed;
	/**
	 * 
	 */
	private boolean coordChanged;
	/**
	 * the direction in X-axis
	 */
	private int x_dir;
	/**
	 * /**
	 * the direction in X-axis
	 */
	
	private int y_dir;
	/**
	 * the counter of the food that animal eat
	 */
	private int eatCount;
	/**
	 * the zoo panel
	 */
	private ZooPanel pan;
	/**
	 * the image of the animal 
	 */
	private BufferedImage img1, img2;
	/**
	 * the thread of the animal
	 */
	protected Thread thread; 
	/**
	 * the state of the thread of animal
	 */
	protected boolean threadSuspended;
	
	
	

	/*
	 * Constructor with name and point
	 * @param name 
	 * - name of the animal
	 * @param point
	 * - Point type object: int x, int y
	 */
	public Animal(String name, Point point) {
		super(point);
		this.name = name;
	}
	
	/*
	 * Constructor with size and point
	 * @param size 
	 * - size of the animal
	 * @param point
	 * - Point type object: int x, int y
	 */
	public Animal(int size,Point point) {
		super(point);
		this.size = size;
		this.x_dir = 1;//moves right
		this.y_dir = 1;// moves down
		//this.thread = new Thread();
		
	}
	
	/**
	 * Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
	 */
	public void start() {
		thread.start();
	}
	
	
	
	
	
	/**
	 * return the weight of the animal
	 * @return the weight of the animal as a double
	 */
    public double get_weight() {
    	return this.weight;
    }
    /**
     * set the idet and return true or false if the update was successful
     * @param idet -The type of animal- Carnivore, Omnivore, Herbivore
     * @return true if the update was successful, else- return false
     */
    public boolean set_diet(IDiet idet) {
    	this.diet = idet;
    	return true;
    }
    /**return the diet- the type of animal- Carnivore, Omnivore, Herbivore
     * 
     * @return the diet
     */
    public IDiet get_diet() {
    	return this.diet;
    }
    /**
     * set the weight of the animal and return true or false if the update was successful
     * @param weight 
     * - weight of the animal
     * @return true if the update was successful, else- return false
     */
	public boolean set_weight(double weight) {
		if(weight > 0)
		{
			this.weight = weight;
			return true;
		}
		return false;
		
	}
	/**
	 * Set the total distance of the animal
	 * @param distance - the distance the animal move
	 */
	//public void addTotalDistance(double distance) {
		//super.set_totalDistance(distance);
	//}
	/**
	 * abstract method- A method that makes the sounds of the animals after they have eaten
	 */
	public abstract  void makeSound();
	/**
	 * Returns the calculation of the distance as a double, by Pythagoras' theorem
	 * @param point - the point to which the animal wants to move
	 * @return - return the calculation of the distance
	 */
	
	//public double calcDistance(Point point) {
		//System.out.println(Point.cheackBounderies(point) == true);
		//if(Point.cheackBounderies(point) == true) {
			//System.out.println(Math.sqrt(Math.pow(point.get_x()-super.getLocation().get_x(), 2)+Math.pow(point.get_y()-super.getLocation().get_y(), 2)));
		
			//return (Math.sqrt(Math.pow(point.get_x()-super.getLocation().get_x(), 2)+Math.pow(point.get_y()-super.getLocation().get_y(), 2)));
		//}
		//else
			//return 0;
	//}
	/**
	 * Returns the distance between the current location and the destination point. Updates the weight of the animal
	 * @param destination- the point to which the animal wants to move
	 * @return - the distance between the current location and the destination point
	 */
	public double move(Point destination) {
		//if(Math.abs(this.calcDistance(destination)) > 0) {
			//this.addTotalDistance(Math.abs(calcDistance(destination)));
			//System.out.println(this.calcDistance(destination));
			//super.setLocation(destination);
		super.move(destination);
		this.set_weight(this.weight-(this.calcDistance(destination)*this.weight*0.00025));
		return this.calcDistance(destination);
		//}
		//return 0; // The animal did not move.
	}
	/**
	 *@return the type of food
	 */
	public EFoodType getFoodtype() {return EFoodType.MEAT;}
	/**
	 * 
	 * Abstract method- return the name of class
	 */
	public abstract String get_name_of_class();
	/**
	 * Returns true if the animal eats the food and the animal makes her voice heard. Else return false
	 * @param food- type of food: MEAT or PLANT
	 * @return true if the animal eats the food. Else return false
	 */
	public boolean eat(IEdible food) {
		double change = diet.eat(this, food);
		if(change !=0) {
			this.set_weight(change);
			makeSound();
			return true;
	
		}
		return false;
	}
	
	public void eatInc() {
		this.eatCount +=1;
	}
	/**
	 * @return the name of the animal
	 */
	public String get_name() {
		return name;
	}
	/**
	 * 
	 * @return the horvetrical speed
	 */
	public int get_speedHor() {
		return horSpeed;
	}
	/**
	 * 
	 * @return the vetrical speed
	 */
	public int get_speedVer() {
		return verSpeed;
	}
	/**
	 * 
	 * @return the color of animal
	 */
	public String get_color() {
		return col;
	}
	/**
	 * 
	 * @return the direction of animal in X-axis
	 */
	public int getX_dir() {
		return this.x_dir;
	}
	/**
	 * 
	 * @return the direction of animal in Y-axis
	 */
	public int getY_dir() {
		return this.y_dir;
	}
	

	/**
	 * update the size of the animal
	 * @param size - size of animal
	 * @return true if the size updated
	 */
	public boolean set_size(int size) {
		this.size = size;
		return true;
		
	}
	/**
	 * update the horvertical speed of the animal
	 * @param speed_h - horvertical speed of the animal
	 * @return true if the horvertical speed updated
	 */
	public boolean set_speedHor(int speed_h) {
		this.horSpeed = speed_h;
		return true;
	}
	/**
	 * update the vertical speed of the animal
	 * @param speed_v - vertical speed of the animal
	 * @return true if the vertical speed updated
	 */
	public boolean set_speedVer(int speed_v) {
		this.verSpeed = speed_v;
		return true;
	}
	
	/**
	 * update the color of the animal
	 * @param color - color of the animal
	 * @return true if the color updated
	 */
	public boolean set_color(String color) {
		this.col = color;
		return true;
	}
	/**
	 * update the direction of animal in X-axis
	 * @param direction - direction of animal in X-axis
	 * @return true if the direction of animal in X-axis updated
	 */
	public boolean set_X_dir(int direction) {
		this.x_dir = direction;
		//this.get_zoo_panel().repaint();
		return true;		
	}
	/**
	 * update the direction of animal in Y-axis
	 * @param direction - direction of animal in Y-axis
	 * @return true if the direction of animal in Y-axis updated
	 */
	public boolean set_Y_dir(int direction) {
		this.y_dir = direction;
		//this.get_zoo_panel().repaint();
		return true;
	}
	
	/**
	 * update the state of thread to be suspended.
	 */
	public void setSuspended() {
		threadSuspended = true;
	}
	/**
	 * update the state of thread to back to activity.
	 */
	public void setResumed() {
		
		synchronized(this) {
			threadSuspended = false;
			this.notifyAll(); //this.notify();
		}
	}
	/**
	 * 
	 * @return the zoo panel
	 */
	public  ZooPanel get_zoo_panel() {
		return this.pan;
	}
	/**
	 * 
	 * @return the thread
	 */
	public Thread get_thread() {
		return this.thread;
	}
	/**
	 * @return the size of animal
	 */
	public int getSize() {
		return this.size;
	}
	/**
	 * update the coordChanged to state
	 */
	public void setChanges(boolean state) {
		this.coordChanged =state;
		
	}
	/**
	 * return the coordChanged- true or false
	 */
	public boolean getChanges() {
		return this.coordChanged;
	}
	
	/**
	 * return the eatCount
	 */
	public int getEatCount() {
		return this.eatCount;
	}
	/**
	 * update the amount of food that the animal eat
	 * @param count - the amount of food that the animal eat
	 * @return the amount of food that the animal eat
	 */
	public boolean set_getCount(int count) {
		 this.eatCount = count;
		 return true;
		
	}
	/**
	 * update the zoo panel
	 * @param zp- zoo panel
	 * @return the zoo panel
	 */
	public boolean setZooPanel(ZooPanel zp) {
		this.pan = zp;
		return true;
	}
	/**
	 * update the thread of animal
	 */
	public void set_thread() {
		Animal a = this;
		this.thread = new Thread(a);
	}
	
	/**
	 * load the image of the animal
	 * @nm- string of the short name of the animal
	 */
	public void loadImages(String nm) {
		try {
		if(this.get_color() == "Red") {
			 img1 = ImageIO.read(new File(PICTURE_PATH+"/"+nm+"_r_1.png"));
			 img2 = ImageIO.read(new File(PICTURE_PATH+"/"+nm+"_r_2.png"));
		}
		else if(this.get_color() == "Blue")
		{
			img1 = ImageIO.read(new File(PICTURE_PATH+"/"+nm+"_b_1.png"));
			img2 = ImageIO.read(new File(PICTURE_PATH+"/"+nm+"_b_2.png"));
		}
		else if(this.get_color() == "Natural") {
			img1 = ImageIO.read(new File(PICTURE_PATH+"/"+nm+"_n_1.png"));
			img2 = ImageIO.read(new File(PICTURE_PATH+"/"+nm+"_n_2.png"));
		}
			
		}
    	catch (IOException e) { System.out.println("Cannot load image"); }
		
    }
	/**
	 * Draws the passed Object2D object into the Graphics object.
	 */
	public void drawObject (Graphics g) {
		 if(this.getX_dir()==1)
			 g.drawImage(img1, this.getLocation().get_x()-this.getSize()/2, this.getLocation().get_y()-this.getSize()/10, this.getSize()/2, this.getSize(), this.get_zoo_panel());
		 else 
			 g.drawImage(img2, this.getLocation().get_x(), this.getLocation().get_y()-this.getSize()/10, this.getSize()/2, this.getSize(), this.get_zoo_panel());
		
	}
	/**
	 * return the color of the animal
	 */
	public String getColor() {
		return col;
	}
	
	/**
	 * @param col -Desired color of the animal.
	 *  This method changes the color of an animal. 
	 */
	public void changing_color(String col) {
		this.set_color(col);
	}
	
	
	
	
	
    /**
     * the execution of the thread
     */
	@Override
	public  void run() { 
		while(true) {
		
			try {
				Thread.sleep(100);
				if(this.threadSuspended == true) {
					synchronized(this) {
						this.wait();
					}
				}
				else {
					synchronized(this) {
						this.move(new Point(this.getLocation().get_x()+ this.get_speedHor()*this.getX_dir(),this.getLocation().get_y()+ this.get_speedVer()*this.getY_dir()));
						if(this.getLocation().get_x() >= this.get_zoo_panel().getWidth()-(this.getSize()/4)) {
							this.set_X_dir(-1);
						}
						if(this.getLocation().get_y() <= 0 || this.getLocation().get_y()+ this.get_speedVer()*this.getY_dir() < 0 ) { // arrived to the top of the frame
							this.set_Y_dir(1);
							
						}
						if(this.getLocation().get_x()-(int)((double)this.getSize()) <= 0)
						{
							this.set_X_dir(1);
						
						}
						if(this.getLocation().get_y() >= this.get_zoo_panel().getHeight()-this.getSize() || this.getLocation().get_y()+ this.get_speedVer()*this.getY_dir() > this.get_zoo_panel().getHeight()-this.getSize()){
							this.set_Y_dir(-1);
						
						}
						
						}
								
						
						this.get_zoo_panel().repaint();

					}
				}
				
					
			
			catch(InterruptedException ex) {}
			
		}
	}
	
}
		
	

		
	

	

