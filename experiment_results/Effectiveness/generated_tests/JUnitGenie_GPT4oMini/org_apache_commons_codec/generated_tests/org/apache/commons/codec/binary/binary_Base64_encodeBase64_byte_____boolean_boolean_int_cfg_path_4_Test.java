package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base64_encodeBase64_byte_____boolean_boolean_int_cfg_path_4_Test {

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
    public void testEncodeBase64WithInputArrayTooBig() {
        byte[] binaryData = new byte[200]; // Example data
        boolean isChunked = true;
        boolean urlSafe = false;
        int maxResultSize = 100; // Set maxResultSize less than the encoded length

        try {
            Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Input array too big, the output array would be bigger (200) than the specified maximum size of 100", e.getMessage());
        }
    }

}