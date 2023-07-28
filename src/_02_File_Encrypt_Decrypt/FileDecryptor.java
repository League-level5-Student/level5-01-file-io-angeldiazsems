package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import java.lang.Math;

public class FileDecryptor extends FileEncryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		decrypt();
	}

	static void decrypt() {
		char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		String decry = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/messages.txt"));

			String str = br.readLine();
			String encry = br.readLine();
			br.close();
			int key = Integer.parseInt(str);

			if (key > 26 || key == 26) {
				while (key >= 25) {
					key = key - 26;
				}
			}

			for (int i = 0; i < encry.length(); i++) {
				for (int j = 0; i < alpha.length - 1; j++) {
					if (encry.charAt(i) == alpha[j]) {
						
						if (j - key < 0) {
							int abs = Math.abs(j - key);
							decry += alpha[26 - abs];
							break;
						} else {
							decry += alpha[j - key];
							break;
						}
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, decry);

	}

}
//Copyright © 2019 hello