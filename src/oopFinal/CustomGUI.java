package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomGUI extends JFrame {
	
	int listHeight = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomGUI frame = new CustomGUI();
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
	public CustomGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Create Custom Encryption");
		lblTitle.setBounds(133, 16, 170, 16);
		contentPane.add(lblTitle);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(35, 91, 374, 217);
		contentPane.add(scrollPane);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPlus.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnPlus.setBounds(192, 314, 53, 53);
		contentPane.add(btnPlus);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(6, 387, 117, 29);
		contentPane.add(btnCancel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(160, 387, 117, 29);
		contentPane.add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(314, 387, 117, 29);
		contentPane.add(btnSave);
		
		JLabel lblReplace = new JLabel("Replace");
		lblReplace.setBounds(79, 69, 61, 16);
		contentPane.add(lblReplace);
		
		JLabel lblWith = new JLabel("With");
		lblWith.setBounds(242, 69, 61, 16);
		contentPane.add(lblWith);
	}
	
	void addFindReplaceRow() {
		contentPane.add
	}
}
