package demo.keygenerator;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;


public class RandomSecretKey {
    public static Key create()
    {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(256, new SecureRandom());
            return kg.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}