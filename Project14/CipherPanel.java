package edu.mtc.egr281;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * CipherPanel.java
 * 
 * The main JPanel for the CipherFrame
 * Is capable of operating in different modes by changing the JLabel and
 * resulting method calls dependent on which cipher is being used
 */
public class CipherPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static enum CipherMode { SUBSTITUTION, TRANSPOSITION };
	
	private final Dimension DEFAULT_SIZE = new Dimension(400, 400);
	
	private CipherMode currentMode;
	
	private Font fntLargeFont;
	private JLabel lblPlainText;
	private JLabel lblCipherText;
	private JLabel lblNumTimes;
	private JLabel lblCurrentMode;
	private JTextField txtResults;
	private JTextField txtPlainText;
	private JTextField txtCipherText;
	private JTextField txtNumTimes;
	private JButton btnEncode;
	private JButton btnDecode;
	
	public CipherPanel() {
		super();
		
		this.setPreferredSize(DEFAULT_SIZE);
		this.setBackground(Color.magenta);
		this.setLayout(new GridBagLayout());

		this.currentMode = CipherMode.SUBSTITUTION;
		
		this.lblPlainText = new JLabel("Enter plaintext:", JLabel.RIGHT);
		this.lblCipherText = new JLabel("Enter ciphertext:", JLabel.RIGHT);
		this.lblNumTimes = new JLabel("Enter n value:", JLabel.RIGHT);
		
		this.fntLargeFont = new Font("largeFont", this.lblNumTimes.getFont().getStyle(), 30);
		this.lblCurrentMode = new JLabel(this.currentMode.toString(), JLabel.CENTER);
		this.lblCurrentMode.setFont(fntLargeFont);
		
		this.txtResults = new JTextField(25);
		this.txtResults.setHorizontalAlignment(JTextField.CENTER);
		this.txtResults.setEditable(false);
		
		this.txtPlainText = new JTextField(25);
		this.txtCipherText = new JTextField(25);
		this.txtNumTimes = new JTextField(25);
		
		this.btnEncode = new JButton("Encode");
		this.btnDecode = new JButton("Decode");
		
		this.btnEncode.setToolTipText("Click to Encrypt");
		this.btnDecode.setToolTipText("Click to Decrypt");
		
		this.btnEncode.addActionListener(this);
		this.btnDecode.addActionListener(this);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3,3,3,3);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(this.lblPlainText, gbc);
		
		gbc.ipadx = 150;
		gbc.gridx = 1;
		this.add(this.txtPlainText, gbc);
		
		gbc.ipadx = 0;
		gbc.gridx = 2;
		this.add(this.btnEncode, gbc);
		
		gbc.ipady = 50;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.lblCipherText, gbc);
		
		gbc.ipady = 0;
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(this.txtCipherText, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(this.btnDecode, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.lblNumTimes, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.txtNumTimes, gbc);
		
		gbc.ipady = 50;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(this.txtResults, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(this.lblCurrentMode, gbc);
	}// Ending bracket of constructor

	@Override
	public void actionPerformed(ActionEvent ae) {
		TranspositionCipher transCipher;
		SubstitutionCipher subCipher;
		
		String actionCommand = ae.getActionCommand();
		
		switch (this.currentMode) {
		case TRANSPOSITION:
			transCipher = new TranspositionCipher(Integer.parseInt(this.txtNumTimes.getText()));
			
			if (actionCommand.equals(this.btnEncode.getText())) {
				this.txtResults.setText( transCipher.encode(this.txtPlainText.getText()) );
			} else if (actionCommand.equals(this.btnDecode.getText())) {
				this.txtResults.setText( transCipher.decode(this.txtCipherText.getText()) );
			}// Ending bracket of if
			break;
			
		case SUBSTITUTION:
			subCipher = new SubstitutionCipher(Integer.parseInt(this.txtNumTimes.getText()));	
			
			if (actionCommand.equals(this.btnEncode.getText())) {
				this.txtResults.setText( subCipher.encode(this.txtPlainText.getText()) );
			} else if (actionCommand.equals(this.btnDecode.getText())) {
				this.txtResults.setText( subCipher.decode(this.txtCipherText.getText()) );
			}// Ending bracket of if
			break;
			default:
				break;
		}// Ending bracket of switch
			
	}// Ending bracket of method actionPerformed
	
	public void updateCipherMode(CipherMode newMode) {
		this.currentMode = newMode;
		this.lblCurrentMode.setText(this.currentMode.toString());
		
		switch (this.currentMode) {
		case SUBSTITUTION:
			this.lblNumTimes.setText("Enter shift width:");
			break;
			
		case TRANSPOSITION:
			this.lblNumTimes.setText("Enter times to transpose:");
			break;
			
			default:
				break;
		}// Ending bracket of switch
	}// Ending bracket of updateCipherMode
	
	// clear all JTextFields that belong to the panel
	public void clear() {
		this.txtResults.setText("");
		this.txtPlainText.setText("");
		this.txtCipherText.setText("");
		this.txtNumTimes.setText("");
	}// Ending bracket of method clear
}// Ending bracket of class CipherPanel
