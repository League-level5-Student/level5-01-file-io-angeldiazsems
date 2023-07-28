package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.

public static void main(String[] args) {
	file();
}
	
	

static void file() {
	String message = JOptionPane.showInputDialog("Tell me something");
	try {
		FileWriter righter = new FileWriter("src/_01_File_Recorder/hello.txt", true);
		righter.write("\n"+message);
		righter.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}



}//Copyright © 2019 hello