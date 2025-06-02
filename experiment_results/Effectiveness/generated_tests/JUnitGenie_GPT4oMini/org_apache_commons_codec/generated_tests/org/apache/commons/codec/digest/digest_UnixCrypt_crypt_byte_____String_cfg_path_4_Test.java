package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = new byte[8]; // Must be at least 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }
        String salt = "ab"; // Valid salt

        String result = null;
        try {
            result = UnixCrypt.crypt(original, salt);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the output length is 13 characters
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = new byte[8]; // Must be at least 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }
        String salt = null; // Testing with null salt

        String result = null;
        try {
            result = UnixCrypt.crypt(original, salt);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the output length is 13 characters
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = new byte[8]; // Must be at least 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }
        String salt = "invalid_salt"; // Invalid salt

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithShortOriginal() {
        byte[] original = new byte[7]; // Less than 8 bytes
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }
        String salt = "ab"; // Valid salt

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected an exception due to short original byte array");
        } catch (Exception e) {
            // Expected exception
        }
    }

}