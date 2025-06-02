package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_fromAscii_char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromAsciiWithNullInput() {
        char[] ascii = null;
        byte[] expected = new byte[0]; // Corrected: Use a new empty byte array instead of BinaryCodec.EMPTY_BYTE_ARRAY
        try {
            byte[] result = BinaryCodec.fromAscii(ascii);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testFromAsciiWithEmptyArray() {
        char[] ascii = new char[0];
        byte[] expected = new byte[0]; // Corrected: Use a new empty byte array instead of BinaryCodec.EMPTY_BYTE_ARRAY
        try {
            byte[] result = BinaryCodec.fromAscii(ascii);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }


}