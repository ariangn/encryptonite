package oopFinal;

public class HuffmanMessage extends EncryptedMessage{

	String name;
	String messageText;
	
	public HuffmanMessage(String s) {
		messageText = s;
	}
	
	public HuffmanMessage(String n, String s) {
		name = n;
	}
	
	@Override
	public String getMessageText() {
		return messageText;
	}
	
	public String getName() {
		return name;
	}
	

}
