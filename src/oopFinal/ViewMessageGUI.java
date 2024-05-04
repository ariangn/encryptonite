package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ViewMessageGUI extends JFrame {

	//private JPanel frame.getContentPane();
	private JFrame frame;

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
		frame = new JFrame();
		//frame.getContentPane() = new JPanel();
		//frame.getContentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame.getContentPane());
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("View Messages");
		lblTitle.setBounds(156, 6, 137, 16);
		frame.getContentPane().add(lblTitle);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 32, 15, 340);
		frame.getContentPane().add(scrollBar);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(16, 375, 117, 29);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				dispose();
				new MainGUI().setVisible(true);
			}
		});
		
		JTextArea scrollableArea = new JTextArea();
		scrollableArea.setBounds(16, 34, 401, 329);
		frame.getContentPane().add(scrollableArea);
		
		JScrollPane scroll = new JScrollPane(scrollableArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableArea.setText("ahhahah\nhahaha\nahhahah\nhahaha\nahhahah\nhahaha\nahhahah\nhahaha\na\na\na\na\n");
	}
<<<<<<< Updated upstream
=======
	
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
	
>>>>>>> Stashed changes
}
