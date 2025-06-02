package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = new byte[8]; // Valid input of 8 bytes
        String salt = "ab"; // Valid salt

        // Fill the original byte array with some data
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = new byte[8]; // Valid input of 8 bytes
        String salt = null; // Null salt, should generate random salt

        // Fill the original byte array with some data
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = new byte[8]; // Valid input of 8 bytes
        String salt = "invalid_salt"; // Invalid salt

        // Fill the original byte array with some data
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + salt, e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithShortOriginal() {
        byte[] original = new byte[7]; // Invalid input of less than 8 bytes
        String salt = "ab"; // Valid salt

        // Fill the original byte array with some data
        for (int i = 0; i < original.length; i++) {
            original[i] = (byte) i;
        }

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected an exception due to insufficient original length");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception due to insufficient length
        }
    }

}