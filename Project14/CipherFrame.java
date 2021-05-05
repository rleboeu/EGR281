package edu.mtc.egr281;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class CipherFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final String WINDOW_TITLE = "Project 14 - Ciphers";
	private final Dimension DEFAULT_SIZE = new Dimension(600, 600);

	private Container contentPane;
	private JLabel lblButton;
	private ButtonGroup grpRadioBtn;
	private JRadioButton rbtnTrans;
	private JRadioButton rbtnSub;
	private JButton btnClear;
	
	private CipherPanel pnlCipher;
	
	public CipherFrame() {
		super();
		
		this.setTitle(WINDOW_TITLE);
		
		this.setPreferredSize(DEFAULT_SIZE);
		this.setMaximumSize(DEFAULT_SIZE);
		this.setMinimumSize(DEFAULT_SIZE);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new FlowLayout());
		this.contentPane.setBackground(new Color(250, 231, 85));
		
		this.lblButton = new JLabel("MODE:");
		this.contentPane.add(this.lblButton);
		
		this.grpRadioBtn = new ButtonGroup();
		this.rbtnSub = new JRadioButton("Substitution");
		this.rbtnSub.setSelected(true);
		this.rbtnTrans = new JRadioButton("Transposition");
		this.rbtnTrans.setSelected(false);
		
		this.rbtnSub.addActionListener(this);
		this.rbtnTrans.addActionListener(this);
		
		this.rbtnSub.setBackground(this.contentPane.getBackground());
		this.rbtnTrans.setBackground(this.contentPane.getBackground());
		
		this.grpRadioBtn.add(this.rbtnSub);
		this.grpRadioBtn.add(this.rbtnTrans);
		
		this.contentPane.add(this.rbtnSub);
		this.contentPane.add(this.rbtnTrans);
		
		this.btnClear = new JButton("Clear");
		this.btnClear.addActionListener(this);
		
		this.contentPane.add(this.btnClear);

		this.pnlCipher = new CipherPanel();
		this.pnlCipher.setBackground(this.contentPane.getBackground());
		this.pnlCipher.updateCipherMode(CipherPanel.CipherMode.SUBSTITUTION);
		this.contentPane.add(this.pnlCipher);
		
		this.pack();
	}// Ending bracket of constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals(this.btnClear.getText())) {
			this.pnlCipher.clear();
		} else if (actionCommand.equals(this.rbtnSub.getText())) {
			if (this.rbtnSub.isSelected()) {
				this.pnlCipher.updateCipherMode(CipherPanel.CipherMode.SUBSTITUTION);
			}// Ending bracket of if
		} else if (actionCommand.equals(this.rbtnTrans.getText())) {
			if (this.rbtnTrans.isSelected()) {
				this.pnlCipher.updateCipherMode(CipherPanel.CipherMode.TRANSPOSITION);
			}// Ending bracket of if
		}// Ending bracket of if

	}// Ending bracket of method actionPerformed
	
}// Ending bracket of class CipherFrame
