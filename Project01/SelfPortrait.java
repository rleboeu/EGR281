/*
 * Ryan LeBoeuf
 * Project 01
 * This program generates a self-portrait using java.awt in a 600x600 window.
 * Due: 1.20.21 (my birthday)
 * Last Modified: 1.19.21
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.lang.Math;

public class SelfPortrait extends JFrame {

	private static final long serialVersionUID = 1L;
	
	int WIDTH = 600, HEIGHT = WIDTH;

	public SelfPortrait() {
		super();
		this.setTitle("Self Portrait");
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.black);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics pen) {
		Color baseSkin = new Color(255, 215, 194);
		//Color skinOutline = new Color(255, 185, 148);
		Color skinOutline = new Color(219, 159, 127);
		Color eyeColor = new Color(105, 171, 224);
		Color hairColor = new Color(135, 106, 32);
		Color lipsColor = new Color(212, 78, 97);
		
		int xCenterFace = WIDTH / 2;
		int yCenterFace = HEIGHT / 2;
		int eyeWidth = 80;			// spacing between eyes
		int eyeHeight = 250; 		// space between top of screen and eyes
		int eyebrowThickness = 100;	// number of eyebrow hairs per eyebrow
		int hairThickness = 3000;	// number of strands of hair
		int faceWidth = 340; 		// actual width of face
		int faceHeight = 400; 		// actual height of face
		int lipThickness = 10;		// pixel thickness of lips
		
		// @ears
		pen.setColor(baseSkin);
		
		// right ear
		pen.fillArc(xCenterFace + 135, yCenterFace - 50, 50, 100, 90, -180);
		pen.fillArc(xCenterFace + 155, yCenterFace + 10, 25, 40, 90, -190);
		
		// left ear
		pen.fillArc(xCenterFace - 188, yCenterFace - 50, 50, 100, 90, 180);
		pen.fillArc(xCenterFace - 177, yCenterFace + 15, 25, 40, 90, 190);
		
		// inner ear
		pen.setColor(skinOutline);
		pen.fillArc(xCenterFace + 155, yCenterFace - 20, 25, 40, 90, -190);
		pen.fillArc(xCenterFace - 182, yCenterFace - 20, 25, 40, 90, 190);
		
		// @head
		
		// base oval face shape
		pen.setColor(baseSkin);
		pen.fillOval(xCenterFace - faceWidth / 2, yCenterFace - faceHeight / 2, faceWidth, faceHeight);
		
		pen.setColor(skinOutline);
		pen.drawOval(xCenterFace - faceWidth / 2, yCenterFace - faceHeight / 2, faceWidth, faceHeight);
		
		// flatten the top of the head
		pen.setColor(this.getBackground());
		pen.fillRect(xCenterFace - (faceWidth + 5), yCenterFace - 110 - HEIGHT / 6, WIDTH - 155, 120);

		pen.setColor(baseSkin);
		pen.fillArc(xCenterFace - 155, yCenterFace - 85 - HEIGHT / 6, 310, 190, 0, 180);
		
		
		// @eyes
		
		// whites of eyes
		pen.setColor(Color.white);
		pen.fillOval(xCenterFace + eyeWidth / 2, eyeHeight, 75, 40);
		pen.fillOval(xCenterFace - eyeWidth / 2 - 75, eyeHeight, 75, 40);
		
		// irises
		pen.setColor(eyeColor);
		pen.fillOval(xCenterFace + eyeWidth / 2 + 20, eyeHeight + 3, 35, 35);
		pen.fillOval(xCenterFace - eyeWidth / 2 - 55, eyeHeight + 3, 35, 35);
		
		// pupils
		pen.setColor(Color.black);
		pen.fillOval(xCenterFace + eyeWidth / 2 + 27, eyeHeight + 10, 20, 20);
		pen.fillOval(xCenterFace - eyeWidth / 2 - 48, eyeHeight + 10, 20, 20);
		
		// eyelids
		pen.setColor(baseSkin);
		
		for (int i = 0; i < 10; i++) {
			if (i == 9) {
				pen.setColor(skinOutline);
			}
			
			// top eyelids
			pen.drawArc(xCenterFace + eyeWidth / 2 - 10, eyeHeight + i, 95, 40, 0, 180);
			pen.drawArc(xCenterFace - eyeWidth / 2 - 85, eyeHeight + i, 95, 40, 0, 180);
			
			// bottom eyelids
			pen.drawArc(xCenterFace + eyeWidth / 2 - 10, eyeHeight - i, 95, 40, 0, -180);
			pen.drawArc(xCenterFace - eyeWidth / 2 - 85, eyeHeight - i, 95, 40, 0, -180);
		}
		
		pen.setColor(skinOutline);
		pen.drawOval(xCenterFace + eyeWidth / 2 - 1, eyeHeight - 1, 75 + 1, 40 + 1);
		pen.drawOval(xCenterFace - eyeWidth / 2 - 75 - 1, eyeHeight - 1, 75 + 1, 40 + 1);
		
		// @mouth

		// open mouth background
		pen.setColor(Color.black);
		pen.fillOval(xCenterFace - 78, yCenterFace + 75, 140, 90);
		
		// teeth
		pen.setColor(Color.white);
		
		// create 10 teeth, adjusting the rectangle x coordinate to toothSize(10)  + 1 * toothNumber(i)
		for (int i = 0; i < 10; i++) {
			pen.fillRect(xCenterFace - 53 + (11 * i), yCenterFace + 100, 10, 9);
		}
		
		// lips
		pen.setColor(lipsColor);
		
		
		for (int i = 0; i < lipThickness; i++) {
			
			// top lip
			pen.drawArc(xCenterFace - 78, yCenterFace + 100 - i, 110, 90, -180, -115);
			pen.drawArc(xCenterFace - 31, yCenterFace + 100 - i, 110, 90, 0, 115);
			
			// bottom lip
			pen.drawArc(xCenterFace - 90, yCenterFace + 45 - i, 180, 90, 0, -180);
		}
		
		// shape mouth
		pen.setColor(baseSkin);
		
		// cut stray arc lengths by drawing over them to shape mouth
		for (int i = 0; i < lipThickness * 6; i++) {
			
			// top lip
			pen.drawArc(xCenterFace - 78, yCenterFace + 90 - i, 110, 90, -180, -115);
			pen.drawArc(xCenterFace - 31, yCenterFace + 90 - i, 110, 90, 0, 115);
			
			// bottom lip
			pen.drawArc(xCenterFace - 90, yCenterFace + 45 + i, 180, 90, 0, -180);
		}
		
		// excess lip
		pen.fillRect(xCenterFace - 128, yCenterFace + 40, 50, 70);
		pen.fillRect(xCenterFace + 80, yCenterFace + 40, 50, 70);
		
		// @nose
		
		pen.setColor(skinOutline);
		
		// nose bridge
		pen.drawArc(xCenterFace + 15, yCenterFace - 30, 20, 80, 140, 90);
		pen.drawArc(xCenterFace - 35, yCenterFace - 30, 20, 80, 40, -90);
		
		// nose bridge thickness
		pen.drawArc(xCenterFace + 16, yCenterFace - 30, 20, 80, 140, 90);
		pen.drawArc(xCenterFace - 36, yCenterFace - 30, 20, 80, 40, -90);
		
		// nostrils and tip
		pen.drawArc(xCenterFace + 2, yCenterFace + 40, 30, 20, 90, -180);
		pen.drawArc(xCenterFace - 32, yCenterFace + 40, 30, 20, 90, 180);
		pen.drawArc(xCenterFace - 15, yCenterFace + 45, 30, 20, 180, 180);
		
		// nostrils and tip thickness
		pen.drawArc(xCenterFace + 3, yCenterFace + 40, 30, 20, 90, -180);
		pen.drawArc(xCenterFace - 33, yCenterFace + 40, 30, 20, 90, 180);
		pen.drawArc(xCenterFace - 16, yCenterFace + 45, 30, 20, 180, 180);
		
		// @eyebrows
		pen.setColor(hairColor);
		
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		int xStep = 4;
		int strandLength = 10;
		
		// left eyebrow
		for (int i = 0; i < 100; i++) {
			x1 = (int) (Math.random() * 90 + (xCenterFace - (int) (eyeWidth * 1.5)));
			y1 = yCenterFace - 70;
			
			if (Math.random() >= 0.5) {
				x2 = x1 + xStep;
			} else {
				x2 = x1 - xStep;
			}
			
			// calculate y2 such that strandLength = d = sqrt( (x2 - x1)^2 + (y2 - y1)^2 )
			y2 = y1 + (int) Math.sqrt(Math.pow(strandLength, 2) - Math.pow(x2 - x1, 2));
			
			pen.drawLine(x1, y1, x2, y2);
		}
		
		// right eyebrow
		for (int i = 0; i < 100; i++) {
			x1 = (int) (Math.random() * 90 + (xCenterFace + 30));
			y1 = yCenterFace - 70;
			
			if (Math.random() >= 0.5) {
				x2 = x1 + xStep;
			} else {
				x2 = x1 - xStep;
			}
			
			// calculate y2 such that strandLength = d = sqrt( (x2 - x1)^2 + (y2 - y1)^2 )
			y2 = y1 + (int) Math.sqrt(Math.pow(strandLength, 2) - Math.pow(x2 - x1, 2));
			
			pen.drawLine(x1, y1, x2, y2);
		}
		
		// @hair
		pen.setColor(hairColor);
		
		// beginning bounds for drawing hair
		int[] xbound = { xCenterFace - faceWidth / 2, xCenterFace + (xCenterFace / 2 - faceWidth / 3)};
		int[] ybound = { yCenterFace - faceHeight / 2 - 10, faceHeight / 6};
		
		x1 = 0;
		x2 = 0;
		y1 = 0;
		y2 = 0;		// coordinates of hair strands
		xStep = 3;							// how much hair strands vary in the x
		strandLength = 25;  				// how long each strand of hair should be
		
		// generate hair
		for (int i = 0; i < hairThickness; i++) {
			
			// randomly assign x1 and y1 values within appropriate bounds
			x1 = (int) (Math.random() * xbound[1] + xbound[0]);
			y1 = (int) (Math.random() * ybound[1] + ybound[0]);
			
			// widow's peak effect
			if (x1 < xCenterFace + 30 && x1 > xCenterFace - 30) {
				y1 += 20;
			}
			
			// shape hair-line
			for (int j = 1; j < 8; j++) {
				// region 1
				if (x1 < xCenterFace - j / 2 && x1 > xCenterFace - j) {
					y1 += j;
				}
				
				// region 2
				if (x1 < xCenterFace && x1 > xCenterFace - j / 2) {
					y1 += j;
				}
				
				// region 3
				if (x1 < xCenterFace + j / 2 && x1 > xCenterFace) {
					y1 += j;
				}
			}
			
			// wrap left side of hair to head
			for (int z = 1; z < 70; z++) {
				if (x1 < xCenterFace - 100 - z) {
					y1 += z / 15;
				}
			}
			
			// wrap right side of hair to head
			for (int z = 70; z > 1; z--) {
				if (x1 > xCenterFace + 100 + z) {
					y1 += z / 15;
				}
			}
			
			// add depth to widow's peak
			if (x1 > xCenterFace + 8 && x1 < xCenterFace + 90) {
				y1 += (xCenterFace - x1) / 4; 
			}
			
			if (x1 < xCenterFace - 8 && x1 > xCenterFace - 90) {
				y1 -= (xCenterFace - x1) / 4;
			}
			
			// hair strands randomly vary in direction
			if (Math.random() >= 0.5) {
				x2 = x1 + xStep;
			} else {
				x2 = x1 - xStep;
			}
			
			// calculate y2 such that strandLength = d = sqrt( (x2 - x1)^2 + (y2 - y1)^2 )
			y2 = y1 + (int) Math.sqrt(Math.pow(strandLength, 2) - Math.pow(x2 - x1, 2));
			
			// draw hair strand
			pen.drawLine(x1, y1, x2, y2);
		}
		
		// fill missing middle patch of hair
		xbound[0] = xCenterFace - faceWidth / 2 + 145;
		xbound[1] = 55;
		ybound[0] = yCenterFace - faceHeight / 2 - 20;
		ybound[1] = faceHeight / 6;
		
		for (int i = 0; i < hairThickness / 7; i++) {
			x1 = (int) (Math.random() * xbound[1] + xbound[0]);
			y1 = (int) (Math.random() * ybound[1] + ybound[0]);
			
			if (Math.random() >= 0.5) {
				x2 = x1 + xStep;
			} else {
				x2 = x1 - xStep;
			}
			
			y2 = y1 + (int) Math.sqrt(Math.pow(strandLength, 2) - Math.pow(x2 - x1, 2));
			pen.drawLine(x1, y1, x2, y2);
		}
		
		// flatten hair
		pen.setColor(this.getBackground()); 
		pen.fillArc(xCenterFace - 150, 75, 300, 25, 0, -180);
		pen.fillRect(xCenterFace - 150, 65, 300, 23);
		
		// @outlines
		
		// eye outline
		
		
		// DELETE THIS
		/*
		pen.setColor(Color.magenta);
		pen.drawLine(xCenterFace, 0, xCenterFace, HEIGHT);
		pen.drawLine(0, WIDTH / 2, WIDTH, HEIGHT / 2);*/
	}
	
}
