package oopFinal;

public class MorseMessage extends EncryptedMessage {
	
	private String name;
	private String messageText;
	private String oldMessage;
	
	private Encryptor encryptorUsed;
	
	public MorseMessage(String n, String s) {
		name = n;
		messageText = s;
		encryptorUsed = new MorseEncryptor();
	}
	
	public MorseMessage(String n, String s, Encryptor e) {
		name = n;
		messageText = s;
		encryptorUsed = e;
	}

	@Override
	public String getMessageText() {
		return messageText;
	}

	@Override
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

}
