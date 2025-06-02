package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_toAsciiChars_byte_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToAsciiChars_ValidInput() {
        byte[] input = {10, 20}; // Example input to test
        char[] expectedOutput = {
            '0', '0', '0', '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0', '0', '0', '0'
        }; // Expected ASCII character output for the given byte input

        char[] result = BinaryCodec.toAsciiChars(input);
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testToAsciiChars_EmptyArray() {
        byte[] input = {}; // Empty byte array
        
        char[] expectedOutput = new char[0]; // Expected output for empty input
        char[] result = BinaryCodec.toAsciiChars(input);
        
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testToAsciiChars_NullInput() {
        byte[] input = null; // Null input
        
        try {
            BinaryCodec.toAsciiChars(input);
        } catch (NullPointerException e) {
            // Expected behavior - do nothing
        }
    }

    // Additional tests can be written to cover edge cases


}