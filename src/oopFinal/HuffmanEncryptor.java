package oopFinal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class HuffmanEncryptor extends Encryptor{
	
	class Node {
	    char character;
	    int frequency;
	    Node left;
	    Node right;

	    public Node(char character, int frequency) {
	        this.character = character;
	        this.frequency = frequency;
	        this.left = null;
	        this.right = null;
	    }
	}
	
	@Override
	public HuffmanMessage encrypt(UnencryptedMessage inputMessage) {
		
		String input = inputMessage.getMessageText();
        
        Map<Character, Integer> frequencyMap = countLetterFrequency(input);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        //comparator: highest frequency at head of pqueue
        
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;  // Assign the left child
            parent.right = right;  // Assign the right child
            pq.add(parent);
        }
        Node root = pq.poll(); //make last parent the root

        
        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);
        
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        String output = applyEncryption(input, huffmanCode);
                
        return new HuffmanMessage(inputMessage.getName(), output, this);
	}
	
	public static Map<Character, Integer> countLetterFrequency(String input) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        return frequencyMap;
    }
	
	private static void generateCodes(Node root, String code, Map<Character, String> huffmanCodes) {
	    if (root == null) {
	        return;
	    }
	    if (root.left == null && root.right == null) {
	        huffmanCodes.put(root.character, code);
	        System.out.println("add code");
	        return;
	    }
	    generateCodes(root.left, code + "0", huffmanCodes);
	    generateCodes(root.right, code + "1", huffmanCodes);
	}
	
	public static String applyEncryption(String input, Map<Character, String> huffmanCodes) {
	    StringBuilder encryptedText = new StringBuilder();
	    for (int i = 0; i < input.length(); i++) {
	        char ch = input.charAt(i);
	        encryptedText.append(huffmanCodes.get(ch));
	    }
	    return encryptedText.toString();
	}

	@Override
	public UnencryptedMessage decrypt(EncryptedMessage m) {
		
		//for now:
		return new UnencryptedMessage(m.getName(), m.getMessageText());
	}

}

