package homework4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * 
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 * This class is responsible for the GUI option to change the animal's color.
 */
public class ChangeColor extends JDialog{
	/**
	 * All the animals in the zoo.
	 */
	private JComboBox animals;
	
	
	/**
	 * Constructor for the window of changing the animal's color.
	 */
	public ChangeColor() {
		super();
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 2));
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		
		

		
		JButton red = new JButton("Red");
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == red) { 
					ZooPanel.get_animal_array()[animals.getSelectedIndex()].changing_color("Red");
					JOptionPane.showMessageDialog(null, "Saved");
					//ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_zoo_panel().repaint();
					
				}	
			}
			});
		
		
		JButton blue = new JButton("Blue");
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == blue) { 
					ZooPanel.get_animal_array()[animals.getSelectedIndex()].changing_color("Blue");
					JOptionPane.showMessageDialog(null, "Saved");
					//ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_zoo_panel().repaint();
					
				}	
			}
			});
		
		
		JButton natural = new JButton("Natural");
		natural.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == natural) { 
					ZooPanel.get_animal_array()[animals.getSelectedIndex()].changing_color("Natural");
					JOptionPane.showMessageDialog(null, "Saved");
					//ZooPanel.get_animal_array()[animals.getSelectedIndex()].get_zoo_panel().repaint();
					
				}	
			}
			});
		Object []  colors = {red,blue,natural};
		animals = new JComboBox(ZooPanel.get_animal_array());
		JButton save = new JButton("Save animal");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == save) {
					JOptionPane.showMessageDialog(null, "Saved");
					JOptionPane.showOptionDialog(save,//parent container of JOptionPane
					        "Please choose color ",
					        "Change color",
					        JOptionPane.YES_NO_CANCEL_OPTION,
					        JOptionPane.QUESTION_MESSAGE,
					        null,//do not use a custom Icon
					        colors,//the titles of buttons
					        null);//default button title
					
				}
		}
	});
		
		this.add(animals);
		this.add(save);
		this.pack();
		this.setVisible(true);
	}

}
