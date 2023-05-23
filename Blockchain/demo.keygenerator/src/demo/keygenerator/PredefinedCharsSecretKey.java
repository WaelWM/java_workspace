package demo.keygenerator;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;


/* predefined chars secret key generator */

public class PredefinedCharsSecretKey {
    /* handle the secret chars with care!  */    
	
	private static final String SECRET_CHARS = "asddsaqweewqpbnmzxccz098123765543";
    
	public static Key create()
    {
        int keySize = 16;
        return new SecretKeySpec( Arrays.copyOf(SECRET_CHARS.getBytes(), keySize), "AES" );
    }
}