package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.UnixCrypt;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_UnixCrypt_crypt_byte_____String_cfg_path_49_Test {

    @Test(timeout = 4000)
    public void testCryptWithValidInputAndGeneratedSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String salt = null; // This will trigger salt generation
        
        try {
            String result = UnixCrypt.crypt(original, salt);
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testCryptWithValidInputAndSpecificSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String salt = "ab"; // Assuming 'ab' is a valid salt
        
        try {
            String result = UnixCrypt.crypt(original, salt);
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testCryptWithNullSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String salt = null; // Triggers random salt generation
        
        try {
            String result = UnixCrypt.crypt(original, salt);
            assertNotNull(result);
            assertFalse(result.isEmpty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testCryptWithInvalidSalt() {
        byte[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
        String salt = "invalid_salt"; // This should trigger IllegalArgumentException
        
        try {
            UnixCrypt.crypt(original, salt);
            fail("IllegalArgumentException expected for invalid salt.");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid salt value: invalid_salt", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getMessage());
        }
    }

}