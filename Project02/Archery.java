/*
 * Ryan LeBoeuf
 * Project 02
 * Due: 1.27.21
 * Last Modified: 1.22.21
 * 
 * Create an archery target complete with colored rings, labels, and a line from the label
 * to the corresponding ring.
 */


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Archery extends JFrame {

	private static final long serialVersionUID = 1L;

	public Archery() {
		super();
		this.setTitle("Archery - Project 02");
		this.setSize(700, 600);
		this.setBackground(Color.white);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics pen) {
		Color babyBlue = new Color(56, 189, 255);
		Color babyRed = new Color(235, 82, 82);
		Color babyYellow = new Color(240, 240, 58);
		
		int width = this.getWidth() - 160;	// subtracted from the actual width in lieu of padding for text
		int height = this.getHeight();
		
		int dilation = 46;					// how much to dilate each circle by (ring width = dilation / 2)
		int baseDiameter = -10;				// base diameter is negative because dilation * circleNum is added
		
		// fill 11 circles (outside to inside) and color code each accordingly
		for (int circleNum = 11; circleNum > 0; circleNum--) {
			
			// change color depending on the ring
			if (circleNum > 0)
				pen.setColor(babyYellow);
			if (circleNum > 3)
				pen.setColor(babyRed);
			if (circleNum > 5)
				pen.setColor(babyBlue);
			if (circleNum > 7)
				pen.setColor(Color.gray);
			if (circleNum > 9)
				pen.setColor(Color.white);
			
			// fill each circle
			pen.fillOval(width / 2 - (baseDiameter + dilation * circleNum) / 2, height / 2 - (baseDiameter + dilation * circleNum) / 2, 
					baseDiameter + dilation * circleNum, baseDiameter + dilation * circleNum);
			
			// outline each ring
			pen.setColor(Color.black);
			pen.drawOval(width / 2 - (baseDiameter + dilation * circleNum) / 2, height / 2 - (baseDiameter + dilation * circleNum) / 2, 
						baseDiameter + dilation * circleNum, baseDiameter + dilation * circleNum);
			
		}
		
		// labels and lines
		
		pen.setColor(Color.black);
		
		int lineSpacing = 30;
		int lineNumber = 1;
		String labelText = "";
		
		// label each ring with drawString and drawLine to corresponding ring
		for (int i = 11; i > 0; i--) {
			
			if (lineNumber == 1) {
				labelText = "X Ring 10 Points";
			} else if (lineNumber == 11) {
				labelText = i + " Point";
			} else {
				labelText = i + " Points";
			}
			
			// paint the labels for each ring
			pen.drawString(labelText, width + 10, height / 6 + lineSpacing * lineNumber);
			
			// connect labels to rings with lines that have 2pt thickness
			pen.drawLine(width / 2, height / 2 + (lineNumber - 1) * (dilation / 2) + 7, width, height / 6 + lineSpacing * lineNumber);
			pen.drawLine(width / 2, height / 2 + (lineNumber - 1) * (dilation / 2) + 6, width, height / 6 + lineSpacing * lineNumber - 1);
			
			lineNumber++;
		}
		
	}
	
}
