package nimgame;
/**
 * @author Shokry
 * @version 1.00
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class The100GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private The100Game game;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblScore;
	private JLabel lblPlayersTurn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					The100GameFrame frame = new The100GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public The100GameFrame() {
		game = new The100Game();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCurrentScore = new JLabel("Current Score: ");
		lblCurrentScore.setFont(new Font("Dialog", Font.BOLD, 17));
		lblCurrentScore.setBounds(45, 37, 143, 20);
		contentPane.add(lblCurrentScore);

		lblScore = new JLabel("0");
		lblScore.setFont(new Font("Dialog", Font.BOLD, 17));
		lblScore.setBounds(227, 40, 70, 15);
		contentPane.add(lblScore);

		lblPlayersTurn = new JLabel("Player 1's turn!");
		lblPlayersTurn.setForeground(new Color(0, 150, 0));
		lblPlayersTurn.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPlayersTurn.setBounds(45, 79, 150, 20);
		contentPane.add(lblPlayersTurn);

		JLabel lblPickANumber = new JLabel("Pick a number:");
		lblPickANumber.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPickANumber.setBounds(45, 149, 123, 18);
		contentPane.add(lblPickANumber);

		textField = new JTextField();
		textField.setBounds(227, 149, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				int toRemove = 0;
				try {
					toRemove = Integer.parseInt(text);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,
							"Input is not a valid number.");
					textField.setText("");
					return;
				}
				if (!game.validInput(toRemove)) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					textField.setText("");
					return;
				}
				game.piles[0].remove(toRemove);
				if (game.gameOver()) {
					String winner;
					if (game.currentPlayer == The100Game.PLAYER1)
						winner = "Player 1";
					else
						winner = "Player 2";
					JOptionPane.showMessageDialog(null, winner + " wins!");
					game.resetGame(1, 100);
					lblScore.setText("0");
					textField.setText("");
					return;
				}
				lblScore.setText(String.valueOf(100 - game.piles[0].size()));
				textField.setText("");
				if (game.currentPlayer == The100Game.PLAYER1) {
					game.currentPlayer = The100Game.PLAYER2;
					lblPlayersTurn.setText("Player 2's turn!");
					lblPlayersTurn.setForeground(new Color(150, 0, 0));
				} else {
					game.currentPlayer = The100Game.PLAYER1;
					lblPlayersTurn.setText("Player 1's turn!");
					lblPlayersTurn.setForeground(new Color(0, 150, 0));
				}
			}
		});
		btnPlay.setBounds(45, 213, 117, 25);
		contentPane.add(btnPlay);

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "In the \"100 game\", two "
						+ "players start from 0 and alternatively add a number "
						+ "from 1 to 10 to the sum. The player who reaches 100 wins.");
			}
		});
		btnHelp.setBounds(255, 213, 117, 25);
		contentPane.add(btnHelp);
	}
}
