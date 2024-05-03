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
				addFindReplaceRow(innerPanel1, innerPanel2);
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
		
		JScrollPane scrollPane = new JScrollPane(outerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollPane.setBounds(44, 91, 374, 217);
		contentPane.add(scrollPane);
		
//		textNewFind = new JTextField();
//		textNewFind.setBounds(44, 105, 130, 29);
//		innerPanel.add(textNewFind);
//		textNewFind.setColumns(10);
		
	}
	
	void addFindReplaceRow(JPanel innerPanel1, JPanel innerPanel2) {
		textNewFind = new JTextField();
		System.out.println(findReplaceTexts.size());
		textNewFind.setBounds(44, 10 , 100, 30 );
		innerPanel1.add(textNewFind);
		textNewFind.setColumns(10);
		
		textNewReplace = new JTextField();
		textNewReplace.setBounds(144, 10 , 100, 30 );
		innerPanel2.add(textNewReplace);
		textNewReplace.setColumns(10);
		
		newMinus = new JButton("-");
		newMinus.setBounds(244, 387, 117, 29);
		innerPanel3.add(newMinus);
		newMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtractRow(findReplaceTexts.size()-1);
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
	
	void sortFindReplace(JPanel innerPanel) {
		for (int i = 0; i < findReplaceTexts.size(); i++) {
			findReplaceTexts.get(i).get(0).setBounds(44, 10 + (100 * i), 130, 30 + (100*i));
			findReplaceTexts.get(i).get(1).setBounds(44, 10 + (100 * i), 130, 30 + (100*i));
			//findReplaceTexts.get(i).setText(Integer.toString(i));
		}
		
//		innerPanel.repaint();
//		contentPane.repaint();
	}
	
	void subtractRow(int n) {
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
	
	void clear() {
		
	}
}
