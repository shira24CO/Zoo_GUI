package homework4;

/**
 * This class describes a point with an x-value and y-value
 * which are limited. 
 * The range of the x values are from 0 to 800.
 * The range of the y values are from 0 to 600.
 */
public class Point {
	
	
	
	/**
	 * States the smallest x-value of a point.
	 */
	final static int min_x = 0;
	
	
	
	/**
	 * States the largest x-value of a point.
	 */
	final static int max_x = 800;
	
	
	
	/**
	 * States the smallest y-value of a point.
	 */
	final static int min_y = 0;
	
	
	
	/**
	 * States the largest y-value of a point.
	 */
	final static int max_y = 600;
	
	
	
	/**
	 * The location of a point on the x-axis.
	 */
	private int x;
	
	
	
	/**
	 * The location of a point on the y-axis.
	 */
	private int y;
	
	
	
	
	/**
	 * Constructs a new Point object.
	 * @param p - Existing Point object
	 *
	 */
	public Point(Point p) {
		this.set(p.x, p.y);	
	}
	
	
	/**
	 * Constructs a new Point object.
	 * @param x - The x-value of the point.
	 * @param y - The y-value of the point.
	 */
	public Point(int x, int y) {
		this.set(x, y);    
	}
	
	
	/**
	 * Returns the x-value of a point.
	 * @return - The x-value of the point.
	 */
	public int get_x() {
		return x;
	}
	
	
	/**
	 * Returns the y-value of a point.
	 * @return - The y value of the point.
	 */
	public int get_y() {
		return y;
	}
	
	/**
	 * Checks if the values received for the point(x,y) are valid,
	 * and if so,does an assignment of x and y to the data members of the point object.
	 * @param x - The x value of a point.
	 * @param y -The y value of a point.
	 * @return - True if the values for the point are valid,else false.
	 */
	public boolean set(int x, int y) {
		
		if((x >= min_x && x <= max_x) && (y >= min_y && y <= max_y)) {
            this.x = x;
            this.y = y;
			return true;
		}
		else { //In case the values of the point are invalid, we set the data members of the point object - x,y to be both -1 which will be a point created in case the user entered wrong x,y values. 
			this.x = -1;
			this.y = -1;
		    return false;
		}
	}
	/**
	 * Compares the values of two points.
	 * @param p - Point object.
	 * @return - True if both points have the same x,y values,otherwise false.
	 */
	public boolean equals(Point p) {
		return this.x == p.x && this.y == p.y;
	}
	
	/**
	 * This method checks the validity of x,y values of the point received as a parameter.
	 * @param point - A certain point object.
	 * @return True if the x,y values of the point are valid, otherwise returns false.
	 */
	public static boolean cheackBounderies(Point point) {
		return (point.x >= min_x && point.x <= max_x) && (point.y >= min_y && point.y <= max_y);
	}
	
	
	/**
	 * The representation of a point object to the user.
	 * @return String representing the point object.
	 */
	public String toString() {
		return "(" + this.get_x() +","+this.get_y() +")";		
	}
	

}
