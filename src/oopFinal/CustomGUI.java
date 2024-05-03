package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.awt.Button;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CustomGUI extends JFrame {
	
	int listHeight = 0;

	private JPanel contentPane;
	private JTextField textNewFind;
	private JPanel innerPanel;
	
	private ArrayList<JTextField> findReplaceTexts = new ArrayList<JTextField>();

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
		
		innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		
		JLabel lblTitle = new JLabel("Create Custom Encryption");
		lblTitle.setBounds(133, 16, 170, 16);
		contentPane.add(lblTitle);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFindReplaceRow(innerPanel);
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
		
		JScrollPane scrollPane = new JScrollPane(innerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollPane.setBounds(44, 91, 374, 217);
		contentPane.add(scrollPane);
		
//		textNewFind = new JTextField();
//		textNewFind.setBounds(44, 105, 130, 29);
//		innerPanel.add(textNewFind);
//		textNewFind.setColumns(10);
		
	}
	
	void addFindReplaceRow(JPanel innerPanel) {
		textNewFind = new JTextField();
		System.out.println(findReplaceTexts.size());
		textNewFind.setBounds(44, 10 , 100, 30 );
		innerPanel.add(textNewFind);
		textNewFind.setColumns(10);
		innerPanel.repaint();
		contentPane.repaint();
		
		findReplaceTexts.add(textNewFind);
		//sortFindReplace(innerPanel);
		innerPanel.revalidate();
		innerPanel.repaint();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	void sortFindReplace(JPanel innerPanel) {
		for (int i = 0; i < findReplaceTexts.size(); i++) {
			findReplaceTexts.get(i).setBounds(44, 10 + (100 * i), 130, 30 + (100*i));
			findReplaceTexts.get(i).setText(Integer.toString(i));
		}
		
//		innerPanel.repaint();
//		contentPane.repaint();
	}
}
