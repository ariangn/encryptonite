package oopFinal;

public class CustomMessage extends EncryptedMessage {
	
	private String name;
	private String messageText;
	
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
	}
	
	public String getMessage() {
		return messageText;
	}

	@Override
	public String getMessageText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Encryptor getEncryptorUsed() {
		return encryptorUsed;
	}

}
