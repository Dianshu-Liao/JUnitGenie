package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_fromAscii_char_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromAsciiWithNullInput() {
        try {
            char[] ascii = null;
            byte[] result = BinaryCodec.fromAscii(ascii);
            assertArrayEquals(new byte[0], result); // Expecting EMPTY_BYTE_ARRAY
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testFromAsciiWithEmptyArray() {
        try {
            char[] ascii = new char[0];
            byte[] result = BinaryCodec.fromAscii(ascii);
            assertArrayEquals(new byte[0], result); // Expecting EMPTY_BYTE_ARRAY
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}