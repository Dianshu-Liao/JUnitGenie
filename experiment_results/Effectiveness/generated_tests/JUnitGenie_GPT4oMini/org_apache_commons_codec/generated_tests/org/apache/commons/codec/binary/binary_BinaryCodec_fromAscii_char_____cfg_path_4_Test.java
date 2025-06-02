package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_fromAscii_char_____cfg_path_4_Test {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Test(timeout = 4000)
    public void testFromAscii_ValidInput() {
        char[] asciiInput = {'0', '1', '1', '0', '1', '0', '1', '1'};
        byte[] expectedOutput = {0b01101011}; // Expected byte array representation
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAscii_EmptyInput() {
        char[] asciiInput = {};
        byte[] expectedOutput = EMPTY_BYTE_ARRAY;
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAscii_NullInput() {
        char[] asciiInput = null;
        byte[] expectedOutput = EMPTY_BYTE_ARRAY;
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAscii_InsufficientBits() {
        char[] asciiInput = {'1', '0', '1'}; // Less than 8 bits
        byte[] expectedOutput = {0b01000000}; // Expected byte array representation
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}