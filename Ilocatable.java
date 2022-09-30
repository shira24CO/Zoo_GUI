package homework4;
 /**
  * This interface represents functionality of location.
  * @author Ilan Shklover, Shira Cohen
  *
  */
public interface Ilocatable {
	
	/**
	 * Returns the current location(point).
	 * @return- Current location.
	 */
	public Point getLocation();
	
	
	
	/**
	 * Updates the current location.
	 * @param point - The destination.
	 * @return - True if the current location was updated,else returns false.
	 */
	 public boolean setLocation(Point point); 

}