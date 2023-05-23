package demo.crypto;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;

public class Symmetric {
    /* Cipher object is used to facilitates the operations */    
	private Cipher cipher;
    /* constructor */    
    
    public Symmetric(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Symmetric() {
    	this("AES"); //calls the constructor by matching the input-args list
    }
        
           
    public String encrypt( String data, Key key ) throws Exception    {
        String cipherText = null;
        //init        
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //encrypt        
        byte[] cipherBytes = cipher.doFinal( data.getBytes() );
        //convert to String        
        cipherText = Base64.getEncoder().encodeToString(cipherBytes);
        return cipherText;
    }
    
    public String decrypt( String cipherText, Key secretKey ) throws Exception    {
        //init        
    	cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //convert to byte[]        
    	byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        //decrypt       
    	byte[] dataBytes = cipher.doFinal(cipherBytes);
        return new String(dataBytes);
        
 
    }
}