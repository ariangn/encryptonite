package oopFinal;

import java.util.ArrayList;

public class MessageManager {
	
	private static ArrayList<Message> unencryptedMessages;
	private static ArrayList<EncryptedMessage> encryptedMessages;
	
	public static ArrayList<Message> getAllUnencryptedMessages() {
		return unencryptedMessages;
	}
	
	public static ArrayList<EncryptedMessage> getAllEncryptedMessages() {
		return encryptedMessages;
	}

}
