package oopFinal;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGUI extends JFrame {

    private JFrame frame;
    private static final String FILE_NAME = "/Users/connordavis/Documents/GitHub/oopfinal/src/oopFinal/storage.txt";

    public static void main(String[] args) {

        File storageFile = new File(FILE_NAME);

        if (!storageFile.exists()) {
            try {
                storageFile.createNewFile();
                System.out.println("File created successfully: " + storageFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to create file: " + e.getMessage());
                e.printStackTrace();
                return;
            }
        }

        MessageManager.fetchMessages(storageFile);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI frame = new MainGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        frame = new JFrame();
        setContentPane(frame.getContentPane());
        frame.getContentPane().setLayout(null);

        JButton btnSaveAndQuit = new JButton("Save and Quit");
        btnSaveAndQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File storageFile = new File(FILE_NAME);
                MessageManager.rewriteMessagesToFile(storageFile); // Save messages to file
                dispose(); // Close the application
            }
        });
        btnSaveAndQuit.setBounds(133, 236, 188, 29);
        frame.getContentPane().add(btnSaveAndQuit);

        JButton btnViewMessages = new JButton("View Messages");
        btnViewMessages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dispose();
                new ViewMessageGUI().setVisible(true);
            }
        });
        btnViewMessages.setBounds(133, 130, 188, 29);
        frame.getContentPane().add(btnViewMessages);

        JButton btnCreateMessage_1 = new JButton("Create Message");
        btnCreateMessage_1.setBounds(133, 77, 188, 29);
        frame.getContentPane().add(btnCreateMessage_1);
        btnCreateMessage_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dispose();
                new CreateMessageGUI().setVisible(true);
            }
        });

        JButton btnCreateCustomEncryption = new JButton("Modify Custom Encryption");
        btnCreateCustomEncryption.setBounds(133, 183, 188, 29);
        frame.getContentPane().add(btnCreateCustomEncryption);
        btnCreateCustomEncryption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dispose();
                new CustomGUI().setVisible(true);
            }
        });

        JLabel lblWelcome = new JLabel("Welcome to Encrypt-o-nite!");
        lblWelcome.setBounds(133, 25, 188, 16);
        frame.getContentPane().add(lblWelcome);

    }

}
