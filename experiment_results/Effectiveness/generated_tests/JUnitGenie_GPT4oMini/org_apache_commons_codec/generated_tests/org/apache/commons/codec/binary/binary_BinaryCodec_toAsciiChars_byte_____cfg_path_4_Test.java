package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_toAsciiChars_byte_____cfg_path_4_Test {

    private static final byte[] TEST_INPUT = { 0b00000001, 0b00000010, 0b00000011 }; // Example input
    private static final char[] EXPECTED_OUTPUT = {
        '0', '0', '0', '0', '0', '0', '0', '1',
        '0', '0', '0', '0', '0', '0', '1', '0',
        '0', '0', '0', '0', '0', '0', '1', '1'
    };

    @Test(timeout = 4000)
    public void testToAsciiChars() {
        try {
            char[] result = BinaryCodec.toAsciiChars(TEST_INPUT);
            assertArrayEquals(EXPECTED_OUTPUT, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}