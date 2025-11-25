package dev.jitesh.tictactoe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToeGame implements ActionListener {
	
	private JFrame jf; 
	private JButton[] jButtons = new JButton[9];
	private int turnCounter = 1;
	
	public TicTacToeGame() {
		
		// create game frame
		
		jf = new JFrame("Tick-Tac-Toe");
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(3, 3));
		
		// create buttons
		
		for(int i=0; i<9; i++) {
			jButtons[i] = new JButton();
			jButtons[i].addActionListener(this);
			Font f = new Font("Aerial", 1, 30);
			jButtons[i].setFont(f);
			jf.add(jButtons[i]);
		}
		
		
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TicTacToeGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton jb = (JButton) e.getSource();
		
		if (turnCounter <= 9 && jb.isEnabled()) {
			
			if (turnCounter % 2 == 0) {
				jb.setText("0");
			} else {
				jb.setText("X");
			}
			
			jb.setEnabled(false);
			this.turnCounter++;
		}
	}
}
