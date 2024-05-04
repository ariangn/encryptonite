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

public class EncryptionGUI extends JFrame {

	private JPanel contentPane;
	
	//messageShown is the current message that is being displayed in this menu
	private Message messageShown;

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
		
		JRadioButton rdbtnOriginal = new JRadioButton("Original");
		rdbtnOriginal.setBounds(29, 279, 86, 23);
		rdbtnOriginal.setSelected(true);
		contentPane.add(rdbtnOriginal);
		encryptSelect.add(rdbtnOriginal);
		
		JRadioButton rdbtnHuffman = new JRadioButton("Huffman");
		rdbtnHuffman.setBounds(108, 279, 96, 23);
		contentPane.add(rdbtnHuffman);
		encryptSelect.add(rdbtnHuffman);
		
		JRadioButton rdbtnMorse = new JRadioButton("Morse Code");
		rdbtnMorse.setBounds(198, 279, 116, 23);
		contentPane.add(rdbtnMorse);
		encryptSelect.add(rdbtnMorse);
		
		JRadioButton rdbtnCustom = new JRadioButton("Custom");
		rdbtnCustom.setBounds(310, 279, 96, 23);
		contentPane.add(rdbtnCustom);
		encryptSelect.add(rdbtnCustom);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 351, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnEncrypt = new JButton("Encrypt!");
		btnEncrypt.setBounds(153, 314, 117, 29);
		contentPane.add(btnEncrypt);
		
		JLabel lblPreview = new JLabel("Preview");
		lblPreview.setBounds(189, 235, 61, 16);
		contentPane.add(lblPreview);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(53, 45, 350, 175);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(52, 53, 350, 175);
		contentPane.add(scrollPane);
		
		showOriginalMessage(textArea);
		
		
	}
	
	void showOriginalMessage(JTextArea textArea) {
		textArea.setText(messageShown.getMessageText());
	}
}
