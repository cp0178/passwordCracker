package passwordCracker;

import org.mindrot.BCrypt;

public class bCHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 0 ) {
			String pass = args[0];
			System.out.println(BCrypt.hashpw(pass, BCrypt.gensalt()));
		}
		
	}

}
