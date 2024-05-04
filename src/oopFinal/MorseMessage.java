package oopFinal;

public class MorseMessage extends EncryptedMessage {
	
	private String name;
	private String messageText;
	
	private Encryptor encryptorUsed;

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

}
