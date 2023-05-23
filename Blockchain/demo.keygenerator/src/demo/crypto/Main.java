package demo.crypto;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Main {
	
	
	public static void main(String[] args) throws Exception { 
		
		Asymmetric  asymm = new Asymmetric();
		KeyPair keyPair = asymm.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
		
		System.out.println("Public Key = " + publicKeyString);
		System.out.println("\nPrivate Key = " + privateKeyString);
		
	}
}
