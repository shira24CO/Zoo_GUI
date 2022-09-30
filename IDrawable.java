package homework4;
import java.awt.Graphics;
/**
 * interface for a drawable game component.
 * @author Shira Cohen 211777834 & Ilan Shklover 206753550
 * 
 */
public interface IDrawable {
	/**
	 * the path of the folder of pictures of animals and food in the zoo.
	 */
	public final static String PICTURE_PATH = "C:/Users/Ilan Shklover/OneDrive/שולחן העבודה/assignment2_pictures";
	/**
	 * Uploads the photos from the Photos folder
	 * @param nm - The name of the animal in the pictures folder
	 */
	public void loadImages(String nm); //
	/**
	 * Draws the pictures on the ZooPanel
	 * @param g - Graphics object
	 */
	public void drawObject (Graphics g);
	/**
	 * 
	 * @return the color
	 */
	public String getColor();
}