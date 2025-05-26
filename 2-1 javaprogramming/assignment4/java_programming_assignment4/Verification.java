
package java_programming_assignment4;

import java.awt.*;
import javax.swing.*;
public class Verification {
	
	public static void NameVerify(String name) throws NameException{
		int namelen=name.length();
		if (name==null||name.equals("")) {//if the field is blank
			
			throw new NameException("Namefield: The field is blank\n");
		}
		int spacecount=0;
		int not_alphabet_space=0;
		for(int i=0;i<namelen;i++) {
			if (name.charAt(i)==' ')
			{
				spacecount++;
			}
			else if(!Character.isAlphabetic(name.charAt(i))&&name.charAt(i)!=' ')
			{
				not_alphabet_space++;
			}
		}
		if(spacecount!=1||not_alphabet_space!=0)//if inserted text has not one ' ' or has non-alphabetic character
		{
			throw new NameException("Namefield: Insert only alphabet and one space(' ')\n");
		}
		else if (name.charAt(0)==' '||name.charAt(namelen-1)==' ')//if ' ' is at first or end
		{
			throw new NameException("Namefield: Space must be between the alphabets\n");
		}
		
	}
	
	public static void IDVerify(String ID) throws IDException{
		int IDlen=ID.length();
		if (ID==null||ID.equals("")) {//if the field is blank
			throw new IDException("IDfield: The field is blank\n");
		}
		for(int i=0;i<IDlen;i++)
		{
			if(!Character.isDigit(ID.charAt(i)))//if text has any non-digit character
			{
				throw new IDException("IDfield error: Non-Digit input\n");
			}
		}
		if(IDlen!=10)//if ID is not 10digits number
		{
			throw new IDException("IDfield: Length error, form should be 20XX31XXXX\n");
		}
		else if(ID.charAt(0)!='2'||ID.charAt(1)!='0'||ID.charAt(4)!='3'||ID.charAt(5)!='1')// if not the form '20XX31XXXX'
		{
			throw new IDException("IDfield: Form should be 20XX31XXXX\n");
		}
	}
	public static void MajorVerify(String major) throws MajorException{
		
		if (major==null||major.equals("")) {//if the field is blank 
			throw new MajorException("Major field: The field is blank\n");
		}
		
	}
	
	public static void EmailVerify(String email) throws EmailException{
		
		if (email==null||email.equals("")) {//if the field is blank
			throw new EmailException("Email field: The field is blank\n");
		}
		int emaillen=email.length();
		int golbangE_idx=0;
		int dot_idx=0;
		int golbangE_cnt=0;
		int dot_cnt=0;
		for(int i=0;i<emaillen;i++)
		{
			if(email.charAt(i)=='@')
			{
				golbangE_idx=i;
				golbangE_cnt++;
			}
			else if(email.charAt(i)=='.')
			{
				dot_idx=i;
				dot_cnt++;
			}
			else if(!Character.isAlphabetic(email.charAt(i))&&!Character.isDigit(email.charAt(i))&&email.charAt(i)!='@'&&email.charAt(i)!='.')
			{//if text has any non-alphabet or digit character or doesn't have @ or . 
				throw new EmailException("Emailfield: Invalid input. Insert number and alphabet only.\n");
			}
		}
		if(golbangE_cnt!=1||dot_cnt!=1)//if @ or . appear not once
		{
			throw new EmailException("Emailfield: Invalid form. Insert in form XXX@XXX.XXX\n");
		}
		else if(golbangE_idx>dot_idx)//if . appear earlier than @
		{
			throw new EmailException("Emailfield: Invalid form. Insert in form XXX@XXX.XXX\n");
		}
		else if(golbangE_idx==0)//if text starts with @
		{
			throw new EmailException("Emailfield: Invalid form. Insert in form XXX@XXX.XXX\n");
		}
		else if(dot_idx==email.length()-1)//if text ends with .
		{
			throw new EmailException("Emailfield: Invalid form. Insert in form XXX@XXX.XXX\n");
		}
		if(dot_idx==golbangE_idx+1)//if @ is adjacent to .
		{
			throw new EmailException("Emailfield: Invalid form. Insert in form XXX@XXX.XXX\n");
		}
		
	}
	public static void PhoneNumberVerify(String phonenum) throws PhoneNumberException{
		int numlen=phonenum.length();
		if(phonenum==null||phonenum.equals("")) {//if the field is blank
			throw new PhoneNumberException("PhoneNumberfield: The field is blank\n");
		}
		int dash_cnt=0;
		if(numlen!=13)//if text is not the fixed form 
		{
			throw new PhoneNumberException("PhoneNumberfield: Invalid form. Insert in form XXX-XXXX-XXXX\n");
		}
		for(int i=0;i<numlen;i++)
		{
			if(phonenum.charAt(i)=='-')
			{
				dash_cnt++;
				if(i!=3&&i!=8)//if text is not the fixed form
				{
					throw new PhoneNumberException("PhoneNumberfield: Invalid form. Insert in form XXX-XXXX-XXXX\n");
				}
			}
			else if(!Character.isDigit(phonenum.charAt(i))&&phonenum.charAt(i)!='-')//if text has non-digit character except '-'
			{
				throw new PhoneNumberException("PhoneNumberfield: Invalid form. Insert only number and '-'\n");
			}
		}
		if(dash_cnt!=2)//if '-' don't appear twice
		{
			throw new PhoneNumberException("PhoneNumberfield: Invalid form. Insert in form XXX-XXXX-XXXX\n");
		}
		
		
	}
	public static void CaptchaVerify(String captcha, String input) throws CaptchaException{
		
		if (input==null||input.equals(""))//if the field is blank
		{
			throw new CaptchaException("Captchafield: The field is blank\n");
		}
		if(!captcha.equals(input))//if input was wrong
		{
			throw new CaptchaException("Captchafield: Wrong input\n");
		}
		
	}
}
