package demo.keygenerator;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class App {
	
	/**
	 * two methods to create symmetric key:
	 * 
	 *
	 */

	public static void main(String[] args) throws Exception {
		
		//Key secretKey = PredefinedCharsSecretKey.create();
		//Key secretKey = RandomSecretKey.create();
		
		//String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		
		//System.out.println("Secret Key = " + secretKeyString);
		
		//Show keypair
//		MyKeyPair.create();
//		byte[] publicKey = MyKeyPair.getPublicKey().getEncoded();
//		byte[] privateKey = MyKeyPair.getPrivateKey().getEncoded();
		
//		// DIR = MyKeyPair; publicKey file = publicKey; privateKey = PrivateKey
//		MyKeyPair.put(publicKey, "MyKeyPair/PublicKey");
//		MyKeyPair.put(privateKey, "MyKeyPair/PrivateKey");
//		System.out.println("Public Key = "+ Base64.getEncoder().encodeToString(publicKey));
//		System.out.println("\nPrivate Key = "+ Base64.getEncoder().encodeToString(privateKey));
		
		PublicKey pubKey = KeyAccess.getPublicKey("MyKeyPair/PublicKey");
		PrivateKey PrivKey = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
		
		System.out.println("Public Key = " + Base64.getEncoder().encodeToString(pubKey.getEncoded()));
		System.out.println("\nPrivate Key = " + Base64.getEncoder().encodeToString(PrivKey.getEncoded()));
		
		
		
	}
}
