package demo.encode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Exel {
    public static void main(String[] args) {
        String inputFile = "D:\\eclipseWorkspace\\demo.encode\\keanggotaan-majlis-perubatan-tradisional-dan-komplementari-ptk.csv";
        String outputFile = "Data.txt";
        String secretKey = "MySecretKey12345"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            Key aesKey = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                

                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
                byte[] encryptedIDBytes = cipher.doFinal(name.getBytes());
                String encryptedID = Base64.getEncoder().encodeToString(encryptedIDBytes);

               writer.write(name + "\t" + encryptedID + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}