package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_44_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        String salt = "ab"; // Valid salt
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        String salt = null; // Should generate random salt
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = {1, 2, 3, 4, 5, 6, 7, 8};
        String salt = "invalid_salt"; // Invalid salt
        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + salt, e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithShortKey() {
        byte[] original = {1, 2}; // Short key
        String salt = "ab"; // Valid salt
        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected ArrayIndexOutOfBoundsException due to short key");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}