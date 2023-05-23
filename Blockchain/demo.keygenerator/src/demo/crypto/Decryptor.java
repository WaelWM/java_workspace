package demo.crypto;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decryptor {

    public static void main(String[] args) throws Exception {
        
        String secretKeyStr = "YXNkZHNhcXdlZXdxcGJubQ==";
        byte[] decodedKey = Base64.getDecoder().decode(secretKeyStr);
        Key secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        String encryptedStr = "wRw6nNxxzqwGSMjU5Xmkc0jOg3CIutqwTW8AOhwuEOI=";
        byte[] encryptedData = Base64.getDecoder().decode(encryptedStr);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedData = cipher.doFinal(encryptedData);
        String decryptedStr = new String(decryptedData, StandardCharsets.UTF_8);

        System.out.println("Decrypted message: " + decryptedStr);
    }
}
