package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Blake3;
import org.junit.Test;
import static org.junit.Assert.fail;

public class digest_Blake3_initKeyedHash_byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInitKeyedHashWithInvalidKeyLength() {
        byte[] invalidKey = new byte[31]; // Key length is not 32 bytes
        try {
            Blake3.initKeyedHash(invalidKey);
            fail("Expected IllegalArgumentException for key length not equal to 32 bytes");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert(e.getMessage().equals("Blake3 keys must be 32 bytes"));
        }
    }

    @Test(timeout = 4000)
    public void testInitKeyedHashWithNullKey() {
        try {
            Blake3.initKeyedHash(null);
            fail("Expected NullPointerException for null key");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInitKeyedHashWithValidKey() {
        byte[] validKey = new byte[32]; // Key length is 32 bytes
        try {
            Blake3 result = Blake3.initKeyedHash(validKey);
            // Add assertions to verify the result if necessary
        } catch (Exception e) {
            fail("Did not expect an exception for valid key");
        }
    }

}