package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_34_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = new byte[8]; // Must be at least 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i; // Fill with sample data
        }
        String salt = "ab"; // Valid salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Expected length for UnixCrypt result
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = new byte[8]; // Must be at least 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i; // Fill with sample data
        }
        String salt = null; // Testing with null salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Expected length for UnixCrypt result
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = new byte[8]; // Must be at least 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i; // Fill with sample data
        }
        String salt = "invalid_salt"; // Invalid salt

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + salt, e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithShortOriginal() {
        byte[] original = new byte[7]; // Less than 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i; // Fill with sample data
        }
        String salt = "ab"; // Valid salt

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected ArrayIndexOutOfBoundsException due to short original array");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}