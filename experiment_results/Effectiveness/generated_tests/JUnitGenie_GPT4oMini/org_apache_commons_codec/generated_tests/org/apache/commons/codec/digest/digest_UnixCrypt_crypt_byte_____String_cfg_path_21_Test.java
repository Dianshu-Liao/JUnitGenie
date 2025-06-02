package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = {1, 2, 3, 4, 5}; // Valid byte array
        String salt = "ab"; // Valid salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Length based on expected crypt output
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = {1, 2, 3, 4, 5}; // Valid byte array
        String salt = null; // Null salt should trigger random salt generation

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Length based on expected crypt output
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCryptWithInvalidSalt() {
        byte[] original = {1, 2, 3, 4, 5}; // Valid byte array
        String salt = "invalidSalt"; // Invalid salt

        try {
            UnixCrypt.crypt(original, salt);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + salt, e.getMessage());
            throw e; // Rethrow to satisfy @Test's expected exception
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithShortByteArray() {
        byte[] original = {1, 2}; // Short byte array (less than 4)
        String salt = "ab"; // Valid salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testCryptWithValidLongByteArray() {
        byte[] original = new byte[8]; // Valid byte array
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i; // Fill with values from 0 to 7
        }

        String salt = "ab"; // Valid salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
    }

}