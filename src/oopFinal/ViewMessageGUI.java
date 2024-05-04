package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
		innerPanel.setBounds(29, 73, 372, 256);
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
		
		ButtonGroup viewSelect = new ButtonGroup();
		
		JRadioButton rdbtnEncrypted = new JRadioButton("Encrypted");
		rdbtnEncrypted.setBounds(240, 44, 141, 23);
		contentPane.add(rdbtnEncrypted);
		viewSelect.add(rdbtnEncrypted);
		rdbtnEncrypted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerPanel.removeAll();
				innerPanel.revalidate();
				showEncryptedMessages();
			}
		});
		
		
		
		JRadioButton rdbtnUnencrypted = new JRadioButton("Unencrypted");
		rdbtnUnencrypted.setBounds(39, 44, 141, 23);
		contentPane.add(rdbtnUnencrypted);
		rdbtnUnencrypted.setSelected(true);
		viewSelect.add(rdbtnUnencrypted);
		rdbtnUnencrypted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerPanel.removeAll();
				innerPanel.revalidate();
				showUnencryptedMessages();
			}
		});
		
		showUnencryptedMessages();
	}
	
	//displays all unencrpted messages within the scrollable area
	void showUnencryptedMessages() {
		
		//clear everything from the content pane
		innerPanel.removeAll();
		innerPanel.revalidate();
		messageButtons.clear();
		
		ArrayList<UnencryptedMessage> messages = MessageManager.getAllUnencryptedMessages();

		System.out.println("number of messages: " + messages.size());
		
		//loop through unencrypted messages and add them all as buttons
		for (int i = 0; i < messages.size(); i++) {
			JButton messageBtn = new JButton();
			messageBtn.setBounds(100, 100, 117, 29);
			messageBtn.setText(messages.get(i).getName());
			//add to ArrayList
			messageButtons.add(messageBtn);
			innerPanel.add(messageBtn);
			
			//action listener for if it is clicked, open up encryption GUI
			messageBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.setVisible(false);
					dispose();
					
					int index = messageButtons.indexOf((JButton)(e.getSource()));
					UnencryptedMessage m = messages.get(index);
					
					//open the encryptioGUI and pass in the selected message as an argument
					
					new EncryptionGUI(m).setVisible(true);
				}
			});
		}
		innerPanel.revalidate();
		innerPanel.repaint();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	void showEncryptedMessages() {
		
		//clear everything from the content pane
		innerPanel.removeAll();
		messageButtons.clear();
		
		ArrayList<EncryptedMessage> messages = MessageManager.getAllEncryptedMessages();

		System.out.println("number of encrypted messages: " + messages.size());
		
		//loop through encrypted messages and add them all as buttons
		for (int i = 0; i < messages.size(); i++) {
			JButton messageBtn = new JButton();
			messageBtn.setBounds(100, 100, 117, 29);
			messageBtn.setText(messages.get(i).getName());
			//add to ArrayList
			messageButtons.add(messageBtn);
			//add to panel
			innerPanel.add(messageBtn);
			messageBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.setVisible(false);
					dispose();
					
					int index = messageButtons.indexOf((JButton)(e.getSource()));
					EncryptedMessage m = messages.get(index);
					//System.out.println("message at: " + index);
					
					//open the encryptioGUI and pass in the selected message as an argument
					
					new ViewEncryptedGUI(m, m.getEncryptorUsed(), index).setVisible(true);
				}
			});
		}
		innerPanel.revalidate();
		innerPanel.repaint();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
}
