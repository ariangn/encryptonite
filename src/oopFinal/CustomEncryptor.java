package oopFinal;

import java.util.ArrayList;

public class CustomEncryptor extends Encryptor{
	
	//currentEncryptor is the custom encryption method that will used when the user encrypts a new message
	private static CustomEncryptor currentEncryptor = new CustomEncryptor();
	
	private int length; //number of find-replace pairs

	private class FindReplacePair {
		
		String find;
		String replace;
		
		FindReplacePair(String f, String r) {
			find = f;
			replace = r;
		}
	}
	
	ArrayList<FindReplacePair> findReplaceList;
	
	CustomEncryptor() {
		findReplaceList = new ArrayList<FindReplacePair>();
	}
	
	void addPair(String f, String r) {
		length++;
		findReplaceList.add(new FindReplacePair(f,r));
	}
	
	ArrayList<FindReplacePair> getAllPairs() {
		return findReplaceList;
	}
	
	String getFindAt(int index) {
		return findReplaceList.get(index).find;
	}
	
	String getReplaceAt(int index) {
		return findReplaceList.get(index).replace;
	}
	
	int getLength() {
		return length;
	}
	
	//this is how other classes will access the current custom Encryptor being used
	public static CustomEncryptor getCurrentEncryptor() {
		return currentEncryptor;
	}
	
	//this is how the CustomGUI will access the current custom Encryptor being used
	public static void setCurrentEncryptor(CustomEncryptor ce) {
		currentEncryptor = ce;
	}
	
	//inputs a message, outputs a CustomMessage
	public EncryptedMessage encrypt(UnencryptedMessage m) {
		
		//these are the Strings to find and replace, these will change in the loops
		String find;
		String replace;
		String unencryptedText = m.getMessageText();
		
		String encryptedText = String.valueOf(unencryptedText);
		
		//iterate through all find replace pairs
		for (int i = 0; i < length; i++) {
			//find all instances of the find string
			
			find = getFindAt(i);
			replace = getReplaceAt(i);
			
			//index of the text to replace in the string
			int findIndex = encryptedText.indexOf(find);
			//while there is still more text to replace, replace it!
			while (encryptedText.indexOf(find) > 0) {
				findIndex = encryptedText.indexOf(find);
				System.out.println(encryptedText);
				//this replaces the original text with the replace
				encryptedText = (encryptedText.substring(0,findIndex) + replace + encryptedText.substring(findIndex + find.length(), encryptedText.length()));
			}
			
		}
		
		return new CustomMessage(m.getName(), encryptedText, this);
	}

	@Override
	public UnencryptedMessage decrypt(EncryptedMessage m) {
		//these are the Strings to find and replace, these will change in the loops
		String find;
		String replace;
		String unencryptedText = m.getMessageText();
		
		String encryptedText = String.valueOf(unencryptedText);
		
		//iterate through all find replace pairs
		for (int i = 0; i < length; i++) {
			//find all instances of the find string
			
			find = getFindAt(i);
			replace = getReplaceAt(i);
			
			//index of the text to replace in the string
			int findIndex = encryptedText.indexOf(find);
			//while there is still more text to replace, replace it!
			while (encryptedText.indexOf(find) > 0) {
				findIndex = encryptedText.indexOf(find);
				System.out.println(encryptedText);
				//this replaces the original text with the replace
				encryptedText = (encryptedText.substring(0,findIndex) + replace + encryptedText.substring(findIndex + find.length(), encryptedText.length()));
			}
			
		}
		return new UnencryptedMessage(m.getName(), "");
	}
	
}
