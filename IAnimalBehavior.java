package homework4;


/**
 * The interface that represents behaviors attached to animlas in the zoo.
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 *
 */
public interface IAnimalBehavior {
	
	/**
	 * 
	 * @return the name of the animal.
	 */
	//public String getAnimalName();
	
	/**
	 * 
	 * @return size of the animals in pixels.
	 */
	public int getSize();
	
	/**
	 * increases the counter which counts the amount of food the animal ate.
	 */
	public void eatInc();
	
	/**
	 * 
	 * @return the amount of food the animal ate.
	 */
	public int getEatCount();
	
	
	
	/**
	 * 
	 * @return true if there were changes in the zoo(locations,animal ate another animal...)
	 */
	public boolean getChanges ();
	
	/**
	 * 
	 * @param state- true if there were changes in the zoo, else false.
	 */
	public void setChanges (boolean state);
	
	
	public void setSuspended();
	
	public void setResumed();
}
