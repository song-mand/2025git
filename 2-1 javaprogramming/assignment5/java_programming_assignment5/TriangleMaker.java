package java_programming_assignment5;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
public class TriangleMaker implements Runnable{

	private int rows;
	private JTextArea textarea;
	private JProgressBar progressbar;
	private List<List<Integer>> triangle=new ArrayList<>();
	private boolean cancelled=false;

	public void cancel() {
		this.cancelled=true;
	}
	public TriangleMaker(int rows, JTextArea textarea,JProgressBar progressbar) {
		this.rows=rows;
		this.textarea=textarea;
		this.progressbar=progressbar;
		
	}
	
	
	public void run() {
		triangle.clear();//make empty list triangle
		textarea.setText(null);
		progressbar.setValue(0);
		for (int i = 0; i < rows; i++) {
			if (cancelled) break;//if cancel button was clicked, stop running
            List<Integer> row = new ArrayList<>();//this list will be assigned to triangle[i]
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {//make i'th row of Pascal triangle
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
                
            }
            triangle.add(row);
            String rowstring=Triangle2String(row);
            textarea.append(rowstring);//append new row to the next line of textarea
            progressbar.setValue((i/rows)*100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		

	}
	
	public String Triangle2String(List<Integer> list) {//make Pascal triangle's row string
		String pascal_seq="";
		StringBuilder rowstring = new StringBuilder();
		for(int i:list) {
			rowstring.append(i).append(" ");
		}
		String rowresult=rowstring.toString().trim();
		pascal_seq+=rowresult+"\n";
		
		return pascal_seq;
	}
	
}
