package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.PureJavaCrc32;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_PureJavaCrc32_update_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUpdate() {
        PureJavaCrc32 crc32 = new PureJavaCrc32();
        byte[] input = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int offset = 0;
        int len = input.length;

        // Expected CRC value after the update
        int expectedCrc = 0; // Replace with the expected CRC value after calculation

        try {
            crc32.update(input, offset, len);
            // Use the public method to get the CRC value instead of accessing the private field
            assertEquals(expectedCrc, crc32.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}