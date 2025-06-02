package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidSaltAndOriginal() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        String validSalt = "xy"; // Assume 'xy' is valid based on CRYPT_SALT_PATTERN
        String result = null;
        try {
            result = UnixCrypt.crypt(original, validSalt);
        } catch (IllegalArgumentException e) {
            fail("No exception should be thrown for valid salt: " + e.getMessage());
        }
        assertNotNull("Result should not be null", result);
    }

    @Test(timeout = 4000)
    public void testCryptWithNullSaltUsesRandomSalt() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        String result = null;
        try {
            result = UnixCrypt.crypt(original, null);
        } catch (IllegalArgumentException e) {
            fail("No exception should be thrown when salt is null: " + e.getMessage());
        }
        assertNotNull("Result should not be null even with null salt", result);
    }

    @Test(timeout = 4000)
    public void testCryptWithInvalidSaltPattern() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        String invalidSalt = "invalid_salt"; // Invalid based on CRYPT_SALT_PATTERN
        try {
            UnixCrypt.crypt(original, invalidSalt);
            fail("Expected IllegalArgumentException for invalid salt pattern.");
        } catch (IllegalArgumentException expected) {
            assertEquals("Invalid salt value: invalid_salt", expected.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCryptWithNullOriginal() {
        byte[] original = null;
        String validSalt = "xy"; // Assume 'xy' is valid based on CRYPT_SALT_PATTERN
        try {
            UnixCrypt.crypt(original, validSalt);
            fail("Expected NullPointerException for null original.");
        } catch (NullPointerException expected) {
            // expected
        }
    }

}