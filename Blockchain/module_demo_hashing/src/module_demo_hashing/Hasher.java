package module_demo_hashing;


import java.security.MessageDigest;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;



public class Hasher {
	
	// +md5(String) : String
	
	
	public static String md5(String input)
	{
	    return hash(input, "MD5");
	}

	public static String md5(String input, byte[] salt)
	{
	    return hash(input, "MD5", salt);
	}

	private static String hash(String input, String algorithm) 
	{ 
	    var hash = "";
	    try {
	        
	        var md = MessageDigest.getInstance(algorithm);
	        //fetch the input byte arr into MessageDigest instance
	        md.update(input.getBytes());
	        //digest the input byte arr
	        byte[] hashBytes = md.digest();
	        //convert hashBytes to String
	        //hash = Base64.getEncoder().encodeToString(hashBytes);
	        
	        // convert it into HEX format
	        hash = Hex.encodeHexString(hashBytes);
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return hash;
	}

	private static String hash(String input, String algorithm, byte[] salt) 
	{ 
	    var hash = "";
	    try {
	        
	        var md = MessageDigest.getInstance(algorithm);
	        //fetch the input byte arr into MessageDigest instance
	        md.update(input.getBytes());
	        md.update(salt);
	        //digest the input byte arr
	        byte[] hashBytes = md.digest();
	        //convert hashBytes to String
	        //hash = Base64.getEncoder().encodeToString(hashBytes);
	        
	        // convert it into HEX format
	        hash = Hex.encodeHexString(hashBytes);
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return hash;
	}
	
	
	//hash(String) : String
	
	

}
