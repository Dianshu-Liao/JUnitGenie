package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_Base64_encodeBase64_byte_____boolean_boolean_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEncodeBase64WithNullBinaryData() {
        byte[] binaryData = null;
        boolean isChunked = true;
        boolean urlSafe = false;
        int maxResultSize = 100;

        try {
            byte[] result = Base64.encodeBase64(binaryData, isChunked, urlSafe, maxResultSize);
            assertArrayEquals(binaryData, result);
        } catch (IllegalArgumentException e) {
            // Handle exception if thrown
        }
    }

}