package homework4;


/**
 * 
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 * This class creates a factory for each of the animals.
 *
 */
public class IdietFactory {
	/**
	 * 
	 * @param type - type of factory - omnivore, carnivore or herbivore.
	 * @return The factory in which a specific animal object can be created.
	 */
	public static IDiet create_idiet_factory(String type) {
		if(type == "Omnivore") {
			return new Omnivore();	
		}
		else if(type == "Herbivore") {
			return new Herbivore();
		}
		else {
			return new Carnivore();
		}
		
	}

}
