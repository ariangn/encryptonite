package oopFinal;

public class HuffmanMessage extends EncryptedMessage{

	String messageText;
	
	public HuffmanMessage(String s) {
		messageText = s;
	}
	
	@Override
	public String getMessageText() {
		return messageText;
	}
	

}
