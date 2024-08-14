package resource;

import java.io.IOException;

import com.util.FixKareSMS;

public class SendMessage {

	public static void main(String[] args) {
		
		FixKareSMS fixKareSMS=new FixKareSMS();
		
		String ContactNo="9657235731";
		String MSG="Hello";
		
		try {
			fixKareSMS.sendSMS(ContactNo, MSG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
