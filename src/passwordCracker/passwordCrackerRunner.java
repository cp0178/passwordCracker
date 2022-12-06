package passwordCracker;

import java.util.Scanner;

import org.mindrot.BCrypt;



public class passwordCrackerRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner scan = new Scanner(System.in);
        String userPassword = scan.nextLine();
		
		dictionCracker a = new dictionCracker();
		String hashed = "";
				
		String alg = args[0];
		
		
		
		String bFOrD = "";
		if(args.length> 1) {
			bFOrD = args[1];
		}
		
        if (alg.equals("md5")) {
        	
        	if(bFOrD.equals("bF")) {
        		MdBruteForce mdb = new  MdBruteForce();
        		hashed = mdb.getMd5(userPassword);
        		String hashIn = passwordCrackerRunner.setHash(scan, hashed);
        		System.out.println(" your password is  " + mdb.passwordCrack(hashIn));
        	}else if(bFOrD.equals("D")) {
        		
        	}
        } else if (alg.equals("sha256")) {
        	
        	if(bFOrD.equals("bF")) {
        		//ShaBruteForce mdb = new  ShaBruteForce();
        		hashed = ShaBruteForce.getSHA(userPassword);
        		String hashIn = passwordCrackerRunner.setHash(scan, hashed);
        		System.out.println(" your password is  " + ShaBruteForce.passwordCrack(hashIn));
        	}else if(bFOrD.equals("D")) {
        		
        	}
        	
        	
		} else if (alg.equals("bcrypt")) {
			hashed= BCrypt.hashpw(userPassword, BCrypt.gensalt());
			String hashIn = passwordCrackerRunner.setHash(scan, hashed);
			
			if(bFOrD.equals("D")) {
				
				String b = a.checkPass(hashIn);
				System.out.println(" your password is  " + b);
				
			}else if(bFOrD.equals("bF")) {
				
				bruteForceCracker c = new bruteForceCracker();
				boolean d = false;
				for(int i = 1; i<=7 && d== false; i++) {
					d= c.findPassword(hashIn,"",i);
					
				}

			}
			
		}
        
		
				
	}
	
	public static String setHash(Scanner scan, String hashPassword) {
		
		System.out.println("Your hash is  "+hashPassword + "\n type in your hash:  ");
        String hashIn = scan.nextLine();
        return hashIn;
	}

}
