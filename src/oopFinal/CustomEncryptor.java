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
	
	public CustomEncryptor() {
		findReplaceList = new ArrayList<FindReplacePair>();
	}
	
	public void addPair(String f, String r) {
		length++;
		findReplaceList.add(new FindReplacePair(f,r));
		
	}
	
	public ArrayList<FindReplacePair> getAllPairs() {
		return findReplaceList;
	}
	
	public String getFindAt(int index) {
		return findReplaceList.get(index).find;
	}
	
	public String getReplaceAt(int index) {
		return findReplaceList.get(index).replace;
	}
	
	public int getLength() {
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
		String unencryptedText = " " + m.getMessageText();
		
		String encryptedText = String.valueOf(unencryptedText);
		
		//iterate through all find replace pairs
		for (int i = 0; i < length; i++) {
			//find all instances of the find string
			
			find = getFindAt(i);
			replace = getReplaceAt(i);
			
			//index of the text to replace in the string
			int findIndex = encryptedText.indexOf(find);
			//while there is still more text to replace, replace it!
			while (encryptedText.indexOf(find) >= 0) {
				findIndex = encryptedText.indexOf(find);
				//this replaces the original text with the replace
				if (findIndex == 0) {
					encryptedText = (replace + encryptedText.substring(1,encryptedText.length()));
				} else {
					encryptedText = (encryptedText.substring(0,findIndex) + replace + encryptedText.substring(findIndex + find.length(), encryptedText.length()));
				}
			}
			
		}
		
		return new CustomMessage(m.getName(), encryptedText.substring(1), this);
	}

	@Override
	public UnencryptedMessage decrypt(EncryptedMessage m) {
		//these are the Strings to find and replace, these will change in the loops
		String find;
		String replace;
		String encryptedText = " " + m.getMessageText();
		
		String decryptedText = String.valueOf(encryptedText);
		
		//iterate through all find replace pairs
		for (int i = 0; i < length; i++) {
			//find all instances of the find string
			
			find = getReplaceAt(i);
			replace = getFindAt(i);
			
			//index of the text to replace in the string
			int findIndex = decryptedText.indexOf(find);
			//while there is still more text to replace, replace it!
			while (decryptedText.indexOf(find) >= 0) {
				findIndex = decryptedText.indexOf(find);
				//this replaces the original text with the replace
				if (findIndex == 0) {
					decryptedText = (replace + decryptedText.substring(1,decryptedText.length()));
				} else {
					decryptedText = (decryptedText.substring(0,findIndex) + replace + decryptedText.substring(findIndex + find.length(), decryptedText.length()));
				}			
			}
			
		}
		return new UnencryptedMessage(m.getName(), decryptedText.substring(1));
	}
	
}
