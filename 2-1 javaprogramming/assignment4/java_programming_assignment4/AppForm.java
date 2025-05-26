package java_programming_assignment4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
public class AppForm {
	/**
	 * @wbp.parser.entryPoint
	 */
	private static JTextField NameField;
	private static JTextField IDField;
	private static JTextField MajorField;
	private static JTextField EmailField;
	private static JTextField PhoneNumberField;
	private static JTextField CaptchaField;
	
	private static String currentCaptcha;
	
	public static String makeCaptcha() {//randomly make new captcha
		Random random=new Random();
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String newcaptcha="";
		for(int i=0;i<5;i++)
		{
			int index=random.nextInt(chars.length());
			newcaptcha+=chars.charAt(index);
		}
		
		return newcaptcha;
	} 
	/**
     * @wbp.parser.entryPoint
     */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		currentCaptcha=makeCaptcha();//captcha initialization
		
		JFrame frame=new JFrame("SKKU Coding Club");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.setSize(600, 250);
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 32, -17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout_1);
		
		JLabel lblNewLabel_1 = new JLabel("SKKU Coding Club Application Form");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.gridwidth = 16;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		NameField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 17;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 4;
		frame.getContentPane().add(NameField, gbc_textField);
		NameField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Student ID: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 6;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		IDField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 17;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 6;
		frame.getContentPane().add(IDField, gbc_textField_1);
		IDField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Major: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 8;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		MajorField = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 17;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 8;
		frame.getContentPane().add(MajorField, gbc_textField_2);
		MajorField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 10;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		EmailField = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 17;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 10;
		frame.getContentPane().add(EmailField, gbc_textField_3);
		EmailField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 12;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		PhoneNumberField = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 17;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 12;
		frame.getContentPane().add(PhoneNumberField, gbc_textField_4);
		PhoneNumberField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("CAPTCHA:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 14;
		frame.getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		CaptchaField = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 17;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 14;
		frame.getContentPane().add(CaptchaField, gbc_textField_5);
		CaptchaField.setColumns(10);
		
		JLabel captchaLabel=new JLabel(currentCaptcha);
		GridBagConstraints gbc_captchaLabel=new GridBagConstraints();
		gbc_captchaLabel.gridwidth=4;
		gbc_captchaLabel.insets=new Insets(0,0,5,5);
		gbc_captchaLabel.gridx=5;
		gbc_captchaLabel.gridy=16;
		frame.getContentPane().add(captchaLabel,gbc_captchaLabel);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String errMessage="";
				boolean isError=false;
				//initialize font color with black
				NameField.setForeground(Color.BLACK);
		        IDField.setForeground(Color.BLACK);
		        MajorField.setForeground(Color.BLACK);
		        EmailField.setForeground(Color.BLACK);
		        PhoneNumberField.setForeground(Color.BLACK);
		        CaptchaField.setForeground(Color.BLACK);
		        
		        try {
		            Verification.NameVerify(NameField.getText());
		        } catch (NameException ex) {
		            NameField.setForeground(Color.RED);
		            errMessage+=ex.getMessage();
		            isError = true;
		        }
		        try {
		        	Verification.IDVerify(IDField.getText());
		        } catch (IDException ex) {
		            IDField.setForeground(Color.RED);
		            errMessage+=ex.getMessage();
		            isError = true;
		        }
		        try {
		            Verification.MajorVerify(MajorField.getText());
		        } catch (MajorException ex) {
		            MajorField.setForeground(Color.RED);
		            errMessage+=ex.getMessage();
		            isError = true;
		        }
		        try {
		            Verification.EmailVerify(EmailField.getText());
		        } catch (EmailException ex) {
		            EmailField.setForeground(Color.RED);
		            errMessage+=ex.getMessage();
		            isError = true;
		        }
		        try {
		            Verification.PhoneNumberVerify(PhoneNumberField.getText());
		        } catch (PhoneNumberException ex) {
		            PhoneNumberField.setForeground(Color.RED);
		            errMessage+=ex.getMessage();
		            isError = true;
		        }
		        try {
		            Verification.CaptchaVerify(currentCaptcha, CaptchaField.getText());
		        } catch (CaptchaException ex) {
		            CaptchaField.setForeground(Color.RED);
		            errMessage+=ex.getMessage();
		            isError = true;
		        }

		        if (isError) {//if any error occurred, notice all errors that occured
		        	JTextArea textArea = new JTextArea(errMessage);
		        	textArea.setSize(400, 200);
		        	JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Input Errors", JOptionPane.ERROR_MESSAGE);
		        } else {//if every form is correct clear all fields
		            JOptionPane.showMessageDialog(null, "Form submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		            NameField.setText("");
		            IDField.setText("");
		            MajorField.setText("");
		            EmailField.setText("");
		            PhoneNumberField.setText("");
		            CaptchaField.setText("");
		        }

		        // generate new captcha
		        currentCaptcha = makeCaptcha();
		        captchaLabel.setText(currentCaptcha);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 13;
		gbc_btnNewButton.gridy = 16;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		frame.setVisible(true);
		
	}

}
