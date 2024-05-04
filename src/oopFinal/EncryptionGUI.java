package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptionGUI extends JFrame {

	private JPanel contentPane;
	
	//messageShown is the current message that is being displayed in this menu
	private Message messageShown;
	
	//an object of either HuffmanEncryptor, CustomEncryptor, or MorseEncryptor
	//this will change when you click on the radial buttons
	private Encryptor currentEncryptor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptionGUI frame = new EncryptionGUI(new Message());
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
	public EncryptionGUI(Message m) {
		
		messageShown = m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Encrypt Text");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblTitle.setBounds(166, 6, 116, 35);
		contentPane.add(lblTitle);
		
		ButtonGroup encryptSelect = new ButtonGroup();
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 351, 117, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				new ViewMessageGUI().setVisible(true);
			}
		});
		
		JButton btnEncrypt = new JButton("Encrypt!");
		btnEncrypt.setBounds(153, 314, 117, 29);
		contentPane.add(btnEncrypt);
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encryptMessage();
				contentPane.setVisible(false);
				dispose();
				new ViewMessageGUI().setVisible(true);
			}
		});
		
		
		JLabel lblPreview = new JLabel("Preview");
		lblPreview.setBounds(189, 235, 61, 16);
		contentPane.add(lblPreview);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(53, 45, 350, 175);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(52, 53, 350, 175);
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnOriginal = new JRadioButton("Original");
		rdbtnOriginal.setBounds(29, 279, 86, 23);
		rdbtnOriginal.setSelected(true);
		contentPane.add(rdbtnOriginal);
		encryptSelect.add(rdbtnOriginal);
		rdbtnOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOriginalMessage(textArea);
			}
		});
		
		JRadioButton rdbtnHuffman = new JRadioButton("Huffman");
		rdbtnHuffman.setBounds(108, 279, 96, 23);
		contentPane.add(rdbtnHuffman);
		encryptSelect.add(rdbtnHuffman);
		rdbtnHuffman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentEncryptor = new HuffmanEncryptor();
				showEncryptedMessage(textArea);
			}
		});
		
		JRadioButton rdbtnMorse = new JRadioButton("Morse Code");
		rdbtnMorse.setBounds(198, 279, 116, 23);
		contentPane.add(rdbtnMorse);
		encryptSelect.add(rdbtnMorse);
		rdbtnMorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentEncryptor = new MorseEncryptor();
				showEncryptedMessage(textArea);
			}
		});
		
		JRadioButton rdbtnCustom = new JRadioButton("Custom");
		rdbtnCustom.setBounds(310, 279, 96, 23);
		contentPane.add(rdbtnCustom);
		encryptSelect.add(rdbtnCustom);
		rdbtnCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentEncryptor = new CustomEncryptor();
				showEncryptedMessage(textArea);
			}
		});
		
		showOriginalMessage(textArea);
		
		
	}
	
	void showOriginalMessage(JTextArea textArea) {
		textArea.setText(messageShown.getMessageText());
		
		//ALL A TEST, REMOVE LATER
		
//		HuffmanEncryptor h = new HuffmanEncryptor();
//		Message m = new Message("hi");
//		System.out.println("test:" + h.encrypt(m));
	}
	
	//when you click on the radial buttons Huffman, Morse, or Custom
	void showEncryptedMessage(JTextArea textArea) {
		EncryptedMessage encrypted;
		
		encrypted = currentEncryptor.encrypt(messageShown);
		textArea.setText(encrypted.getMessageText());
	}
	
	//create a new encrypted message
	void encryptMessage() {
		EncryptedMessage encrypted;
		
		encrypted = currentEncryptor.encrypt(messageShown);
		MessageManager.addEncryptedMessage(encrypted);
	}
}
