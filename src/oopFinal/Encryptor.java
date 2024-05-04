package oopFinal;

public abstract class Encryptor {

<<<<<<< Updated upstream
	public abstract EncryptedMessage encrypt(Message m);
=======
	public abstract EncryptedMessage encrypt(UnencryptedMessage m);
	
	public abstract UnencryptedMessage decrypt(EncryptedMessage m);
>>>>>>> Stashed changes
}
