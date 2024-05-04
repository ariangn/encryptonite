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
	
<<<<<<< Updated upstream
	public String getMessage() {
		return messageText;
	}

=======
	public String getMessageText() {
		return messageText;
	}
	
	public String getName() {
		return name;
	}
>>>>>>> Stashed changes
}

