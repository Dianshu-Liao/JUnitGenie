package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Blake3;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_Blake3_initKeyedHash_byte_____cfg_path_1_Test {

    private static final int KEY_LEN = 32;

    @Test(timeout = 4000)
    public void testInitKeyedHash_ValidKey() {
        byte[] validKey = new byte[KEY_LEN]; // Create a valid key of 32 bytes
        try {
            Blake3 result = Blake3.initKeyedHash(validKey);
            assertNotNull(result); // Ensure that the result is not null
        } catch (Exception e) {
            fail("Exception should not have been thrown for a valid key");
        }
    }

    @Test(timeout = 4000)
    public void testInitKeyedHash_NullKey() {
        try {
            Blake3.initKeyedHash(null);
            fail("Expected NullPointerException for null key");
        } catch (NullPointerException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected NullPointerException, but got a different exception: " + e);
        }
    }

    @Test(timeout = 4000)
    public void testInitKeyedHash_InvalidKeyLength() {
        byte[] invalidKey = new byte[31]; // Create an invalid key of 31 bytes
        try {
            Blake3.initKeyedHash(invalidKey);
            fail("Expected IllegalArgumentException for key length not equal to 32");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got a different exception: " + e);
        }
    }

}