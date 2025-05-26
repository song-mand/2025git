package java_programming_assignment5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleSum extends SwingWorker<Void, Void> {
	private JTextArea triangletext;//triangle textarea
	private JTextField textfield;//textfield for print the result of summation
	private JProgressBar progressbar;
	
	
	public TriangleSum(JTextArea triangletext, JTextField textfield, JProgressBar progressbar) {
		this.triangletext=triangletext;
		this.textfield=textfield;
		this.progressbar=progressbar;
	}
	
	protected Void doInBackground(){
		int sum = 0;
	    String allnum = triangletext.getText();//get all numbers in textarea
	    String eachNumStr = "";//store each number as string
	    int length=allnum.length();
	    for (int i = 0; i < allnum.length(); i++) {
	        char ch = allnum.charAt(i);

	        if (ch >= '0' && ch <= '9') {
	            eachNumStr += ch;
	        } else if (ch == ' ' || ch == '\n') {
	            if (!eachNumStr.equals("")) {//add eachnum to sum
	                int num = Integer.parseInt(eachNumStr);
	                sum += num;
	                eachNumStr = ""; 
	            }
	        }
	        int progress = (int) ((i / (double) length) * 100);//set progressbar %
	        setProgress(progress);
	    }
	    if (!eachNumStr.equals("")) {
	        int num = Integer.parseInt(eachNumStr);
	        sum += num;
	    }
	    setProgress(100);
	    String sumstr="Sum="+sum+"";
	    textfield.setText(sumstr);	    
	    return null;
	}
	
	
}
