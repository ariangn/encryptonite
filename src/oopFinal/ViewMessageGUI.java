package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewMessageGUI extends JFrame {

	private JPanel contentPane;
	private JPanel innerPanel;
	
	private ArrayList<JButton> messageButtons;

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
		
		messageButtons = new ArrayList<JButton>();
		
		innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		contentPane.add(innerPanel);
		
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
		
		JScrollPane scrollPane = new JScrollPane(innerPanel);
		scrollPane.setBounds(29, 73, 372, 256);
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnEncrypted = new JRadioButton("Encrypted");
		rdbtnEncrypted.setBounds(39, 44, 141, 23);
		contentPane.add(rdbtnEncrypted);
		
		JRadioButton rdbtnUnencrypted = new JRadioButton("Unencrypted");
		rdbtnUnencrypted.setBounds(240, 44, 141, 23);
		contentPane.add(rdbtnUnencrypted);
		
		showMessages();
	}
	
	//displays all messages within the scrollable area
	void showMessages() {
		
		//System.out.println("showing messages");
		
		ArrayList<Message> messages = MessageManager.getAllUnencryptedMessages();
		System.out.println("number of messages: " + messages.size());
		
		for (int i = 0; i < messages.size(); i++) {
			System.out.println(messages.get(i).getMessageText());
			JButton messageBtn = new JButton();
			messageBtn.setBounds(100, 100, 117, 29);
			messageBtn.setText(messages.get(i).getMessageText());
			innerPanel.add(messageBtn);
		}
		innerPanel.revalidate();
		contentPane.revalidate();
	}
}
