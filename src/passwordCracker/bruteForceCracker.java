package passwordCracker;

import org.mindrot.BCrypt;

public class bruteForceCracker {

public bruteForceCracker() {
	
}

public boolean findPassword(String p, String pswd, int length) {

    if (length == pswd.length()) {
        if (BCrypt.checkpw(pswd, p))
            System.out.println(pswd);
        return BCrypt.checkpw(pswd, p);

    }

    String alpha = "abcdefghijklmnopqrstuvwxyz0123456789";
    for (int i = 0; i < alpha.length(); i++) {
        if (findPassword(p, pswd + alpha.charAt(i), length)) 
        	
            return true;
        	
    }
    return BCrypt.checkpw(pswd, p);
}

}

