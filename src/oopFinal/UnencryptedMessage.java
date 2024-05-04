package oopFinal;

public class UnencryptedMessage extends Message{
	
	private String name;
	private String messageText;
	
	public UnencryptedMessage() {
		messageText = new String();
	}
	
	public UnencryptedMessage(String s) {
		messageText = s;
	}

}
