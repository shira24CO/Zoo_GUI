package homework4;
import homework4.EFoodType;
import homework4.IEdible;
import homework4.MessageUtility;
import homework4.Animal;

/**
 * 
 * @author Ilan Shklover,Shira Cohen
 *This class represents animals who eat everything.
 */
public class Omnivore implements IDiet  {
	private Carnivore carn;
	private Herbivore herb;
	
	public Omnivore() {
		carn = new Carnivore();
		herb = new Herbivore();
	}
	
	/**
	 * Checks if the animal can eat the 'food' received as a parameter.
	 * @param - something edible for animal(other animal or plant)
	 * @return - True if the animal is able to eat the food in parameter 'food',else false.
	 */
	public boolean canEat(EFoodType food) {
		MessageUtility.logBooleanFunction("Omnivore","canEat", food, carn.canEat(food) || herb.canEat(food));
		//return food != EFoodType.NOTFOOD;
		return carn.canEat(food) || herb.canEat(food);
		
	}
	
	
	
	
	/**
	 *Performs simulation of eating.
	 *@param animal - A certain animal.
	 *@param food - Something edible which can be an animal or a plant.
	 *@return - If the animal can eat the 'food' received as a parameter,
	 *then the amount of weight the animal will gain from this meal will be returned.
	 */
    public double eat(Animal animal, IEdible food) {
    	return carn.eat(animal, food) + herb.eat(animal, food);
		//if(this.canEat(food.getFoodtype())) {
			//if(food instanceof Animal)
				//return animal.get_diet().eat(animal,food);
			//else 
				//return animal.get_diet().eat(animal, food);
		//}
		//return 0;
    }

}
