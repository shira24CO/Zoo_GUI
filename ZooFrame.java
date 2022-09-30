package homework4;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Lock;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 * Frame of the zoo.
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 * 
 *
 */
public class ZooFrame extends JFrame{
	/**
	 * 
	 */
	private Lock objectLock;
	/**
	 * the panel of the zoo
	 */
	private ZooPanel m;
	
	/**
	 * /**
	 * constructor of ZooFrame
	 * 
	 */
	public ZooFrame() {
	    m = ZooPanel.getInstance();
		JFrame frame = new JFrame("Zoo");
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setResizable(false);
		JLabel label = new JLabel();	
		frame.add(label);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenu background = new JMenu("Background");
		menuBar.add(background);
		JMenu help = new JMenu("Help");
		menuBar.add(help);
		JMenuItem exit_menu = new JMenuItem("Exit");
		file.add(exit_menu);
		exit_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/**
		 * the option of the image background in the button file
		 */
		JMenuItem image = new JMenuItem("Image");
		background.add(image);
		image.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				m.set_image_identifier(1);
				m.repaint();
				
			}
		});
		/**
		 * the option of the green background in the button file
		 */
		JMenuItem green = new JMenuItem("Green");
		background.add(green);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setBackground(Color.GREEN);
				m.set_image_identifier(2);
				m.repaint();
			}
		});
		/**
		 * the option of the none background in the button file
		 */
		JMenuItem none = new JMenuItem("None");
		background.add(none);
		none.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setBackground(null);
				m.set_image_identifier(3);
				m.repaint();
			}
		});
		/**
		 * the option of the help in the button help
		 */
		JMenuItem help_1 = new JMenuItem("Help");
		help.add(help_1);
		help_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Home Work 2\n GUI");
			}
		});
		/**
		 * the buttons of the panel
		 */
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,6));
		buttonsPanel.setVisible(true);
		/**
		 * the button of the add of the animals
		 */
		JButton addAnimal = new JButton("Add Animal");
		addAnimal.setBackground(Color.WHITE);
		addAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addAnimal) {
					new AddAnimalDialog(m);
				}
				
			}
		});
		
		JButton change_color = new JButton("Change Color");
		change_color.setBackground(Color.WHITE);
		change_color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == change_color) {
					new ChangeColor();
				}
				
			}
		});
			
				
		
		buttonsPanel.add(addAnimal);
		buttonsPanel.add(change_color);
		/**
		 * the sleep button
		 */
		JButton sleep  =new JButton("Sleep");
		sleep.setBackground(Color.WHITE);
		sleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(m) {
					if(e.getSource() == sleep) {
						for(int i=0;i<AddAnimalDialog.get_counter();i++) {
							m.get_animal_array()[i].setSuspended();
						}		
						}
				}
			}
		});
		buttonsPanel.add(sleep);
		/**
		 * the wakeUp button 
		 */
		JButton wakeUp = new JButton("Wake up");
		wakeUp.setBackground(Color.WHITE);
		wakeUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(e.getSource() == wakeUp) {
						synchronized(m) {
							for(int i=0;i<AddAnimalDialog.get_counter();i++) {
								m.get_animal_array()[i].setResumed();
								m.get_animal_array()[i].setChanges(true);
							}
						}
					}
			}
			});
		
		buttonsPanel.add(wakeUp);
		/**
		 * the clear button- clean the panel
		 */
		JButton clear = new JButton("Clear");
		clear.setBackground(Color.WHITE);
		clear.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == clear) {
					for(int i = 0;i<AddAnimalDialog.get_counter();i++)
					{
						ZooPanel.get_animal_array()[i].get_thread().stop();
						ZooPanel.get_animal_array()[i] = null;
					
					}
					m.repaint();
				
				}
			}
		});
		buttonsPanel.add(clear);
		/**
		 * the food button- for the animals
		 */
		JButton food = new JButton("Food");
		food.setBackground(Color.WHITE);
		food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == food)
					new Food();
			}
		});
		
		buttonsPanel.add(food);
		/**
		 * the info button- contain the all information about all animals in the panel
		 */
		JButton info = new JButton("Info");
		info.setBackground(Color.WHITE);
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == info) {
					JFrame frame_info = new JFrame("Info");
					JPanel panel_info = new JPanel();
					panel_info.setBorder(BorderFactory.createTitledBorder(
						      BorderFactory.createEtchedBorder(), "My Demo Table", TitledBorder.LEFT,
						      TitledBorder.TOP));

					frame_info.setLayout(new BorderLayout());
					
					String [][] data = new String[AddAnimalDialog.get_counter()][6];
					for(int i=0 ; i<AddAnimalDialog.get_counter()  ;i++) {
						if(ZooPanel.get_animal_array()[i]!=null) {
							data[i][0] = ZooPanel.get_animal_array()[i].get_name_of_class();
							data[i][1] = ZooPanel.get_animal_array()[i].get_color();
							data[i][2] = ZooPanel.get_animal_array()[i].get_weight() +"";	
							data[i][3] = ZooPanel.get_animal_array()[i].get_speedHor() + "";
							data[i][4] = ZooPanel.get_animal_array()[i].get_speedVer()+"";
							data[i][5] = ZooPanel.get_animal_array()[i].getEatCount()+"";
						}
						}
					/**
					 * string with the all name of the animals
					 */
						String [] titles = {"Animal","Color","Weight","Hor. speed","Ver.speed","Eat Counter"};
                        /**
                         * the table of information of the animals
                         */
						final JTable table = new JTable(data,titles);
					table.setCellSelectionEnabled(true);
					ListSelectionModel select= table.getSelectionModel();  
		            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					JScrollPane table_scroll = new JScrollPane(table);
					table.setPreferredScrollableViewportSize(new Dimension(500, 70));
					table.setFillsViewportHeight(true);
					frame_info.add(panel_info);
					panel_info.add(new JScrollPane(table_scroll));
					frame_info.setSize(800, 600);
					frame_info.pack();
					frame_info.setVisible(true);
					frame_info.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					
					}
			  }
			
		});
		info.setBackground(Color.WHITE);
		
		buttonsPanel.add(info);
		JButton exit = new JButton("Exit");
		exit.setBackground(Color.WHITE);
		buttonsPanel.add(exit);
		exit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.add(m);
		frame.add(buttonsPanel,BorderLayout.SOUTH);
		frame.setSize(800,600);
	
	}	
	
	
	public static void main(String[] args) {
		ZooFrame zoo = new ZooFrame();
		
	}
		
}