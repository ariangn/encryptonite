package oopFinal;

import java.util.ArrayList;

public class CustomEncryptor extends Encryptor{
	
	//currentEncryptor is the custom encryption method that will used when the user encrypts a new message
	private static CustomEncryptor currentEncryptor;
	
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
		return new CustomMessage();
	}

	@Override
	public UnencryptedMessage decrypt(EncryptedMessage m) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
