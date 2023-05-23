package demo.signature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TransactionSignature {
    public static void main(String[] args) {
        String transactionRecord = "alice|bob|credit|100.0";
        		//"alice|bob|debit|200.0";
        try {
            // Create a MessageDigest instance with the SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Compute the digest of the transaction record
            byte[] hash = digest.digest(transactionRecord.getBytes());

            // Convert the hash to a hexadecimal string
            String signature = bytesToHex(hash);

            // Print the transaction record and its signature
            System.out.println("TRANX: " + transactionRecord);
            System.out.println("SIGNATURE: " + signature);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert a byte array to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
