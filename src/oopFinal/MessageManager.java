package oopFinal;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MessageManager {
	
	private static ArrayList<UnencryptedMessage> unencryptedMessages = new ArrayList<UnencryptedMessage>();
	private static ArrayList<EncryptedMessage> encryptedMessages = new ArrayList<EncryptedMessage>();
	
	public static ArrayList<UnencryptedMessage> getAllUnencryptedMessages() {
		return unencryptedMessages;
	}
	
	public static ArrayList<EncryptedMessage> getAllEncryptedMessages() {
		return encryptedMessages;
	}
	
	public static void addUnencryptedMessage(UnencryptedMessage m) {
		unencryptedMessages.add(m);
	}
	
	public static void addEncryptedMessage(EncryptedMessage m) {
		encryptedMessages.add(m);
	}
	
	public static void removeUnencryptedMessage(int index) {
		unencryptedMessages.remove(index);
	}
	
	public static void removeEncryptedMessage(int index) {
		encryptedMessages.remove(index);
	}
	
	//------------------------------------------------------------------------//
	
	public static void fetchMessages(File storageFile) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(storageFile))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.equals("Unencrypted Message")) {
	                String name = reader.readLine();
	                String messageText = reader.readLine();
	                if (name == null || messageText == null) {
	                    break;
	                }
	                name = name.substring(6);
	                messageText = messageText.substring(9);
	                unencryptedMessages.add(new UnencryptedMessage(name, messageText));
	            } else if (line.equals("Encrypted Message")) {
	                String encryptorType = reader.readLine();
	                String name = reader.readLine();
	                String messageText = reader.readLine();
	                if (encryptorType == null || name == null || messageText == null) {
	                    break;
	                }
	                encryptorType = encryptorType.substring(16);
	                name = name.substring(6);
	                messageText = messageText.substring(9);
	                
	                switch (encryptorType) {
	                    case "Huffman":
	                        String oldMessage = reader.readLine();
	                        if (oldMessage == null) {
	                            break;
	                        }
	                        oldMessage = oldMessage.substring(11);
	                        HuffmanMessage hm = new HuffmanMessage(name, messageText);
	                        hm.setOldMessage(oldMessage);
	                        encryptedMessages.add(hm);
	                        break;
	                    case "Morse":
	                        encryptedMessages.add(new MorseMessage(name, messageText));
	                        break;
	                    case "Custom":
	                        String encryptionString = reader.readLine();
	                        if (encryptionString == null) {
	                            break;
	                        }
	                        encryptionString = encryptionString.substring(19);
	                        CustomMessage cm = new CustomMessage(name, messageText);
	                        cm.loadCustomEncryptionString(encryptionString);
	                        encryptedMessages.add(cm);
	                        break;
	                    default:
	                        System.err.println("Unrecognized encryptor type: " + encryptorType);
	                }
	            }
	            // Skip the "-------------" line
	            reader.readLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}



	
	public static void storeUnencryptedMessage(UnencryptedMessage m, File storageFile) {
        // Add the message to the list
        addUnencryptedMessage(m);
        // Store the message in the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageFile, true))) {
            writer.write("Unencrypted Message\n");
            writer.write("Name: " + m.getName() + "\n");
            writer.write("Message: " + m.getMessageText() + "\n");
            writer.write("-------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void storeEncryptedMessage(EncryptedMessage m, File storageFile) {
        // Add the message to the list
        addEncryptedMessage(m);
        // Store the message in the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageFile, true))) {
        	writer.write("Encrypted Message\n");
            if (m instanceof HuffmanMessage) {
            	writer.write("Encryptor Used: Huffman\n");
            	HuffmanMessage hm = (HuffmanMessage)m;
            	writer.write("Name: " + m.getName() + "\n");
                writer.write("Message: " + m.getMessageText() + "\n");
            	writer.write("Old String: " + hm.getOldMessage() + "\n"); //TODO store tree somehow
                writer.write("-------------\n");
            } else if (m instanceof MorseMessage) {
            	writer.write("Encryptor Used: Morse\n");
                writer.write("Name: " + m.getName() + "\n");
                writer.write("Message: " + m.getMessageText() + "\n");
                writer.write("-------------\n");
            } else if (m instanceof CustomMessage) {
            	writer.write("Encryptor Used: Custom\n");
            	CustomMessage cm = (CustomMessage)m;
            	writer.write("Name: " + m.getName() + "\n");
                writer.write("Message: " + m.getMessageText() + "\n");
            	writer.write("Encryption String: " + cm.getCustomEncryptionString() + "\n");
                writer.write("-------------\n");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Rewrite all messages to the text file
    public static void rewriteMessagesToFile(File storageFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageFile, false))) {
            for (UnencryptedMessage m : unencryptedMessages) {
                writer.write("Unencrypted Message\n");
                writer.write("Name: " + m.getName() + "\n");
                writer.write("Message: " + m.getMessageText() + "\n");
                writer.write("-------------\n");
            }
            for (EncryptedMessage m : encryptedMessages) {
                writer.write("Encrypted Message\n");
                if (m instanceof HuffmanMessage) {
                	writer.write("Encryptor Used: Huffman\n");
                	HuffmanMessage hm = (HuffmanMessage)m;
                	writer.write("Name: " + m.getName() + "\n");
                    writer.write("Message: " + m.getMessageText() + "\n");
                	writer.write("Old String: " + hm.getOldMessage() + "\n"); //TODO store tree somehow
                    writer.write("-------------\n");
                } else if (m instanceof MorseMessage) {
                	writer.write("Encryptor Used: Morse\n");
                    writer.write("Name: " + m.getName() + "\n");
                    writer.write("Message: " + m.getMessageText() + "\n");
                    writer.write("-------------\n");
                } else if (m instanceof CustomMessage) {
                	writer.write("Encryptor Used: Custom\n");
                	CustomMessage cm = (CustomMessage)m;
                	writer.write("Name: " + m.getName() + "\n");
                    writer.write("Message: " + m.getMessageText() + "\n");
                	writer.write("Encryption String: " + cm.getCustomEncryptionString() + "\n");
                    writer.write("-------------\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
