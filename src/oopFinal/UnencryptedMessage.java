package oopFinal;

public class UnencryptedMessage {
	private String name;
	private String messageText;
	
	public UnencryptedMessage() {
		messageText = new String();
	}
	
	public UnencryptedMessage(String s) {
		messageText = s;
	}
	
	public UnencryptedMessage(String n, String s) {
		name = n;
		messageText = s;
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public String getName() {
		return name;
	}

}
