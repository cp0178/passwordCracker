package passwordCracker;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.mindrot.BCrypt;


public class dictionCracker {
private	ArrayList<String> list = new ArrayList<String>();	
//password file is loaded into an ArrayList
public dictionCracker() {
	Scanner s;
	try {
		InputStream in = getClass().getResourceAsStream("xato-net-10-million-passwords-10000.txt");
		s = new Scanner(in);
		while(s.hasNext()) {
			list.add(s.next());
		}
		s.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
//checks the hashed passed in with the passwords and the password file
public String checkPass(String hash){
	String passHash = null;
	boolean endLoop= false;
	//looping through the array comparing password hashes
	for(int i = 0; i < list.size()&& endLoop == false;i++) {
		if(BCrypt.checkpw(list.get(i), hash)) {
			passHash = list.get(i); 
			endLoop = true;
		}
	}
	return passHash;
}
}
