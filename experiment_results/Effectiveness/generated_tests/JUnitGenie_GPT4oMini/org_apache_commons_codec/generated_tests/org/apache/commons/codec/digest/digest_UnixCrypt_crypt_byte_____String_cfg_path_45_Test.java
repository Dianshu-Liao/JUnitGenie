package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_45_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = "testData".getBytes(); // Example data
        String salt = "ab"; // Valid 2-character salt

        String result = null;
        try {
            result = UnixCrypt.crypt(original, salt);
        } catch (Exception e) {
            fail("Exception should not occur with valid salt: " + e.getMessage());
        }

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = "testData".getBytes(); // Example data

        String result = null;
        try {
            result = UnixCrypt.crypt(original, null); // null salt should invoke random salt generation
        } catch (Exception e) {
            fail("Exception should not occur with null salt: " + e.getMessage());
        }

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = "testData".getBytes(); // Example data
        String invalidSalt = "invalidSalt"; // More than 2 characters

        try {
            UnixCrypt.crypt(original, invalidSalt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + invalidSalt, e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithInsufficientBytes() {
        byte[] original = new byte[7]; // Less than 8 bytes, should handle error gracefully
        String salt = "ab"; // Valid salt

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected exception due to insufficient bytes in original array");
        } catch (Exception e) {
            assertTrue(e instanceof ArrayIndexOutOfBoundsException); // Check the type of exception
        }
    }

}