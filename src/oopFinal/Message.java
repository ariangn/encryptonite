package oopFinal;

public class Message {
	private String messageText;
	
	public Message() {
		messageText = new String();
	}
	
	public Message(String s) {
		messageText = s;
	}
	
	public String getMessage() {
		return messageText;
	}

}
