package demo.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

public class Asymmetric {
    /* Cipher object is used to facilitates the operations */    
	private Cipher cipher;
    /* constructor */    
    
    public Asymmetric(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Asymmetric() {
    	this("RSA"); //calls the constructor by matching the input-args list
    }
        
           
    public String encrypt( String data, PublicKey publicKey ) throws Exception    {
        String cipherText = null;
        //init        
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        //encrypt        
        byte[] cipherBytes = cipher.doFinal( data.getBytes() );
        //convert to String        
        cipherText = Base64.getEncoder().encodeToString(cipherBytes);
        return cipherText;
    }
    
    public String decrypt( String cipherText, PrivateKey privateKey ) throws Exception    {
        //init        
    	cipher.init(Cipher.DECRYPT_MODE, privateKey);
        //convert to byte[]        
    	byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        //decrypt       
    	byte[] dataBytes = cipher.doFinal(cipherBytes);
        return new String(dataBytes);
    }
    
    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048); // key size
        return generator.generateKeyPair();
    }
}
