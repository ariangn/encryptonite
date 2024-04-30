package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewMessages = new JButton("View Messages");
		btnViewMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewMessages.setBounds(133, 130, 188, 29);
		contentPane.add(btnViewMessages);
		
		JButton btnCreateMessage_1 = new JButton("Create Message");
		btnCreateMessage_1.setBounds(133, 77, 188, 29);
		contentPane.add(btnCreateMessage_1);
		
		JButton btnCreateCustomEncryption = new JButton("Create Custom Encryption");
		btnCreateCustomEncryption.setBounds(133, 183, 188, 29);
		contentPane.add(btnCreateCustomEncryption);
		
		JLabel lblWelcome = new JLabel("Welcome to Encrypt-o-nite!");
		lblWelcome.setBounds(133, 25, 188, 16);
		contentPane.add(lblWelcome);
	}
}
