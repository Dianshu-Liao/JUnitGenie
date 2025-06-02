package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_48_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 }; // valid original byte array
        String salt = "ab"; // valid salt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        assertEquals(13, result.length()); // Since the crypt method returns a specific format
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String salt = null; // null salt, should invoke getRandomSalt

        String result = UnixCrypt.crypt(original, salt);
        assertNotNull(result);
        // You can't assert the exact value due to random salt but it should be of expected length
        assertEquals(13, result.length());
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String salt = "invalid_salt"; // invalid salt

        try {
            UnixCrypt.crypt(original, salt);
            fail("Expected IllegalArgumentException for invalid salt");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: " + salt, e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithEmptyByteArray() {
        byte[] original = {}; // Edge case: empty original byte array
        String salt = "ab"; // valid salt

        try {
            String result = UnixCrypt.crypt(original, salt);
            assertNotNull(result);
            assertEquals(13, result.length()); // Testing result length even for empty input
        } catch (Exception e) {
            fail("Should not have thrown an exception for empty byte array");
        }
    }

}