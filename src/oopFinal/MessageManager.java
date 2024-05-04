package oopFinal;
<<<<<<< Updated upstream

<<<<<<< Updated upstream
public class MessageManager {

=======
=======
>>>>>>> Stashed changes
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
public class MessageManager { //hi
	
	private static ArrayList<UnencryptedMessage> unencryptedMessages = new ArrayList<UnencryptedMessage>();
	private static ArrayList<EncryptedMessage> encryptedMessages = new ArrayList<EncryptedMessage>();
	
	public static ArrayList<UnencryptedMessage> getAllUnencryptedMessages() {
		return unencryptedMessages;
	}
	
	public static ArrayList<EncryptedMessage> getAllEncryptedMessages() {
		return encryptedMessages;
	}
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	public static void addUnencryptedMessage(UnencryptedMessage m) {
		unencryptedMessages.add(m);
	}
	
	public static void addEncryptedMessage(EncryptedMessage m) {
		encryptedMessages.add(m);
	}
	
	public static void removeUnencryptedMessage(int index) {
		unencryptedMessages.remove(index);
	}
	
	public static void removeEncryptedMessage(int index) {
		encryptedMessages.remove(index);
	}
	
	//------------------------------------------------------------------------//
	
	public static void storeUnencryptedMessage(UnencryptedMessage m) {
<<<<<<< Updated upstream
        // Add the message to the list
        addUnencryptedMessage(m);

        // Store the message in the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", true))) {
            writer.write("Unencrypted Message\n");
            writer.write("Name: " + m.getName() + "\n");
            writer.write("Message: " + m.getMessageText() + "\n");
            writer.write("-------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void wipeUnencryptedMessage(UnencryptedMessage m) {
        // Remove the message from the list
        unencryptedMessages.remove(m);

        // Rewrite the remaining messages to the text file
        rewriteMessagesToFile();
    }

    public static void storeEncryptedMessage(EncryptedMessage m) {
        // Add the message to the list
        addEncryptedMessage(m);

        // Store the message in the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", true))) {
            writer.write("Encrypted Message\n");
            writer.write("Name: " + m.getName() + "\n");
            writer.write("Message: " + m.getMessageText() + "\n");
            writer.write("-------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void wipeEncryptedMessage(EncryptedMessage m) {
        // Remove the message from the list
        encryptedMessages.remove(m);

        // Rewrite the remaining messages to the text file
        rewriteMessagesToFile();
    }

    // Helper method to rewrite all messages to the text file
    private static void rewriteMessagesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", false))) {
            for (UnencryptedMessage m : unencryptedMessages) {
                writer.write("Unencrypted Message\n");
                writer.write("Name: " + m.getName() + "\n");
                writer.write("Message: " + m.getMessageText() + "\n");
                writer.write("-------------\n");
            }
            for (EncryptedMessage m : encryptedMessages) {
                writer.write("Encrypted Message\n");
                writer.write("Name: " + m.getName() + "\n");
                writer.write("Message: " + m.getMessageText() + "\n");
                writer.write("-------------\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
>>>>>>> Stashed changes
=======
       // Add the message to the list
       addUnencryptedMessage(m);
       // Store the message in the text file
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", true))) {
           writer.write("Unencrypted Message\n");
           writer.write("Name: " + m.getName() + "\n");
           writer.write("Message: " + m.getMessageText() + "\n");
           writer.write("-------------\n");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public static void wipeUnencryptedMessage(UnencryptedMessage m) {
       // Remove the message from the list
       unencryptedMessages.remove(m);
       // Rewrite the remaining messages to the text file
       rewriteMessagesToFile();
   }
   public static void storeEncryptedMessage(EncryptedMessage m) {
       // Add the message to the list
       addEncryptedMessage(m);
       // Store the message in the text file
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", true))) {
           writer.write("Encrypted Message\n");
           writer.write("Name: " + m.getName() + "\n");
           writer.write("Message: " + m.getMessageText() + "\n");
           writer.write("-------------\n");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   public static void wipeEncryptedMessage(EncryptedMessage m) {
       // Remove the message from the list
       encryptedMessages.remove(m);
       // Rewrite the remaining messages to the text file
       rewriteMessagesToFile();
   }
   // Helper method to rewrite all messages to the text file
   private static void rewriteMessagesToFile() {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", false))) {
           for (UnencryptedMessage m : unencryptedMessages) {
               writer.write("Unencrypted Message\n");
               writer.write("Name: " + m.getName() + "\n");
               writer.write("Message: " + m.getMessageText() + "\n");
               writer.write("-------------\n");
           }
           for (EncryptedMessage m : encryptedMessages) {
               writer.write("Encrypted Message\n");
               writer.write("Name: " + m.getName() + "\n");
               writer.write("Message: " + m.getMessageText() + "\n");
               writer.write("-------------\n");
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
	
>>>>>>> Stashed changes
}
