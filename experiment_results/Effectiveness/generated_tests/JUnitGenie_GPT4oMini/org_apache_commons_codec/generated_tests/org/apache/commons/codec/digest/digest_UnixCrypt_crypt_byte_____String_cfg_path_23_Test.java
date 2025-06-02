package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Valid 8-byte array
        String salt = "ab"; // Valid salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Expected length for UnixCrypt output
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Valid 8-byte array
        String salt = null; // Null salt should generate random salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Expected length for UnixCrypt output
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCryptWithInvalidSalt() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Valid 8-byte array
        String salt = "invalid_salt"; // Invalid salt

        UnixCrypt.crypt(original, salt); // Should throw IllegalArgumentException
    }

    @Test(timeout = 4000)
    public void testCryptWithEdgeCaseSalt() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Valid 8-byte array
        String salt = "aa"; // Edge case salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Expected length for UnixCrypt output
    }

}