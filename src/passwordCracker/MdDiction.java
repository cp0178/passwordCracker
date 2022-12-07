package passwordCracker;

import java.security.*;
import java.math.*;
import java.io.*;
import java.util.Scanner;

public class MdDiction {
    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());


            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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
                 String fileHash = getMd5(currentWord);
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