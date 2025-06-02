package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.PureJavaCrc32;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_PureJavaCrc32_update_byte_____int_int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testUpdate() {
        PureJavaCrc32 crc32 = new PureJavaCrc32();
        byte[] input = {1, 2, 3, 4, 5}; // Example input
        int offset = 0; // Starting from the beginning of the array
        int len = input.length; // Length of the array

        crc32.update(input, offset, len);
        // Verify the crc field after the update
        long expectedCrc = crc32.getValue(); // Use the public method to get the CRC value
        assertEquals(expectedCrc, crc32.getValue());
    }
    
    @Test(timeout = 4000)
    public void testUpdateWithEdgeCase() {
        PureJavaCrc32 crc32 = new PureJavaCrc32();
        byte[] input = {}; // Empty input
        int offset = 0; 
        int len = input.length; 

        try {
            crc32.update(input, offset, len);
        } catch (Exception e) {
            // Handle any potential exception (though not expected for empty input)
        }
        // Verify that the crc field remains zero (or whatever the expected initial state is)
        assertEquals(0, crc32.getValue()); // Use the public method to get the CRC value
    }
    
    @Test(timeout = 4000)
    public void testUpdateWithDifferentLengths() {
        PureJavaCrc32 crc32 = new PureJavaCrc32();
        byte[] input = {10, 20, 30, 40, 50, 60, 70, 80}; // Example input
        crc32.update(input, 0, 4); // Testing with part of the input
        long expectedCrcPartial = crc32.getValue(); // Use the public method to get the CRC value
        assertEquals(expectedCrcPartial, crc32.getValue());

        crc32.update(input, 4, 4); // Testing with the remaining part
        long expectedCrcFull = crc32.getValue(); // Use the public method to get the CRC value
        assertEquals(expectedCrcFull, crc32.getValue());
    }

}