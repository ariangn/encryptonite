package oopFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ViewMessageGUI extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblTitle = new JLabel("View Messages");
		lblTitle.setBounds(156, 6, 137, 16);
		contentPane.add(lblTitle);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 32, 15, 340);
		contentPane.add(scrollBar);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(16, 375, 117, 29);
		contentPane.add(btnBack);
		
		JTextArea scrollableArea = new JTextArea();
		scrollableArea.setBounds(16, 34, 401, 329);
		contentPane.add(scrollableArea);
		
		JScrollPane scroll = new JScrollPane(scrollableArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableArea.setText("ahhahah\nhahaha\nahhahah\nhahaha\nahhahah\nhahaha\nahhahah\nhahaha\na\na\na\na\n");
	}
}
