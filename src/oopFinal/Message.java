package oopFinal;

<<<<<<< Updated upstream
public class Message {
=======
public abstract class Message {
	private String name;
>>>>>>> Stashed changes
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
