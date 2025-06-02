package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.apache.commons.codec.digest.B64;
import org.junit.Test;
import static org.junit.Assert.*;
import java.security.SecureRandom;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_42_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        String salt = "ab"; // valid salt
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        String salt = null; // salt is null, should generate random salt
        String result = null;
        try {
            result = UnixCrypt.crypt(original, salt);
        } catch (Exception e) {
            fail("Exception should not be thrown for null salt: " + e.getMessage());
        }
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        String salt = "invalid_salt"; // invalid salt
        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + salt, e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithShortOriginal() {
        byte[] original = {1, 2}; // less than 8 bytes
        String salt = "ab"; // valid salt
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

}