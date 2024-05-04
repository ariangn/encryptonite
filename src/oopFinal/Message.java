package oopFinal;

public class Message {
	private String name;
	private String messageText;
	
	public Message() {
		messageText = new String();
	}
	
	public Message(String s) {
		messageText = s;
	}
	
	public Message(String n, String s) {
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
