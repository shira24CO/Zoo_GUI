package homework4;

import homework4.EFoodType;
import homework4.IEdible;
import homework4.Animal;


/**
 * 
 * @author Ilan Shklover,Shira Cohen
 * This interface describes functionality of eating.
 */
public interface IDiet {
	
	/**
	 *Checks if the animal can eat the 'food' received as a parameter.
	 *@param - something edible for animal(other animal or plant)
	 *@return - True if the animal is able to eat the food in parameter 'food',else false.
	 */
	public boolean canEat(EFoodType food);
	
	
	/**
	 *Performs simulation of eating.
	 *@param animal - A certain animal.
	 *@param food - Something edible which can be an animal or a plant.
	 *@return - If the animal can eat the 'food' received as a parameter,
	 *then the amount of weight the animal will gain from this meal will be returned.
	 **/
	public double eat(Animal animal,IEdible food);

}
