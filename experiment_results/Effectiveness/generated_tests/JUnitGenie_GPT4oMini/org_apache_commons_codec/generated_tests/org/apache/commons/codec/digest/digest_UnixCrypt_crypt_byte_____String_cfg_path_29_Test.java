package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8}; // Example byte array
        String result = null;
        try {
            result = UnixCrypt.crypt(original, null);
        } catch (Exception e) {
            fail("Exception should not be thrown for null salt: " + e.getMessage());
        }
        assertNotNull("Result should not be null", result);
    }

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8}; // Example byte array
        String salt = "ab"; // Valid salt
        String result = null;
        try {
            result = UnixCrypt.crypt(original, salt);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid salt: " + e.getMessage());
        }
        assertNotNull("Result should not be null", result);
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8}; // Example byte array
        String invalidSalt = "invalid_salt"; // Invalid salt
        try {
            UnixCrypt.crypt(original, invalidSalt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + invalidSalt, e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

}