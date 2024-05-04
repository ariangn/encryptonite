package oopFinal;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class MessageManager {
	
	private static ArrayList<UnencryptedMessage> unencryptedMessages = new ArrayList<UnencryptedMessage>();
	private static ArrayList<EncryptedMessage> encryptedMessages = new ArrayList<EncryptedMessage>();
	
	public static ArrayList<UnencryptedMessage> getAllUnencryptedMessages() {
		return unencryptedMessages;
	}
	
	public static ArrayList<EncryptedMessage> getAllEncryptedMessages() {
		return encryptedMessages;
	}

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
        addUnencryptedMessage(m);

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
        unencryptedMessages.remove(m);

        rewriteMessagesToFile();
    }

    public static void storeEncryptedMessage(EncryptedMessage m) {
        addEncryptedMessage(m);

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
        encryptedMessages.remove(m);

        rewriteMessagesToFile();
    }

    private static void rewriteMessagesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("storage.txt", false))) { //false = overwrite
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
	
	
}
