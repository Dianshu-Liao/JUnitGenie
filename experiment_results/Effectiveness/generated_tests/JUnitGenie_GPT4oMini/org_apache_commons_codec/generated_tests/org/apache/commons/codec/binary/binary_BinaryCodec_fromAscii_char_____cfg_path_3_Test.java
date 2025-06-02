package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_fromAscii_char_____cfg_path_3_Test {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Test(timeout = 4000)
    public void testFromAscii_ValidInput() {
        char[] asciiInput = {'1', '0', '1', '1', '0', '0', '1', '0'};
        byte[] expectedOutput = new byte[]{(byte) 0b10110010}; // Expected byte representation
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
    public void testFromAscii_InputWithOnlyZeros() {
        char[] asciiInput = {'0', '0', '0', '0', '0', '0', '0', '0'};
        byte[] expectedOutput = new byte[]{(byte) 0b00000000}; // Expected byte representation
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testFromAscii_InputWithOnlyOnes() {
        char[] asciiInput = {'1', '1', '1', '1', '1', '1', '1', '1'};
        byte[] expectedOutput = new byte[]{(byte) 0b11111111}; // Expected byte representation
        byte[] actualOutput = BinaryCodec.fromAscii(asciiInput);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}