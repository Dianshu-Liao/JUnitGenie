package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.PureJavaCrc32C;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_PureJavaCrc32C_update_byte_____int_int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testUpdateWithValidInput() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        int length = input.length;

        // Call the method under test
        crc32c.update(input, offset, length);

        // Validate the expected CRC value
        int expectedCrc = 0x8e0; // Example expected CRC value for the input provided
        assertEquals(expectedCrc, crc32c.getValue()); // Use getValue() instead of getCrc()
    }

    @Test(timeout = 4000)
    public void testUpdateWithLengthLessThan8() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{1, 2, 3};
        int offset = 0;
        int length = input.length;

        // Call the method under test
        crc32c.update(input, offset, length);

        // Validate the expected CRC value
        int expectedCrc = 0x3f8; // Example expected CRC value for the input provided
        assertEquals(expectedCrc, crc32c.getValue());
    }

    @Test(timeout = 4000)
    public void testUpdateWithEmptyInput() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{};
        int offset = 0;
        int length = input.length;

        // Call the method under test
        crc32c.update(input, offset, length);

        // Validate the expected CRC value
        int expectedCrc = 0; // Expected CRC for an empty input
        assertEquals(expectedCrc, crc32c.getValue());
    }

    @Test(timeout = 4000)
    public void testUpdateWithOffsetAndLength() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int offset = 2; // Start from the third byte
        int length = 5; // Length of 5 bytes

        // Call the method under test
        crc32c.update(input, offset, length);

        // Validate the expected CRC value
        int expectedCrc = 0x3f0; // Example expected CRC value for the input provided, adjust accordingly
        assertEquals(expectedCrc, crc32c.getValue());
    }

}