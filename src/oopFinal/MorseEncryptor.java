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
        insert(root, 'a', ".-");
        insert(root, 'b', "-...");
        insert(root, 'c', "-.-.");
        insert(root, 'd', "-..");
        insert(root, 'e', ".");
        insert(root, 'f', "..-.");
        insert(root, 'g', "--.");
        insert(root, 'h', "....");
        insert(root, 'i', "..");
        insert(root, 'j', ".---");
        insert(root, 'k', "-.-");
        insert(root, 'l', ".-..");
        insert(root, 'm', "--");
        insert(root, 'n', "-.");
        insert(root, 'o', "---");
        insert(root, 'p', ".--.");
        insert(root, 'q', "--.-");
        insert(root, 'r', ".-.");
        insert(root, 's', "...");
        insert(root, 't', "-");
        insert(root, 'u', "..-");
        insert(root, 'v', "...-");
        insert(root, 'w', ".--");
        insert(root, 'x', "-..-");
        insert(root, 'y', "-.--");
        insert(root, 'z', "--..");
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
		String input = m.getMessageText();
		StringBuilder output = new StringBuilder();
		
		for (char c : input.toLowerCase().toCharArray()) {
            String code;
            if (c == ' ') {
                code = "/"; 
            } else {
                code = search(root, c);
            }
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
		
		MorseMessage mm = (MorseMessage)m;
		
		String input = mm.getMessageText();
		StringBuilder output = new StringBuilder();

	    // split by spaces 
	    String[] morseCharacters = input.split("\\s+");

	    for (String morseCharacter : morseCharacters) {
	        if (morseCharacter.equals("/")) {
	            output.append(" "); // Represent space character
	            System.out.print(" ");
	        } else {
	            char letter = searchMorseCode(root, morseCharacter);
	            if (letter != '\0') {
	                output.append(letter);
	                System.out.print(letter);
	            }
	        }
	    }	
		
		return new UnencryptedMessage(m.getName(),output.toString());
	}
	
	char searchMorseCode(Node root, String morseCode) {
	    Node current = root;
	    for (int i = 0; i < morseCode.length(); i++) {
	        char morseChar = morseCode.charAt(i);
	        if (morseChar == '.') {
	            if (current.left == null)
	                return '\0'; 
	            current = current.left;
	        } else if (morseChar == '-') {
	            if (current.right == null)
	                return '\0'; 
	            current = current.right;
	        }
	    }
	    return current.data;
	}
}
