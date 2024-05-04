package oopFinal;

public abstract class Message {
	private String name;
	private String messageText;
	
	public Message() {
		messageText = new String();
	}
	
	public Message(String s) {
		messageText = s;
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public String getName() {
		return name;
	}

}
