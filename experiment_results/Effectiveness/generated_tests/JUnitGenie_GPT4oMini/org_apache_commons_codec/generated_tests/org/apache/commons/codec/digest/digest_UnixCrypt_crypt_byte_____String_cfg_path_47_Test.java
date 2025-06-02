package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_47_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = {1, 2, 3, 4, 5}; // Valid byte array
        String salt = "ab"; // Valid salt
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = {1, 2, 3, 4, 5}; // Valid byte array
        String salt = null; // Null salt to trigger random salt generation
        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Assuming the expected length of the result
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = {1, 2, 3, 4, 5}; // Valid byte array
        String salt = "invalid_salt"; // Invalid salt
        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: invalid_salt", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithEmptyByteArray() {
        byte[] original = {}; // Empty byte array
        String salt = "ab"; // Valid salt
        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected ArrayIndexOutOfBoundsException due to empty byte array");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}