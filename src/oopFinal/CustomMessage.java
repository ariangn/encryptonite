package oopFinal;

import java.util.ArrayList;

public class CustomMessage extends EncryptedMessage {
	
	private String name;
	private String messageText;
	private String oldMessage;
	
	private Encryptor encryptorUsed;
	
	public CustomMessage() {
		messageText = new String();
	}
	
	public CustomMessage(String s) {
		messageText = s;
	}
	
	public CustomMessage(String n, String s) {
		name = n;
		messageText = s;
		encryptorUsed = new CustomEncryptor();
	}
	
	public CustomMessage(String n, String s, Encryptor e) {
		name = n;
		messageText = s;
		encryptorUsed = e;
	}
	
	public String getMessage() {
		return messageText;
	}

	@Override
	public String getMessageText() {
		return messageText;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Encryptor getEncryptorUsed() {
		return encryptorUsed;
	}

	@Override
	public String getOldMessage() {
		return oldMessage;
	}
	
	@Override
	public void setOldMessage(String oldMessage) {
		this.oldMessage = oldMessage;
		
	}

	public String getCustomEncryptionString() {
		String encryptionString = ""; 
		
		CustomEncryptor ce = (CustomEncryptor)this.encryptorUsed;
		for (int i = 0; i < ce.getLength(); i++) {
			encryptionString += ce.getFindAt(i) + "/" + ce.getReplaceAt(i) + "|";
		}
		
		if (!encryptionString.isEmpty()) {
			encryptionString = encryptionString.substring(0, encryptionString.length() - 1);
		}
		
		return encryptionString;
	}
	
	public void loadCustomEncryptionString(String encryptionString) {		
		String[] stringArray = encryptionString.split("\\|");
		
		for (String s: stringArray) {
			String[] temp = s.split("/");
			if (temp.length == 2) {
				((CustomEncryptor)this.encryptorUsed).addPair(temp[0], temp[1]);
			}
		}
	}
	

}
