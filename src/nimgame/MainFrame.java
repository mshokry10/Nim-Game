package nimgame;
/**
 * @author Shokry
 * @version 1.00
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to Nim game!");
		welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		welcomeLabel.setBounds(90, 45, 266, 24);
		frame.getContentPane().add(welcomeLabel);
		
		JButton playNim = new JButton("Play Nim Game");
		playNim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NimGameFrame nimGame = new NimGameFrame();
				nimGame.setVisible(true);
			}
		});
		playNim.setBounds(152, 97, 138, 34);
		frame.getContentPane().add(playNim);
		
		JButton play100 = new JButton("Play The 100 Game");
		play100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				The100GameFrame the100Game = new The100GameFrame();
				the100Game.setVisible(true);
			}
		});
		play100.setBounds(142, 168, 166, 34);
		frame.getContentPane().add(play100);
	}
}
