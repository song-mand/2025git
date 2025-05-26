package java_programming_assignment5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUI_Operation {
	private static JMenuBar menuBar;
	private static JMenu mnNewMenu;
	private static JMenuItem mntmNewMenuItem;
	private static JMenuItem mntmNewMenuItem_1;
	private static JMenuItem mntmNewMenuItem_2;
	private static JMenu mnNewMenu_1;
	private static JLabel lblNewLabel;
	private static JButton btnNewButton;
	private static JButton btnNewButton_1;
	private static JTextArea textArea;
	private static JScrollPane scrollPane;
	private static JTextField textField;
	private static JTextField textField_2;
	
	private static TriangleMaker pascalmaker;
	private static JMenuItem mntmNewMenuItem_3;
	private static JProgressBar progressBar;
	private static JLabel progress;
	/**
	 * @wbp.parser.entryPoint
	 */
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JFrame frame = new JFrame("Find Pascal");//main frame
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("Number of rows in Pascal's Triangle");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();//textfield for input(number of row)
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Get Sum of Pascal's Triangle");//get sum button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    String input = textField.getText();
				    int number = Integer.parseInt(input);
				    if(number<1||number>20) {//range check
				    	throw new InputRangeException("Only number(1<=k<=20)");
				    }
				    btnNewButton_1.setEnabled(true);
				    pascalmaker=new TriangleMaker(number, textArea, progressBar);
				    Thread thread1=new Thread(pascalmaker);
				    thread1.start();
				    
				    Thread thread2=new Thread(()->{
				    	try {
				    		thread1.join();//thread2 run after thread1
				    		TriangleSum summation=new TriangleSum(textArea,textField_2,progressBar);
				    		summation.addPropertyChangeListener(event -> {
				    		    if ("progress".equals(event.getPropertyName())) {//update progressbar
				    		        int val = (Integer) event.getNewValue();
				    		        progressBar.setValue(val);
				    		    }
				    		});
				    		summation.execute();
				    	}catch(InterruptedException ex) {
				    		ex.printStackTrace();
				    	}
				    	
				    });
				    thread2.start();
				    
				}
				catch(InputRangeException ex2) {
				    JOptionPane.showMessageDialog(null, "Only number(1<=k<=20)");
				}
				catch (NumberFormatException ex1) {
				    JOptionPane.showMessageDialog(null, "Only number(1<=k<=20)");
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 0;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pascalmaker.cancel();
				TriangleSum summation=new TriangleSum(textArea,textField_2,progressBar);
	    		summation.execute();
				btnNewButton_1.setEnabled(false);

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 0;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		textArea = new JTextArea();
		scrollPane=new JScrollPane(textArea);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridwidth = 8;
		gbc_textArea.gridheight = 17;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_textArea);
		
		progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridwidth = 4;
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 18;
		frame.getContentPane().add(progressBar, gbc_progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.CYAN);
		progressBar.setBackground(Color.white);
		
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 18;
		frame.getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Open");//open file
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
			    int option = fileChooser.showOpenDialog(null);
			    if (option == JFileChooser.APPROVE_OPTION) {
			        File file = fileChooser.getSelectedFile();
			        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			        	StringBuilder content = new StringBuilder();//store content of  the text file
			            String linecontent;
			            int rowCount = 0;//for update row textfield
			            progressBar.setValue(20);

			            while ((linecontent = reader.readLine()) != null) {//read a line of file and append it to content
			                content.append(linecontent).append("\n");
			                rowCount++;
			            }
			            progressBar.setValue(70);
			            textArea.setText(content.toString());
			            String rowCountstring=rowCount+"";
			            textField.setText(rowCountstring);
			            TriangleSum summation = new TriangleSum(textArea, textField_2,progressBar);
			            summation.execute();
			        }catch(FileNotFoundException e1) {
			            JOptionPane.showMessageDialog(null, "File Not Found");

			        	
			        }catch(IOException e2) {
			            JOptionPane.showMessageDialog(null, "IO Error");

			        }
			    }
	            progressBar.setValue(100);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Save");//store textarea's content in the selected file 
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
			    int option = fileChooser.showOpenDialog(null);
			    if (option == JFileChooser.APPROVE_OPTION) {
			    	File file=fileChooser.getSelectedFile();
		            progressBar.setValue(20);
			    	try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
			    		
			    		writer.write(textArea.getText());//copy the content of textarea and store it to file
			            progressBar.setValue(60);
			    		
			    	}catch(FileNotFoundException e1) {
			            JOptionPane.showMessageDialog(null, "File Not Found");
			    	}catch(IOException e2) {
			            JOptionPane.showMessageDialog(null, "IO Error");
			    	}
			    }
	            progressBar.setValue(100);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3 = new JMenuItem("show help");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This program generates Pascal's Triangle up to given number of rows.Use the buttons to open or save the file,  and for help information","Help",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		
		
		frame.setVisible(true);
		
		
	}

	
	
	
}
