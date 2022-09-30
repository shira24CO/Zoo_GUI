package homework4;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.Animal;
import homework4.Elephant;
import homework4.Giraffe;
import homework4.Turtle;
import homework4.Plant;
import homework4.MessageUtility;

/**
 * 
 * @author Ilan Shklover,Shira Cohen.
 * This class represents the animals who eat plants only.
 */
public class Herbivore implements IDiet {
	
	/**
	 *Checks if the animal can eat the 'food' received as a parameter.
	 *@param - something edible for animal(other animal or plant)
	 *@return - True if the animal is able to eat the food in parameter 'food',else false.
	 **/
	public boolean canEat(EFoodType food) {
		MessageUtility.logBooleanFunction("Herbivore","canEat", food, food == EFoodType.VEGETABLE);
		return food == EFoodType.VEGETABLE;
	}
	
	
	/**
	 *Performs simulation of eating.
	 *@param animal - A certain animal.
	 *@param food - Something edible which can be an animal or a plant.
	 *@return - If the animal can eat the 'food' received as a parameter,
	 *then the amount of weight the animal will gain from this meal will be returned.
	 **/
    public double eat(Animal animal, IEdible food) {
		if(this.canEat(food.getFoodtype()))
			return animal.get_weight()*0.07;
		return 0;
    }
		    
	
	
}