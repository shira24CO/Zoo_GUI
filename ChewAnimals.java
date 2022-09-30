package homework4;
import homework4.Point;


/**
 * A class of chewing animals
 * @author Shira Cohen 211777834 & Ilan Shklover 206753550
 *
 */
public abstract class ChewAnimals extends Animal{
	/**
	 * Constructor with name, point
	 * @param name - name of the animal
	 * @param point - location of the animal
	 */
	public ChewAnimals(String name, Point point) {
		super(name, point);
	}
	
	
	/**
	 *  Constructor with size and point of an animal.
	 * @param size the size of the animal.
	 * @param point the default location of the animal.
	 */
	public ChewAnimals(int size, Point point) {
		super(size,point);
	}
	
	/**
	 * States the sound the animal produces after eating.
	 */
	public abstract void chew();
	
	
	
	/**
	 *print the sound of the chewing animal
	 */
	public void makeSound() {
		chew();
	}

}
