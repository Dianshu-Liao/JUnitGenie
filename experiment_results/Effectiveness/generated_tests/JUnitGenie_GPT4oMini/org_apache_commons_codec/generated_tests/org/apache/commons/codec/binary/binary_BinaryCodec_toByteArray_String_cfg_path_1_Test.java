package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_toByteArray_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToByteArray_withValidAscii() {
        BinaryCodec codec = new BinaryCodec();
        String ascii = "Hello";
        byte[] expected = codec.fromAscii(ascii.toCharArray());
        
        byte[] result = codec.toByteArray(ascii);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToByteArray_withNull() {
        BinaryCodec codec = new BinaryCodec();
        String ascii = null;
        
        try {
            byte[] result = codec.toByteArray(ascii);
            assertArrayEquals(new byte[0], result); // Assuming EMPTY_BYTE_ARRAY is an empty byte array
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}