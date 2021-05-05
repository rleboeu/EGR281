package edu.mtc.egr281;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * ColorSampler.java
 * 
 * The JFrame application class
 * Handles the 'action performed' logic for the program and 
 * contains the getColor method.
 */

public class ColorSampler extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static final Dimension DEFAULT_DIM = new Dimension(600, 600);
	private static final Color DEFAULT_COLOR = Color.white;
	
	private Container contentPane;
	private JTextField txtAskColor;
	private JButton btnAskColor;
	
	public ColorSampler() {
		super();
		
		this.setPreferredSize(DEFAULT_DIM);
		this.setMaximumSize(DEFAULT_DIM);
		this.setMinimumSize(DEFAULT_DIM);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.contentPane = this.getContentPane();
		this.contentPane.setBackground(DEFAULT_COLOR);
		this.contentPane.setLayout(new FlowLayout());
		
		this.txtAskColor = new JTextField(25);
		this.contentPane.add(txtAskColor);
		
		this.btnAskColor = new JButton("Show Me the Color!");
		this.btnAskColor.addActionListener(this);
		this.contentPane.add(btnAskColor);
		
	}// Ending bracket of constructor

	// action listener method
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals(this.btnAskColor.getText())) {
			Color newBackgroundColor = DEFAULT_COLOR;
			
			try {
				newBackgroundColor = this.getColor(this.txtAskColor.getText());
			} catch (UnknownColorException uce) {
				newBackgroundColor = DEFAULT_COLOR;
				this.txtAskColor.setText(uce.getMessage());
			} catch (Exception ue) {
				System.out.println("Unkown exception occured ... ");
				System.out.println(ue.getMessage());
				ue.printStackTrace();
			}// Ending bracket of try catch
			
			this.contentPane.setBackground(newBackgroundColor);
		}// Ending bracket of if
		
	}// Ending bracket of method actionPerformed
	
	// returns a color (if one exists) based on the parameter colorString
	private Color getColor(String colorString) throws UnknownColorException {
		Color color = DEFAULT_COLOR;
		
		// for Color.DARK_GRAY and Color.LIGHT_GRAY, replace space with underscore 
		String formatString = colorString.replace(' ', '_');	
		formatString = formatString.toUpperCase();
		
		// does Color have the field formatString
		try {
			Field field = Color.class.getField(formatString);
			color = (Color)field.get(null);
		} catch (Exception e) {
			throw new UnknownColorException();
		}// Ending bracket of try catch
		
		return color;
	}// Ending bracket of method getColor
	
}// Ending bracket of class ColorSampler
