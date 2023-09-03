package userInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UserInterface extends JFrame {

	private JTextArea textArea;
	private JMenu menu;
	private Color initialBackgroundColor;
	
	public UserInterface() {
        setTitle("Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menu = new JMenu("Menu");
        
        JMenuItem dateTimeItem = new JMenuItem("Print Date and Time");
        JMenuItem saveToFileItem = new JMenuItem("Save to File");
        JMenuItem changeBackgroundColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        //printDateTime();
        
        //saveToFile();
        
        //changeBackgroundColor();
        
        //exit();
        
	}
	
	
	
	
}
