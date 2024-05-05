package oopFinal;

public class MorseEncryptor extends Encryptor {
	
	class Node {
	    char data;
	    Node left, right;

	    Node(char item) {
	        data = item;
	        left = right = null;
	    }
	}
	
    Node root;

    MorseEncryptor() {
        root = new Node(' ');
        // populate bst with morse code mappings
        insert(root, 'A', ".-");
        insert(root, 'B', "-...");
        insert(root, 'C', "-.-.");
        insert(root, 'D', "-..");
        insert(root, 'E', ".");
        insert(root, 'F', "..-.");
        insert(root, 'G', "--.");
        insert(root, 'H', "....");
        insert(root, 'I', "..");
        insert(root, 'J', ".---");
        insert(root, 'K', "-.-");
        insert(root, 'L', ".-..");
        insert(root, 'M', "--");
        insert(root, 'N', "-.");
        insert(root, 'O', "---");
        insert(root, 'P', ".--.");
        insert(root, 'Q', "--.-");
        insert(root, 'R', ".-.");
        insert(root, 'S', "...");
        insert(root, 'T', "-");
        insert(root, 'U', "..-");
        insert(root, 'V', "...-");
        insert(root, 'W', ".--");
        insert(root, 'X', "-..-");
        insert(root, 'Y', "-.--");
        insert(root, 'Z', "--..");
        insert(root, '0', "-----");
        insert(root, '1', ".----");
        insert(root, '2', "..---");
        insert(root, '3', "...--");
        insert(root, '4', "....-");
        insert(root, '5', ".....");
        insert(root, '6', "-....");
        insert(root, '7', "--...");
        insert(root, '8', "---..");
        insert(root, '9', "----.");
        insert(root, '.', ".-.-.-");
        insert(root, ',', "--..--");
        insert(root, '?', "..--..");
        insert(root, '\'', ".----.");
        insert(root, '!', "-.-.--");
        insert(root, '/', "-..-.");
        insert(root, '(', "-.--.");
        insert(root, ')', "-.--.-");
        insert(root, '&', ".-...");
        insert(root, ':', "---...");
        insert(root, ';', "-.-.-.");
        insert(root, '=', "-...-");
        insert(root, '+', ".-.-.");
        insert(root, '-', "-....-");
        insert(root, '_', "..--.-");
        insert(root, '"', ".-..-.");
        insert(root, '$', "...-..-");
        insert(root, '@', ".--.-.");
        insert(root, ' ', "/");
    }
    
    public void insert(Node root, char letter, String code) {
	    Node current = root;
	    for (int i = 0; i < code.length(); i++) {
	        if (code.charAt(i) == '.') {
	            if (current.left == null)
	                current.left = new Node(' ');
	            current = current.left;
	        } else if (code.charAt(i) == '-') {
	            if (current.right == null)
	                current.right = new Node(' ');
	            current = current.right;
	        }
	    }
	    current.data = letter;
	}
	  

	@Override
	public MorseMessage encrypt(UnencryptedMessage m) {
		// TODO Auto-generated method stub
		String input = m.getMessageText();
		StringBuilder output = new StringBuilder();
		
		for (char c : input.toUpperCase().toCharArray()) {
            String code = search(root, c);
            if (code != null) {
                output.append(code).append(" ");
            }
        }
		return new MorseMessage(m.getName(), output.toString(), this);
	}
	
	// search for morse code for a given character
    String search(Node root, char letter) {
        if (root == null) return null;
        if (root.data == letter) return "";
        String leftPath = search(root.left, letter);
        if (leftPath != null) return "." + leftPath;
        String rightPath = search(root.right, letter);
        if (rightPath != null) return "-" + rightPath;
        return null;
    }

	@Override
	public UnencryptedMessage decrypt(EncryptedMessage m) {
		// TODO Auto-generated method stub
		
		//PLACEHOLDER, change later to actual thing to return
		return new UnencryptedMessage(m.getName(), m.getMessageText());
	}
}
