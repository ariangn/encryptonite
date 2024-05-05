package oopFinal;

<<<<<<< Updated upstream
public class Main {
	
	public static void main(String[] args) {
		
		MessageManager m = new MessageManager();
		m.getAllEncryptedMessages();
		m.getAllUnencryptedMessages();
		
	}
=======
import java.io.File;
>>>>>>> Stashed changes

public class Main {
	
	public static void main(String[] args) {
		
		HuffmanEncryptor he = new HuffmanEncryptor();
		
		File storageFile = new File("storage.txt");
		
		MessageManager mm = new MessageManager();
		
		HuffmanMessage hm = new HuffmanMessage("name", "text", he); 
		mm.fetchMessages(storageFile);
	
	}
}
