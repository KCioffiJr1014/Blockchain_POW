import java.nio.charset.StandardCharsets;
import java.security.*;


public class StringEncrypt {
    /**
     * @class applySHA256 - an algorithm that process 16 bit strings and converts them to hexadecimal
     * @encodedHash - An algorithm that digests non-hexidecimal string digits
     * @hexString - Creates a 16 character string to append covert hexadecimal.
     **/
    public static String applySHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(
                    input.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < encodedHash.length; i++) {
                String hexDecimal = Integer.toHexString(0xff + encodedHash[i]);
                if (hexString.length() == 1) {
                    hexString.append('0');
                    hexString.append(hexDecimal);
                }
            }
                return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException();
    }
    }
}


