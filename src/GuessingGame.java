import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuessingGame extends JFrame {
	private JTextArea guess; // for user guess
	private JLabel lblFeedBack; //feedback field
	private int theNumber;
	
	
	public void checkGuess() {
		String guessText = guess.getText();
		String message = "";
		
		int intGuess = Integer.parseInt(guessText);
		
		if(intGuess < theNumber) {
			message = intGuess + " was too low";
			lblFeedBack.setText(message);
		}
		else if(intGuess > theNumber) {
			message = intGuess + " was too high";
			lblFeedBack.setText(message);
			
		}
		
		else {
			message = intGuess + " Was right, you win!  Let's play again!";
			lblFeedBack.setText(message);
			newGame();
		}
		
		guess.requestFocus();
		guess.selectAll();
		
	}
	
	public void newGame() { //new random number
		theNumber = (int)(Math.random()*100+1);
	}
	
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblJoshsGuessingGame = new JLabel("Josh's Guessing Game (hi)");
		lblJoshsGuessingGame.setBounds(0, 31, 783, 44);
		lblJoshsGuessingGame.setFont(new Font("Arial", Font.BOLD, 20));
		lblJoshsGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblJoshsGuessingGame, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Pick a number between 1 and 100");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(300, 175, 182, 14);
		getContentPane().add(lblNewLabel);
		
		guess = new JTextArea();
		guess.setBounds(365, 211, 52, 22);
		getContentPane().add(guess);
		
		JButton btnGuess = new JButton("Guess");
		guess.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				 if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
				        checkGuess();
				        
				    }
			}
		});
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(348, 244, 89, 23);
		getContentPane().add(btnGuess);
		
		lblFeedBack = new JLabel("Enter a number and click guess");
		lblFeedBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedBack.setBounds(170, 267, 442, 74);
		getContentPane().add(lblFeedBack);
	}

	public static void main(String[] args) {
		
		GuessingGame gg = new GuessingGame();
		gg.newGame();
		gg.setSize(new Dimension(800,600));
		gg.setVisible(true);
		
	}
}
