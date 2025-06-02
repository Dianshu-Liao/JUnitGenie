package org.apache.commons.codec.binary;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.codec.binary.BinaryCodec;

public class binary_BinaryCodec_toAsciiChars_byte_____cfg_path_5_Test {

    private static final byte[] INPUT_BYTES = new byte[]{(byte) 0b10101010, (byte) 0b01010101}; // example input
    private static final char[] EXPECTED_OUTPUT = new char[] {
        '1', '0', '1', '0', '1', '0', '1', '0',
        '0', '1', '0', '1', '0', '1', '0', '1'
    };

    @Test(timeout = 4000)
    public void testToAsciiChars_withValidInput() {
        char[] result = BinaryCodec.toAsciiChars(INPUT_BYTES);
        assertArrayEquals(EXPECTED_OUTPUT, result);
    }

    @Test(timeout = 4000)
    public void testToAsciiChars_withEmptyInput() {
        byte[] emptyInput = new byte[]{};
        char[] result = BinaryCodec.toAsciiChars(emptyInput);
        assertArrayEquals(new char[0], result);  // Assuming EMPTY_CHAR_ARRAY returns an empty char array
    }

    @Test(timeout = 4000)
    public void testToAsciiChars_withNullInput() {
        byte[] nullInput = null;
        try {
            BinaryCodec.toAsciiChars(nullInput); // This should throw an exception
        } catch (Exception e) {
            // handle the exception as needed
        }
    }


}