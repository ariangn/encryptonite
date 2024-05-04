package oopFinal;

public abstract class Encryptor {

	public abstract EncryptedMessage encrypt(Message m);
	
	public abstract Message decrypt(EncryptedMessage m);
}
