package homework4;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Animal;
import homework4.Lion;
import homework4.MessageUtility;
/**
 * 
 * @author Ilan Shklover, Shira Cohen
 * This class describes animals which are eating meat only.
 *
 */
public class Carnivore implements IDiet {
	
	/**
	 * Checks if the animal can eat the 'food' received as a parameter.
	 *@food - something edible for animal(other animal or plant)
	 *@return  - True if the animal is able to eat the food in parameter 'food',else false. 
	 */
	public boolean canEat(EFoodType food) {
		MessageUtility.logBooleanFunction("Carnivore","canEat", food, food == EFoodType.MEAT);
		return food == EFoodType.MEAT;
	}
	
	
	/**
	 *Performs simulation of eating.
	 *@param animal - A certain animal.
	 *@param food - Something edible which can be an animal or a plant.
	 *@return - If the animal can eat the 'food' received as a parameter,
	 *then the amount of weight the animal will gain from this meal will be returned.
	 */
    public double eat(Animal animal, IEdible food) {
		if(this.canEat(food.getFoodtype()))
			return animal.get_weight()*0.1;
		return 0;
    }
    

}