package passwordCracker;

import java.util.Scanner;





public class passwordCrackerRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		
		
		dictionCracker a = new dictionCracker();
		String hashed = "";
		//used to get the algorithm	
		String alg = args[0];
		
		
		//used to choose diction or brute force
		String bFOrD = "";
		if(args.length> 1) {
			bFOrD = args[1];
		}
		//takes the hash
		hashed = args[2];
		
		//check for md5
        if (alg.equals("md5")) {
        	
        	if(bFOrD.equals("bF")) {
        		//run brute force
        		System.out.println(" your password is  " + MdBruteForce.passwordCrack(hashed));
        		//run diction
        	}else if(bFOrD.equals("D")) {
        		
        		MdDiction mdDict = new MdDiction();
        		System.out.println(" your password is  " + mdDict.checkPass(hashed));
        		
        	}
        } else if (alg.equals("sha256")) {
        	
        	if(bFOrD.equals("bF")) {
        		
        		System.out.println(" your password is  " + ShaBruteForce.passwordCrack(hashed));
        	}else if(bFOrD.equals("D")) {
        		
        		ShaDiction shaDict = new ShaDiction();
        		System.out.println(" your password is  " + shaDict.checkPass(hashed));
        		
        	}
        	
        	
		} else if (alg.equals("bcrypt")) {
			
			
			if(bFOrD.equals("D")) {
				
				String b = a.checkPass(hashed);
				System.out.println(" your password is  " + b);
				
			}else if(bFOrD.equals("bF")) {
				
				bruteForceCracker c = new bruteForceCracker();
				boolean d = false;
				for(int i = 1; i<=7 && d== false; i++) {
					d= c.findPassword(hashed,"",i);
					
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
