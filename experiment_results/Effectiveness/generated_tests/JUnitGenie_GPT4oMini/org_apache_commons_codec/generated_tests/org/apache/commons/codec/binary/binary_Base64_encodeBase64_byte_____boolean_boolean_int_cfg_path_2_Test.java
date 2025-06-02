package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base64_encodeBase64_byte_____boolean_boolean_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeBase64WithNullBinaryData() {
        byte[] binaryData = null;
        boolean isChunked = false;
        boolean urlSafe = false;
        int maxResultSize = 100;

        byte[] result = Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
        assertArrayEquals(binaryData, result);
    }

    @Test(timeout = 4000)
    public void testEncodeBase64WithLargeInput() {
        byte[] binaryData = new byte[200]; // Example large input
        boolean isChunked = false;
        boolean urlSafe = false;
        int maxResultSize = 100; // Set maxResultSize smaller than the expected output size

        try {
            Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
            fail("Expected IllegalArgumentException for input array too big");
        } catch (IllegalArgumentException e) {
            assertEquals("Input array too big, the output array would be bigger (264) than the specified maximum size of 100", e.getMessage());
        }
    }

}