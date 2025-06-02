package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_fromAscii_char_____cfg_path_6_Test {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int[] BITS = {64, 32, 16, 8, 4, 2, 1}; // Presumed definition based on method context

    @Test(timeout = 4000)
    public void testFromAscii_withValidInput() {
        char[] asciiInput = {'0', '0', '0', '0', '0', '0', '0', '1'}; // Represents the byte 1
        byte[] expectedOutput = new byte[]{1}; // Expected byte array

        byte[] result = null;
        try {
            result = BinaryCodec.fromAscii(asciiInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testFromAscii_withEmptyArray() {
        char[] asciiInput = {}; // Empty input
        byte[] expectedOutput = new byte[0]; // Expected byte array

        byte[] result = null;
        try {
            result = BinaryCodec.fromAscii(asciiInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testFromAscii_withNullArray() {
        char[] asciiInput = null; // Null input
        byte[] expectedOutput = EMPTY_BYTE_ARRAY; // Expected output is also empty

        byte[] result = null;
        try {
            result = BinaryCodec.fromAscii(asciiInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertArrayEquals(expectedOutput, result);
    }

}