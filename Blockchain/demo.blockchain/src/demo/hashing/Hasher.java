package demo.hashing;


import java.security.MessageDigest;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;


public class Hasher {

    public static String sha256(String input) {
        return hash(input, "SHA-256");
    }

    public static String sha256(String input, byte[] salt) {
        return hash(input, "SHA-256", salt);
    }

    private static String hash(String input, String algorithm) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    private static String hash(String input, String algorithm, byte[] salt) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            md.update(salt);
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }
}
	
	


