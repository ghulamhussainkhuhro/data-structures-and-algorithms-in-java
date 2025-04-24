package BlockchainHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlockchainHashing {
    
    // Method to generate a SHA-256 hash
    public static String generateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) { 
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String blockData = "Block data: transaction 1 from Alice to Bob";
        String blockHash = generateHash(blockData);

        System.out.println("Block Data: " + blockData);
        System.out.println("Block Hash: " + blockHash);
    }
}
