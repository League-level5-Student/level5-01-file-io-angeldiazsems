package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * 'Hello World' changes to 'Lipps Asvph'
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */

public static void main(String[] args) {
	String message = JOptionPane.showInputDialog("give me a message");
	int key = Integer.parseInt(JOptionPane.showInputDialog("give me a key"));
	String encrypted = encrypt(message, key);
	try {
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/messages.txt");
		fw.write(key);
		fw.write("\n"+encrypted);
		fw.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
	
	
}

static String encrypt(String message, int key) {
	char[] alpha = {'a','b','c','d','e','f','g',
					  'h','i','j','k','l','m','n',
					  'o','p','q','r','s','t','u',
					  'v','w','x','y','z'};
	//if indez is greater than length-1, reset back to 0
	//if(i>arr.length-1) \n arr[0+key] = arr[i];
	
	
	message = message.toLowerCase();
	String changed = "";
	for(int i = 0; i < message.length(); i++) {
		System.out.println("outer current :"+message.charAt(i));
		inner : for(int j = 0; j < alpha.length; j++) {
			System.out.println("Inner current "+alpha[j]);
			if(message.charAt(i) ==  alpha[j]) {
				System.out.println("found similar");
				if(j+key > alpha.length) { //if you are going out of bounds
					char past = alpha[(j+key)-(alpha.length)];
					changed += past;
				}
				else {
					changed += alpha[j+key];
				}
				break inner;
			}
			else if(message.charAt(i) == ' ') { //checking for spaces
				changed += " ";
				break inner;
			}
		}
		
	}
	System.out.println(changed);
	return changed;
}


}
