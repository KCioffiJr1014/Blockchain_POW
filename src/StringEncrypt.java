import java.nio.charset.StandardCharsets;
import java.security.*;


public class StringEncrypt {
    /**
     * @class applySHA256 - an algorithm that process 16 bit strings and converts them to hexadecimal
     * @encodedHash - An algorithm that digests non-hexadecimal string digits
     * @hexString - Creates a 16 character string to append hexadecimal.
     **/
    public static String applySHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}


