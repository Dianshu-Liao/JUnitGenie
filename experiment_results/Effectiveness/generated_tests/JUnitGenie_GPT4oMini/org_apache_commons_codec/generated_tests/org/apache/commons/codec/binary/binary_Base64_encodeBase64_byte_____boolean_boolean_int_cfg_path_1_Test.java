package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base64_encodeBase64_byte_____boolean_boolean_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeBase64_EmptyArray() {
        byte[] binaryData = new byte[0]; // Initialized but empty array
        boolean isChunked = false; // Example value
        boolean urlSafe = true; // Example value
        int maxResultSize = 10; // Example value

        // Call the focal method
        byte[] result = Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);

        // Verify the result
        assertArrayEquals(binaryData, result);
    }

    @Test(timeout = 4000)
    public void testEncodeBase64_ThrowsException() {
        byte[] binaryData = new byte[]{1, 2, 3}; // Example non-empty array
        boolean isChunked = false; // Example value
        boolean urlSafe = true; // Example value
        int maxResultSize = 2; // Set to a value less than the expected output size

        try {
            // Call the focal method
            Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Verify the exception message
            assertEquals("Input array too big, the output array would be bigger (4) than the specified maximum size of 2", e.getMessage());
        }
    }

}