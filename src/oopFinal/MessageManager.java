package oopFinal;

import java.util.ArrayList;

public class MessageManager {
	
	private static ArrayList<Message> unencryptedMessages = new ArrayList<Message>();
	private static ArrayList<EncryptedMessage> encryptedMessages = new ArrayList<EncryptedMessage>();
	
	public static ArrayList<Message> getAllUnencryptedMessages() {
		return unencryptedMessages;
	}
	
	public static ArrayList<EncryptedMessage> getAllEncryptedMessages() {
		return encryptedMessages;
	}

	public static void addUnencryptedMessage(Message m) {
		unencryptedMessages.add(m);
	}
	
	public static void addEncryptedMessage(EncryptedMessage m) {
		encryptedMessages.add(m);
	}
}
