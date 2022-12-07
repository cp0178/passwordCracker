package passwordCracker;


import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.math.*;
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
    
public String checkPass(String hashIn) {
    	
    	try {
    		InputStream in;
            // creating a scanner to have the user type in the plain text they want
             // we hash the plaintext and store the password
             // we parse through the txt file and has each password and compare it to the hash
             // if the two hashes match each other then output the hash and plain password if not output password not in list
             // ask user if they want to use bruteforcce instead
             
    		in = getClass().getResourceAsStream("million.txt");
    		Scanner fileScan  = new Scanner(in);
             
             boolean found = false;
             while (fileScan.hasNext()) {
                 String currentWord = fileScan.next();
                 String fileHash = toHexString(getSHA(currentWord));
                 if (fileHash.equals(hashIn)) {
                     
                     found = true;
                     fileScan.close();
                     return currentWord;
                 }
             }
             fileScan.close();
             if (!found) {
                 System.out.println("Password not found in list.");
             }
         }
         catch (Exception e) {
             System.out.println("File not found: " + e);
         }
    	return "";
    }
   

    
}







