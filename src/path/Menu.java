package path;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
//import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.file.Files;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
//import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
//import javax.swing.JEditorPane;

public class Menu extends FindPath{

	private JFrame frame;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Big maze");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        printResult("bigMaze.txt");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 10, 235, 55);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSmallMaze = new JButton("Small maze");
		btnSmallMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printResult("smallMaze.txt");
			}
		});
		btnSmallMaze.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSmallMaze.setBounds(255, 10, 234, 55);
		frame.getContentPane().add(btnSmallMaze);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(10, 323, 728, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Maximum value that can be collected:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 284, 363, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMaze = new JLabel("Display maze:");
		lblMaze.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaze.setBounds(10, 64, 363, 29);
		frame.getContentPane().add(lblMaze);
		
		JTextPane showMaze = new JTextPane();
		showMaze.setBounds(20, 96, 353, 178);
		frame.getContentPane().add(showMaze);
		
		JTextPane insertMaze = new JTextPane();
		insertMaze.setBounds(384, 96, 354, 178);
		frame.getContentPane().add(insertMaze);
		
		JButton btnCustomMaze = new JButton("Custom maze");
		btnCustomMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        FileWriter fWriter;
				try {
					fWriter = new FileWriter("customMaze.txt");
					fWriter.write(insertMaze.getText() + " ");
					fWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				printResult("customMaze.txt");

			}
		});
		btnCustomMaze.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCustomMaze.setBounds(499, 10, 247, 55);
		frame.getContentPane().add(btnCustomMaze);
		
		
		
		JLabel lblPutYourRectengular = new JLabel("For custom maze(create rectengular shape by numbers):");
		lblPutYourRectengular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPutYourRectengular.setBounds(383, 64, 363, 29);
		frame.getContentPane().add(lblPutYourRectengular);
			
	}
	
	public void printResult(String file) {
		int[][] map = createMaze(file);
		int[][] memoryMap = new int[map.length][map[0].length];
		int r = findPath(0, 0, map, memoryMap);
		String result = String.valueOf(r);
		textField.setText(result);
		String[] mapToString = new String[map.length];
		JTextPane showMaze = new JTextPane();
		showMaze.setBounds(20, 96, 353, 178);
		frame.getContentPane().add(showMaze);
		for(int i = 0; i < map.length; i++) {
			mapToString[i] = Arrays.toString(map[i]);
			showMaze.setText(showMaze.getText() + '\n' + mapToString[i]);
			
		}
		
	}
	
}
