package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMessageGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMessageGUI frame = new ViewMessageGUI();
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
	public ViewMessageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				new MainGUI().setVisible(true);
			}
		});
		btnBack.setBounds(6, 354, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTitle = new JLabel("View Messages");
		lblTitle.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 15));
		lblTitle.setBounds(161, 6, 147, 16);
		contentPane.add(lblTitle);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(29, 73, 372, 256);
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnEncrypted = new JRadioButton("Encrypted");
		rdbtnEncrypted.setBounds(39, 44, 141, 23);
		contentPane.add(rdbtnEncrypted);
		
		JRadioButton rdbtnUnencrypted = new JRadioButton("Unencrypted");
		rdbtnUnencrypted.setBounds(240, 44, 141, 23);
		contentPane.add(rdbtnUnencrypted);
	}
}
