package homework4;
import homework4.Point;
/**
 * A class of roaring animals
 *  @author Shira Cohen 211777834 & Ilan Shklover 206753550
 *
 */
public abstract class RoarAnimals extends Animal {
	/**
	 * Constructor with name, point
	 * @param name - the name of the animal.
	 * @param point - the location of the animal.
	 */
	public RoarAnimals(String name, Point point) {
		super(name, point);
	}
	
	/**
	 * Constructor with the size and the default location of an animal.
	 * @param size -  the size of the animal.
	 * @param point - the default location of the animal.
	 */
	public RoarAnimals(int size, Point point) {
		super(size,point);
	}
	
	/**
	 * The sound the animal produces after it ate.
	 */
	public abstract void roar();
	
	
	/**
	 *print the sound of the roaring animal
	 */
	public void makeSound() {
		roar();
	}

}
