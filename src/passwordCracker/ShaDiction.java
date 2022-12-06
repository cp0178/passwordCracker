package passwordCracker;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.math.*;
import java.util.Arrays;
import java.util.Scanner;

public class ShaDiction {
	
	public ShaDiction() {
		
	}
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
    
    public void checkPass(String hashin){
    	
    	InputStream in;
		try {
			
			in = getClass().getResourceAsStream("million.txt");
			
		    Scanner fileScan  = new Scanner(in);
		    boolean found = false;
		    
		    while (fileScan.hasNext()) {
                String currentWord = fileScan.next();
                String fileHash = toHexString(getSHA(currentWord));
                if (fileHash.equals(hashin)) {
                    System.out.println("SHA-256: \t" + fileHash + "\t\t Your password: " + currentWord);
                    found = true;
                }
            }
		    fileScan.close();
            if (!found) {
                System.out.println("Password not found in list.");
            }
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No algorithm: " + e);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		
    	
    }

    public static void main(String args[]) {
        	
       
        try {
        	
       		
        	
            Scanner scan = new Scanner(System.in);
           
            Scanner fileScan = new Scanner(new File("C:/Users/100117043/OneDrive - Clear Creek ISD/PasswordCrackingBruteForce/src/million.txt"));
            String s = scan.next();
            String hash = toHexString(getSHA(s));
            System.out.println(" your hash is  " + hash + "\n type in your hash:");
            String hashIn = scan.next();
            boolean found = false;
            while (fileScan.hasNext()) {
                String currentWord = fileScan.next();
                String fileHash = toHexString(getSHA(currentWord));
                if (fileHash.equals(hashIn)) {
                    System.out.println("SHA-256: \t" + fileHash + "\t\t Your password: " + currentWord);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Password not found in list.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No algorithm: " + e);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

    // Driver code






