package homework4;
/**
 * 
 * @author Ilan Shklover,Shira Cohen
 *This interface describes objects that are edible.
 *contains one method which returns the object's type of food.
 */
public interface IEdible {
	
	/**
	 * Returns which type of food is the animal.
	 * @return - The type of food the animal is.
	 */
	public EFoodType getFoodtype();
}