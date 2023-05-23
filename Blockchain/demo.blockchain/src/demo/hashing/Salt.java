 package demo.hashing;

import java.security.SecureRandom;

// Purpose: To increase security value

public class Salt {
	
	public static byte[] generate( ) {
		int amount = 16;
		
		SecureRandom sr = new SecureRandom();
		byte[] b = new byte[amount];
		sr.nextBytes(b);
		return b;	
	}
	
}
