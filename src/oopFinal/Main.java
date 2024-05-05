package oopFinal;

import java.io.File;
import java.io.IOException;

public class Main {
	
	private static final String FILE_NAME = "/Users/connordavis/Documents/GitHub/oopfinal/src/oopFinal/storage.txt";

    public static void main(String[] args) {
        // Create a file object for storage.txt
        File storageFile = new File(FILE_NAME);

        // Check if the file exists, create it if it doesn't
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
		
		HuffmanEncryptor he = new HuffmanEncryptor();
		MorseEncryptor me = new MorseEncryptor();
		CustomEncryptor ce = new CustomEncryptor();
		
//		MessageManager mm = new MessageManager();
		
		HuffmanMessage huff = new HuffmanMessage("huff", "text", he); 
		MorseMessage morse  = new MorseMessage("morse", "text", me); 
		CustomMessage custom = new CustomMessage("custom", "text", ce);
		
		MessageManager.storeEncryptedMessage(huff, storageFile);
		MessageManager.storeEncryptedMessage(morse, storageFile);
		MessageManager.storeEncryptedMessage(custom, storageFile);
		
		MessageManager.fetchMessages(storageFile);
	
	}
}
