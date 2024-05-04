package oopFinal;

public class CustomMessage extends EncryptedMessage {
	
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

	@Override
	public String getMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

}
