package passwordCracker;

import org.mindrot.BCrypt;

public class bCHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//generates sample hashes
		if(args.length > 0 ) {
			String pass = args[1];
			String alg = args[0];
			
			if (alg.equals("md5")) {
				System.out.println("Your hash is  "+MdBruteForce.getMd5(pass));
			} else if (alg.equals("sha256")) {
				System.out.println("Your hash is  "+ShaBruteForce.getSHA(pass));
			} else if (alg.equals("bcrypt")) {
				System.out.println("Your hash is  "+BCrypt.hashpw(pass, BCrypt.gensalt()));
			}
			
		}
		
	}

}
