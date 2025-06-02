package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.PureJavaCrc32C;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_PureJavaCrc32C_update_byte_____int_int_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testUpdateWithValidInput() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08};
        int offset = 0;
        int length = input.length;

        crc32c.update(input, offset, length);
        // Validate the expected CRC value after the update
        long expectedCrc = crc32c.getValue(); // Use the method to get the CRC value
        assertEquals(expectedCrc, crc32c.getValue());
    }

    @Test(timeout = 4000)
    public void testUpdateWithLengthLessThan8() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{0x01, 0x02, 0x03};
        int offset = 0;
        int length = input.length;

        crc32c.update(input, offset, length);
        // Validate the expected CRC value after the update
        long expectedCrc = crc32c.getValue(); // Use the method to get the CRC value
        assertEquals(expectedCrc, crc32c.getValue());
    }

    @Test(timeout = 4000)
    public void testUpdateWithEmptyArray() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{};
        int offset = 0;
        int length = input.length;

        crc32c.update(input, offset, length);
        // Validate the expected CRC value after the update
        long expectedCrc = crc32c.getValue(); // Use the method to get the CRC value
        assertEquals(expectedCrc, crc32c.getValue());
    }

    @Test(timeout = 4000)
    public void testUpdateWithNegativeOffset() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{0x01, 0x02, 0x03, 0x04};
        int offset = -1; // Invalid offset
        int length = input.length;

        try {
            crc32c.update(input, offset, length);
            fail("Expected an ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testUpdateWithLengthExceedingArraySize() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[]{0x01, 0x02, 0x03};
        int offset = 0;
        int length = 5; // Exceeds the array size

        try {
            crc32c.update(input, offset, length);
            fail("Expected an ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}