package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_toAsciiChars_byte_____cfg_path_2_Test {

    private static final char[] EXPECTED_OUTPUT = {
        '0', '0', '0', '0', '0', '0', '0', '0', // for byte 0
        '0', '0', '0', '0', '0', '0', '0', '1', // for byte 1
        '0', '0', '0', '0', '0', '0', '1', '0', // for byte 2
        '0', '0', '0', '0', '0', '1', '0', '1', // for byte 3
        '0', '0', '0', '0', '1', '0', '0', '0', // for byte 4
        '0', '0', '0', '1', '0', '0', '1', '0', // for byte 5
        '0', '1', '0', '0', '0', '0', '0', '0', // for byte 6
        '1', '0', '0', '0', '0', '0', '0', '0'  // for byte 7
    };

    @Test(timeout = 4000)
    public void testToAsciiChars() {
        byte[] input = new byte[]{0, 1, 2, 3, 4, 5, 6, 7}; // Example input
        char[] result = null;
        try {
            result = BinaryCodec.toAsciiChars(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(EXPECTED_OUTPUT, result);
    }

    @Test(timeout = 4000)
    public void testToAsciiCharsWithEmptyArray() {
        byte[] input = new byte[0]; // Empty input
        char[] result = null;
        try {
            result = BinaryCodec.toAsciiChars(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(new char[0], result); // Expecting an empty char array
    }

    @Test(timeout = 4000)
    public void testToAsciiCharsWithNull() {
        byte[] input = null; // Null input
        char[] result = null;
        try {
            result = BinaryCodec.toAsciiChars(input);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(new char[0], result); // Expecting an empty char array
    }

}