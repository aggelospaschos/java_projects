import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener { 

	Random random = new Random(); // Random object for generating random numbers
	JFrame frame = new JFrame(); // JFrame for the game window
	JPanel title_panel = new JPanel(); // JPanel for the title
	JPanel button_panel = new JPanel(); // JPanel for the buttons
	JLabel textfield = new JLabel(); // JLabel for displaying text
	JButton[] buttons = new JButton[9]; // Array of JButtons for the game buttons
	boolean player1_turn; // Boolean to keep track of player's turn

	TicTacToe(){ // Constructor
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
		frame.setSize(800,800); // Set the size of the frame
		frame.getContentPane().setBackground(new Color(50,50,50)); // Set background color
		frame.setLayout(new BorderLayout()); // Set layout to BorderLayout
		frame.setVisible(true); // Set frame visible
		
		textfield.setBackground(new Color(25,25,25)); // Set text field background color
		textfield.setForeground(new Color(25,255,0)); // Set text color
		textfield.setFont(new Font("Ink Free",Font.BOLD,75)); // Set font
		textfield.setHorizontalAlignment(JLabel.CENTER); // Set text alignment
		textfield.setText("Tic-Tac-Toe"); // Set initial text
		textfield.setOpaque(true); // Make textfield opaque
		
		title_panel.setLayout(new BorderLayout()); // Set layout to BorderLayout
		title_panel.setBounds(0,0,800,100); // Set bounds for title panel
		
		button_panel.setLayout(new GridLayout(3,3)); // Set layout to GridLayout with 3 rows and 3 columns
		button_panel.setBackground(new Color(150,150,150)); // Set background color for button panel
		
		for(int i=0;i<9;i++) { // Loop to create buttons
			buttons[i] = new JButton(); // Create a new button
			button_panel.add(buttons[i]); // Add button to button panel
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120)); // Set font for button text
			buttons[i].setFocusable(false); // Set focusable to false to prevent focus
			buttons[i].addActionListener(this); // Add action listener to buttons
		}
		
		title_panel.add(textfield); // Add textfield to title panel
		frame.add(title_panel,BorderLayout.NORTH); // Add title panel to frame at the top
		frame.add(button_panel); // Add button panel to frame
		
		firstTurn(); // Call method to determine first turn
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Action performed method for button clicks
		
		for(int i=0;i<9;i++) { // Loop through buttons
			if(e.getSource()==buttons[i]) { // Check which button was clicked
				if(player1_turn) { // If it's player 1's turn
					if(buttons[i].getText()=="") { // Check if button is empty
						buttons[i].setForeground(new Color(255,0,0)); // Set text color to red
						buttons[i].setText("X"); // Set text to X
						player1_turn=false; // Switch turn to player 2
						textfield.setText("O turn"); // Update textfield
						check(); // Check for win
					}
				}
				else { // If it's player 2's turn
					if(buttons[i].getText()=="") { // Check if button is empty
						buttons[i].setForeground(new Color(0,0,255)); // Set text color to blue
						buttons[i].setText("O"); // Set text to O
						player1_turn=true; // Switch turn to player 1
						textfield.setText("X turn"); // Update textfield
						check(); // Check for win
					}
				}
			}			
		}
	}
	
	public void firstTurn() { // Method to determine first turn
		
		try { // Try block for handling InterruptedException
			Thread.sleep(2000); // Pause for 2 seconds
		} catch (InterruptedException e) { // Catch block for InterruptedException
			e.printStackTrace(); // Print stack trace if exception occurs
		}
		
		if(random.nextInt(2)==0) { // Randomly select first turn
			player1_turn=true; // Set player 1's turn
			textfield.setText("X turn"); // Update textfield
		}
		else {
			player1_turn=false; // Set player 2's turn
			textfield.setText("O turn"); // Update textfield
		}
	}
	
	public void check() { // Method to check for win conditions
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2); // Call xWins method with winning indices
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a,int b,int c) { // Method to handle X wins
		buttons[a].setBackground(Color.GREEN); // Set background color of winning buttons to green
		buttons[b].setBackground(Color.GREEN); // Set background color of winning buttons to green
		buttons[c].setBackground(Color.GREEN); // Set background color of winning buttons to green
		
		for(int i=0;i<9;i++) { // Loop through buttons
			buttons[i].setEnabled(false); // Disable all buttons
		}
		textfield.setText("X wins"); // Update textfield with winner
	}
	public void oWins(int a,int b,int c) { // Method to handle O wins
		buttons[a].setBackground(Color.GREEN); // Set background color of winning buttons to green
		buttons[b].setBackground(Color.GREEN); // Set background color of winning buttons to green
		buttons[c].setBackground(Color.GREEN); // Set background color of winning buttons to green
		
		for(int i=0;i<9;i++) { // Loop through buttons
			buttons[i].setEnabled(false); // Disable all buttons
		}
		textfield.setText("O wins"); // Update textfield with winner
	}
}
