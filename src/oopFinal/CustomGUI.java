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
import java.awt.Dimension;

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
	private JTextField textNewReplace;
	private JButton newMinus;
	private JPanel outerPanel;
	private JPanel innerPanel1;
	private JPanel innerPanel2;
	private JPanel innerPanel3;
	
	private ArrayList<ArrayList<JTextField>> findReplaceTexts = new ArrayList<ArrayList<JTextField>>();
	private ArrayList<JButton> minusButtons = new ArrayList<JButton>();

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
		
		
		outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.X_AXIS));
		innerPanel1 = new JPanel();
		innerPanel1.setLayout(new BoxLayout(innerPanel1, BoxLayout.Y_AXIS));
		innerPanel2 = new JPanel();
		innerPanel2.setLayout(new BoxLayout(innerPanel2, BoxLayout.Y_AXIS));
		innerPanel3 = new JPanel();
		innerPanel3.setLayout(new BoxLayout(innerPanel3, BoxLayout.Y_AXIS));
		outerPanel.add(innerPanel1);
		outerPanel.add(innerPanel2);
		outerPanel.add(innerPanel3);
		
		JLabel lblTitle = new JLabel("Create Custom Encryption");
		lblTitle.setBounds(133, 16, 170, 16);
		contentPane.add(lblTitle);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFindReplaceRow();
			}
		});
		btnPlus.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnPlus.setBounds(192, 314, 53, 53);
		contentPane.add(btnPlus);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(6, 387, 117, 29);
		contentPane.add(btnCancel);
		// go back to main gui
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				new MainGUI().setVisible(true);
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(160, 387, 117, 29);
		contentPane.add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(314, 387, 117, 29);
		contentPane.add(btnSave);
		// save data
		
		// go back to main gui
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
				contentPane.setVisible(false);
				dispose();
				new MainGUI().setVisible(true);
			}
		});
		
		JLabel lblReplace = new JLabel("Replace");
		lblReplace.setBounds(79, 69, 61, 16);
		contentPane.add(lblReplace);
		
		JLabel lblWith = new JLabel("With");
		lblWith.setBounds(242, 69, 61, 16);
		contentPane.add(lblWith);
		
		JScrollPane scrollPane = new JScrollPane(outerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollPane.setBounds(44, 91, 374, 217);
		contentPane.add(scrollPane);
		
		try {
			loadCustomEncryptor();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//add a Find-Replace row with no text
	private void addFindReplaceRow() {
		addFindReplaceRow("","");
	}
	
	private void addFindReplaceRow(String findText, String replaceText) {
		textNewFind = new JTextField();
		System.out.println(findReplaceTexts.size());
		textNewFind.setBounds(44, 10, 100, 30 );
		textNewFind.setText(findText);
		innerPanel1.add(textNewFind);
		textNewFind.setColumns(10);
		textNewFind.setMaximumSize(new Dimension(150,30));
		
		textNewReplace = new JTextField();
		textNewReplace.setBounds(144, 10 , 100, 30 );
		textNewReplace.setText(replaceText);
		innerPanel2.add(textNewReplace);
		textNewReplace.setColumns(10);
		textNewReplace.setMaximumSize(new Dimension(150,30));
		
		newMinus = new JButton("-");
		newMinus.setBounds(244, 387, 50, 29);
		innerPanel3.add(newMinus);
		newMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtractRow(e.getSource());
			}
		});
		
		ArrayList<JTextField> pair = new ArrayList<JTextField>();
		pair.add(textNewFind);
		pair.add(textNewReplace);
		
		
		findReplaceTexts.add(pair);
		minusButtons.add(newMinus);
		//sortFindReplace(innerPanel);
		innerPanel1.repaint();
		innerPanel1.revalidate();
		innerPanel2.repaint();
		innerPanel2.revalidate();
		innerPanel3.repaint();
		innerPanel3.revalidate();
		outerPanel.repaint();
		outerPanel.revalidate();
		contentPane.repaint();
	}
	
	private void subtractRow(Object btn) {
		int n;
		n = minusButtons.indexOf(btn);
				
		innerPanel1.remove(findReplaceTexts.get(n).get(0));
		innerPanel2.remove(findReplaceTexts.get(n).get(1));
		innerPanel3.remove(minusButtons.get(n));
		
		findReplaceTexts.remove(n);
		minusButtons.remove(n);
		
		
		innerPanel1.repaint();
		innerPanel1.revalidate();
		innerPanel2.repaint();
		innerPanel2.revalidate();
		innerPanel3.repaint();
		innerPanel3.revalidate();
		outerPanel.repaint();
		outerPanel.revalidate();
		contentPane.repaint();
	}
	
	private void clear() {
		int m = findReplaceTexts.size();
		
		findReplaceTexts.clear();
		minusButtons.clear();
		
		innerPanel1.removeAll();
		innerPanel2.removeAll();
		innerPanel3.removeAll();
		
		innerPanel1.revalidate();
		innerPanel2.revalidate();
		innerPanel3.revalidate();
		contentPane.repaint();
	}
	
	//this will store all the find-replace pairs entered by the user in a CustomEncryptor object
	//and make this object the current Custom Encryption method (global field currentEncryptor in CustomEncryptor)
	private void save() {
		
		CustomEncryptor custom = new CustomEncryptor();
		
		for (int i = 0; i < findReplaceTexts.size(); i++) {
			if ((findReplaceTexts.get(i).get(0).getText().length() > 0) && findReplaceTexts.get(i).get(1).getText().length() > 0)
				custom.addPair(findReplaceTexts.get(i).get(0).getText(), findReplaceTexts.get(i).get(1).getText());
		}
		
		CustomEncryptor.setCurrentEncryptor(custom);
	}
	
	//load the previous encryption method into the GUI
	private void loadCustomEncryptor() {
		
		CustomEncryptor currentEncryptor = CustomEncryptor.getCurrentEncryptor();
		
		System.out.println("length: " + currentEncryptor.getLength());
		
		//iterate through all find-replace pairs and add them 
		for (int i = 0; i < currentEncryptor.getLength(); i++) {
			addFindReplaceRow(currentEncryptor.getFindAt(i), currentEncryptor.getReplaceAt(i));
		}
		
	}

}
