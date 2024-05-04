package oopFinal;

public abstract class Encryptor {

	public abstract EncryptedMessage encrypt(UnencryptedMessage m);
	
	public abstract UnencryptedMessage decrypt(EncryptedMessage m);
}
