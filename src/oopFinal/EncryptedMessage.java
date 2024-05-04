package oopFinal;

public abstract class EncryptedMessage {
	
	//each encrypted message should store the encryptor used to encrypt it
	private Encryptor encryptorUsed;
	
	public abstract String getMessageText();
	
	public abstract String getName();
	
	public abstract Encryptor getEncryptorUsed();

}
