package oopFinal;

public class CustomMessage {
	
	private String messageText;
	
	public CustomMessage() {
		messageText = new String();
	}
	
	public CustomMessage(String s) {
		messageText = s;
	}
	
	public String getMessage() {
		return messageText;
	}

}
