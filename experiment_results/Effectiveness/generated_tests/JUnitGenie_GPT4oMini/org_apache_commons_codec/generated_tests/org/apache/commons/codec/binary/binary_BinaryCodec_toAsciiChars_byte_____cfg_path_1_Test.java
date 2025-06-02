package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_toAsciiChars_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToAsciiCharsWithNullInput() {
        byte[] input = null; // This input meets the constraint of being null
        char[] expectedOutput = {}; // Expected output is the EMPTY_CHAR_ARRAY

        try {
            char[] result = BinaryCodec.toAsciiChars(input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}