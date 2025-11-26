package dev.jitesh.tictactoe;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGame implements ActionListener {
	
	private JFrame jf; 
	private JButton[][] jButtons = new JButton[3][3];
	private int turnCounter = 1;
	
	public TicTacToeGame() {
		
		// create game frame
		
		jf = new JFrame("Tick-Tac-Toe");
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(3, 3));
		
		// create buttons
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				jButtons[i][j] = new JButton();
				jButtons[i][j].addActionListener(this);
				Font f = new Font("Aerial", 1, 30);
				jButtons[i][j].setFont(f);
				jf.add(jButtons[i][j]);
			}
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
			checkActionResult();
		}
	}

	
	private void checkActionResult() {
		
		String winner = checkWinner();
		
		if (winner != null) {
			JOptionPane.showMessageDialog(jf, winner + " wins!");
			resetGame();
			return;
		}

		if(turnCounter > 9) {
			JOptionPane.showMessageDialog(jf, "Draw");
			resetGame();
		}

	}
	
	private void resetGame() {
	
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				jButtons[i][j].setText("");
				jButtons[i][j].setEnabled(true);
			}
		}
		
		this.turnCounter = 1;
	}

	private String checkWinner() {
		
		// check rows
		for (int i=0; i<3; i++)
		{		
			
			if (!jButtons[i][0].getText().isEmpty()
				&& jButtons[i][0].getText().equals(jButtons[i][1].getText())
				&& jButtons[i][1].getText().equals(jButtons[i][2].getText())) {
				
				return jButtons[i][0].getText();
			}
		}
		
		// check columns
		for (int j=0; j<3; j++)
		{		
			
			if (!jButtons[0][j].getText().isEmpty()
				&& jButtons[0][j].getText().equals(jButtons[1][j].getText())
				&& jButtons[1][j].getText().equals(jButtons[2][j].getText())) {
				
				return jButtons[0][j].getText();
			}
		}
		
		// check diagonal (top-left to bottom-right)
		if (!jButtons[0][0].getText().isEmpty()
				&& jButtons[0][0].getText().equals(jButtons[1][1].getText())
				&& jButtons[1][1].getText().equals(jButtons[2][2].getText())) {
				
				return jButtons[0][0].getText();
		}
		
		// check diagonal (top-right to bottom-left)
		if (!jButtons[0][2].getText().isEmpty()
				&& jButtons[0][2].getText().equals(jButtons[1][1].getText())
				&& jButtons[1][1].getText().equals(jButtons[2][0].getText())) {
				
				return jButtons[0][2].getText();
		}
		
		return null; // no winner found yet
	}
	
}
