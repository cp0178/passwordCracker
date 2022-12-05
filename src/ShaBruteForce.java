import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class ShaBruteForce {

    static String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String getSHA(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());


            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 64) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    // Gotten from apache.org, repeat function from StringUtils
    public static String repeat(final char ch, final int repeat) {
        if (repeat <= 0) {
            return "";
        }
        final char[] buf = new char[repeat];
        Arrays.fill(buf, ch);
        return new String(buf);
    }

    public static boolean allNine(String f) {
        for (int i = 0; i < f.length(); i++) {
            if (f.charAt(i) != '9') {
                return false;

            }
        }
        return true;
    }
    public static String passwordCrack (String target )
    {
        int passwordLength = 1;
        while(true){
            String password = repeat('a', passwordLength);
            while(!allNine(password)){
                System.out.println(password);
                char carryChar = 'a';
                int i = password.length()-1;
                while (carryChar == 'a'){
                    carryChar= nextDigit(password.charAt(i));
                    StringBuffer temp = new StringBuffer(password);
                    temp.setCharAt(i--, carryChar);
                    password = temp.toString();

                }
                if (getSHA(password).equals(target)){
                    return password;
                }

            }
            passwordLength++;
        }
    }


    static char nextDigit(char c){
        if( c != '0'){
            int k = allChars.indexOf(c);
            k++;
            return allChars.charAt(k);
        }
        else{
            return 'a';
        }
    }

    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        String userPassword = scan.nextLine();
        String hashPassword = getSHA(userPassword);
        System.out.println("Your hash is  "+hashPassword + "\n type in your hash:  ");
        String hashIn = scan.nextLine();
        System.out.println(" your password is  " + passwordCrack(hashIn));
    }

}
