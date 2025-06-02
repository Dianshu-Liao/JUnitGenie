package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = new byte[]{1, 2, 3, 4, 5}; // Example byte array
        String invalidSalt = "invalid_salt"; // This salt does not match the CRYPT_SALT_PATTERN

        try {
            UnixCrypt.crypt(original, invalidSalt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + invalidSalt, e.getMessage());
        }
    }

}