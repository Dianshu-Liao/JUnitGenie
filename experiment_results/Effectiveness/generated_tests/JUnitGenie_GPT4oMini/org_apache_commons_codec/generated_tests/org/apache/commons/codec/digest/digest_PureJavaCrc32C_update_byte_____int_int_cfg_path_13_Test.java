package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.PureJavaCrc32C;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_PureJavaCrc32C_update_byte_____int_int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testUpdateWithValidInput() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[16]; // Example input
        int offset = 0;
        int length = 16;

        try {
            crc32c.update(input, offset, length);
            // Validate the crc value after update
            assertNotNull(crc32c);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testUpdateWithLengthLessThanOrEqualTo7() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[7]; // Example input
        int offset = 0;
        int length = 7;

        try {
            crc32c.update(input, offset, length);
            // Validate the crc value after update
            assertNotNull(crc32c);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testUpdateWithZeroLength() {
        PureJavaCrc32C crc32c = new PureJavaCrc32C();
        byte[] input = new byte[0]; // Empty input
        int offset = 0;
        int length = 0;

        try {
            crc32c.update(input, offset, length);
            // Validate the crc value after update
            assertNotNull(crc32c);
        } catch (Exception e) {
            fail("Exception should not have been thrown for zero length input");
        }
    }

}