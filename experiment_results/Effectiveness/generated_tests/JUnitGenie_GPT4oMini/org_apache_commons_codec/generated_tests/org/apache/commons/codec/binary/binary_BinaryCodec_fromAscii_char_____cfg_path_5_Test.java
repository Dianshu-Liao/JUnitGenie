package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_fromAscii_char_____cfg_path_5_Test {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Test(timeout = 4000)
    public void testFromAsciiWithValidInput() {
        char[] asciiInput = {'0', '1', '1', '0', '1', '0', '1', '1'};
        byte[] expectedOutput = {0b01101011}; // Expected byte representation
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAsciiWithNullInput() {
        char[] asciiInput = null;
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(EMPTY_BYTE_ARRAY, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAsciiWithEmptyInput() {
        char[] asciiInput = {};
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(EMPTY_BYTE_ARRAY, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAsciiWithInsufficientBits() {
        char[] asciiInput = {'1', '0', '1'}; // Less than 8 bits
        byte[] expectedOutput = {0b00000000}; // Expected byte representation
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}