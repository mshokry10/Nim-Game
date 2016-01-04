package nimgame;
/**
 * @author Shokry
 * @version 1.00
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;


public class NimGameFrame extends JFrame {
	private static final long serialVersionUID = 2L;
	
	private NimGame game;
	private JPanel contentPane;
	private JLabel[][] lblPiles;
	private JLabel lblPlayersTurn;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NimGameFrame frame = new NimGameFrame();
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
	public NimGameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlayersTurn = new JLabel("Player 1's turn!");
		lblPlayersTurn.setForeground(new Color(0, 150, 0));
		lblPlayersTurn.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPlayersTurn.setBounds(45, 250, 150, 20);
		contentPane.add(lblPlayersTurn);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "In Nim game two players "
						+ "take turns removing objects from distinct piles.\n"
						+ "On each turn, a player must remove at least one object,"
						+ " and may remove any number\nof objects provided they all "
						+ "come from the same heap. The last to remove an object loses.");
			}
		});
		btnHelp.setBounds(64, 297, 117, 25);
		contentPane.add(btnHelp);		
		addPiles(5);
		game = new NimGame(5, 5);
	}

	/**
	 * adds nPiles piles to the frame, each of them with a number of objects.
	 * @param nPiles the number of piles to add to the frame.
	 */
	private void addPiles(int nPiles) {
		lblPiles = new JLabel[nPiles][nPiles];
		int verSpace = 20, horSpace = 50;
		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j <= i; j++) {
				lblPiles[i][j] = new JLabel("");
				lblPiles[i][j].setIcon(new ImageIcon("Images/pileObject.png"));
				lblPiles[i][j].setBounds(horSpace, 25 + verSpace, 70, 70);
				contentPane.add(lblPiles[i][j]);
				verSpace += 67;
				
				final int column = i, limit = j;
				lblPiles[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						for (int k = 0; k <= limit; ++k) {
							if (lblPiles[column][k].isVisible()) {
								game.makeAMove(column, 1);
								if (game.gameOver()) {
									String winner;
									if (game.currentPlayer == The100Game.PLAYER1)
										winner = "Player 1";
									else
										winner = "Player 2";
									JOptionPane.showMessageDialog(null, winner + " wins!");
									game.resetGame(1, 100);
									game.resetGame(5, 5);
									resetFrame(5);
									return;
								}
								lblPiles[column][k].setVisible(false);
								lblPiles[column][k].dispatchEvent(e);
							}
						}
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
			}
			horSpace += 100;
			verSpace = 20;
		}
	}
	
	/**
	 * resets the frame to the intial state of the game.
	 * @param nPiles
	 */
	private void resetFrame(int nPiles) {
		for (int i = 0; i < nPiles; i++) {
			for (int j = 0; j <= i; j++) {
				lblPiles[i][j].setVisible(true);
			}
		}
	}

}
