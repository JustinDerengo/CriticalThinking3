package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")//not sure what this does, but eclipse gave it as a warning and solution
public class UserInterface extends JFrame {

	private JTextArea textArea;
	private JMenu menu;

	public UserInterface() {
		
		//Initializes new JFrame, w/ a scroll pane for text, and a JMenuBar w/ menu and menu items
        setTitle("Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menu = new JMenu("Menu");
        
        JMenuItem dateTimeItem   			= new JMenuItem("Print Date and Time");
        JMenuItem saveToFileItem 			= new JMenuItem("Save to File");
        JMenuItem changeBackgroundColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem 					= new JMenuItem("Exit");
        
        //need to add action listeners to the menu items so they will run class methods when selected
        dateTimeItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		printDateTime();
        	}
        });
        
        saveToFileItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		saveToFile();
        	}
        });
        
        //line 54 was added so that it only allows the user to change the hue once, per instructions.
        changeBackgroundColorItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		changeBackgroundColor();
        		((JMenuItem) e.getSource()).removeActionListener(this); //removes event listener after first time executed
        	}
        });
        
        
        exitItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);;
        	}
        });
        
        //need to add the menu and the menu items to the bar of the JFrame
        menuBar.add(menu);
        
        menu.add(dateTimeItem);
        menu.add(saveToFileItem);
        menu.add(changeBackgroundColorItem);
        menu.add(exitItem);
        
        
	}
	
	/*
	 * this method will create a new date and time format and append it to the text area
	 * @param:none
	 * @return:void
	 * @throws:none
	 */
	private void printDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		String dateTime				= dateFormat.format(new Date());
		textArea.append(dateTime + "\n");
	}
	
	/*
	 * this method will try to create a new log.txt file using FileWriter, BufferedWriter, and PrintWriter
	 * and will display a message when it is done, or failed
	 * @param:none
	 * @return:void
	 * @throws:error saving to file
	 */
	private void saveToFile() {
		try (FileWriter writer = new FileWriter("log.txt", true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				PrintWriter out = new PrintWriter(bufferedWriter)) {
			String text = textArea.getText();
			out.println(text);
			JOptionPane.showMessageDialog(this, "Saved to log.txt");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage());
		}
	}
	
	/*
	 * this method will change the background color of the text field to a random hue of orange
	 * This was changed to only having three different hues of orange to choose from, since some colors
	 * looked too yellow or red when done with a RGB scaler method
	 *  @param:none
	 *  @return:none
	 *  @throws:none
	 */
	private void changeBackgroundColor() {
        // Select from one of three random hues of orange
        float[] hues = {0.05f, 0.08f, 0.11f};
        float randomHue = hues[(int) (Math.random() * hues.length)];
        Color randomOrangeHue = Color.getHSBColor(randomHue, 1, 1);
        textArea.setBackground(randomOrangeHue);
	}
}
