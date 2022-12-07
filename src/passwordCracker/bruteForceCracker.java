package passwordCracker;

import org.mindrot.BCrypt;

public class bruteForceCracker {

public bruteForceCracker() {
	
}
//uses recursion to loop through password string
//taken from stackoverflow, made by FReeze FRancis
public boolean findPassword(String p, String pswd, int length) {

    if (length == pswd.length()) {
    	//System.out.println(pswd);
        if (BCrypt.checkpw(pswd, p))
            System.out.println(" your password is  " + pswd);
        return BCrypt.checkpw(pswd, p);

    }

    String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    for (int i = 0; i < alpha.length(); i++) {
    	
        if (findPassword(p, pswd + alpha.charAt(i), length)) 
            return true;
        	
    }
    return BCrypt.checkpw(pswd, p);
}

}

