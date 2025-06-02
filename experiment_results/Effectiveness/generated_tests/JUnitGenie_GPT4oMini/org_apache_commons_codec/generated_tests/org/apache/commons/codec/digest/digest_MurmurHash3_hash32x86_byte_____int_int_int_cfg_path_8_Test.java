package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        // Test input parameters
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8}; // Example byte array
        int offset = 0; // Starting from the beginning of the array
        int length = data.length; // Length of the byte array
        int seed = 12345; // Example seed value

        // Expected output calculation
        int expectedHash = seed ^ length; // This is a simplified expectation for demonstration

        // Call the focal method
        int actualHash = 0;
        try {
            actualHash = MurmurHash3.hash32x86(data, offset, length, seed);
        } catch (Exception e) {
            // Handle any exceptions that may arise
            e.printStackTrace();
        }

        // Assert the expected output
        assertEquals(expectedHash, actualHash);
    }

}