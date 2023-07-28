package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	public static void main(String[] args) {
		buttons();
		
	}

	public static void buttons() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		JButton add = new JButton("add task");
		JButton view = new JButton("view tasks");
		JButton remove = new JButton("remove list");
		JButton save = new JButton("save list");
		JButton load = new JButton("load list");
		
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.setSize(300,300);
		frame.add(panel);
		frame.setVisible(true);
		
		ArrayList<String> tasks = new ArrayList<String>();
		
		add.addActionListener((a) -> {
			String task = JOptionPane.showInputDialog("give me a task");
			tasks.add(task);
		});
		view.addActionListener((a)->{
			JOptionPane.showMessageDialog(null, tasks.toString());
		});
		remove.addActionListener((a)->{
			String task = JOptionPane.showInputDialog("what task do I remove");
			tasks.remove(task);
			JOptionPane.showMessageDialog(null, task+" has been removed");
		});
		save.addActionListener((a)->{
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/tasks.txt");
				fw.write(tasks.toString());
				fw.close();
				JOptionPane.showMessageDialog(null, "Saved");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		load.addActionListener((a)->{
			JOptionPane.showMessageDialog(null, "Your tasks can be found at \"tasks.txt\" ");
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/tasks.txt"));
				String list = br.readLine();
				JOptionPane.showMessageDialog(null, list);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		});
		
	}

}
//Copyright © 2019 hello