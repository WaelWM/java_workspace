package demo.crypto;

import java.security.Key;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import demo.keygenerator.MyKeyPair;
import demo.keygenerator.PredefinedCharsSecretKey;
import demo.keygenerator.RandomSecretKey;

public class App {
	
	/**
	 * two methods to create symmetric key:
	 * 
	 *
	 */

	public static void main(String[] args) throws Exception { 
		
		Key secretKey = PredefinedCharsSecretKey.create();
		
		Symmetric  symm = new Symmetric ();
		
		 String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("Secret Key = " + secretKeyString);
		
		// tesing on - "Hello, I have done with symemtric crypto!"
		String msg = "hello, I have done with symemtric crypto!";
		
		//Encrypt it!
		String encrypted = symm.encrypt(msg, secretKey);
		System.out.println("Encrypted: " + encrypted);
		TimeUnit.SECONDS.sleep(1);
		
		//Decrypt it!
		String decrypted = symm.decrypt(encrypted, secretKey);
		

		System.out.println("\n>>>>>>>>>> Original Content: " + decrypted);

	}
}
