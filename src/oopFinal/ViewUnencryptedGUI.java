package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewUnencryptedGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUnencryptedGUI frame = new ViewUnencryptedGUI();
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
	public ViewUnencryptedGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 50, 46, 16);
		contentPane.add(lblName);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 97, 349, 212);
		contentPane.add(textArea);
		
		nameText = new JTextField();
		nameText.setBounds(98, 45, 297, 26);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JButton btnEncrypt = new JButton("Encrypt! :)");
		btnEncrypt.setBounds(163, 321, 117, 29);
		contentPane.add(btnEncrypt);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(22, 373, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(163, 373, 117, 29);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(299, 373, 117, 29);
		contentPane.add(btnDelete);
	}

}
