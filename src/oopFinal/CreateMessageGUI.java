package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CreateMessageGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textMessageName;
	private JTextArea textMessage;
	private JButton btnEncrypt;
	private JButton btnBack;
	private JButton btnCreate;
	private JButton btnCreater;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMessageGUI frame = new CreateMessageGUI();
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
	public CreateMessageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMessageName = new JTextField();
		textMessageName.setBounds(76, 50, 306, 26);
		contentPane.add(textMessageName);
		textMessageName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 53, 53, 21);
		contentPane.add(lblName);
		
		JLabel lblWriteTextHere = new JLabel("Write Your Message Here");
		lblWriteTextHere.setBounds(141, 88, 162, 16);
		contentPane.add(lblWriteTextHere);
		
		textMessage = new JTextArea();
		textMessage.setBounds(47, 116, 367, 177);
		contentPane.add(textMessage);
		textMessage.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(textMessage);
		scrollPane.setBounds(47, 116, 367, 177);
		contentPane.add(scrollPane);
		
		JLabel lblCreateMessage = new JLabel("Create a Message");
		lblCreateMessage.setBounds(165, 22, 123, 16);
		contentPane.add(lblCreateMessage);
		
		btnEncrypt = new JButton("Encrypt!");
		btnEncrypt.setBounds(171, 310, 117, 29);
		contentPane.add(btnEncrypt);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(34, 366, 117, 29);
		contentPane.add(btnBack);
		
		btnCreate = new JButton("Reset");
		btnCreate.setBounds(171, 366, 117, 29);
		contentPane.add(btnCreate);
		
		btnCreater = new JButton("Create");
		btnCreater.setBounds(300, 366, 117, 29);
		contentPane.add(btnCreater);
	}
}
