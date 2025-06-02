package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base64_encodeBase64_byte_____boolean_boolean_int_cfg_path_3_Test {

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
    public void testEncodeBase64WithValidParameters() {
        byte[] binaryData = "test".getBytes();
        boolean isChunked = true;
        boolean urlSafe = false;
        int maxResultSize = 100;

        try {
            byte[] result = Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
            assertNotNull(result);
            assertEquals("dGVzdA==", new String(result));
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid parameters");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEncodeBase64WithExceedingMaxResultSize() {
        byte[] binaryData = new byte[200]; // Large input
        boolean isChunked = true;
        boolean urlSafe = false;
        int maxResultSize = 100; // Set max size smaller than expected output

        try {
            Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
        } catch (IllegalArgumentException e) {
            assertEquals("Input array too big, the output array would be bigger (272) than the specified maximum size of 100", e.getMessage());
            throw e; // Rethrow to satisfy the expected exception
        }
    }

}