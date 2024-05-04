package oopFinal;

public class MorseMessage extends EncryptedMessage {
	
	private String name;
	private String messageText;

	@Override
	public String getMessageText() {
		return messageText;
	}

	@Override
	public String getName() {
		return name;
	}

}
