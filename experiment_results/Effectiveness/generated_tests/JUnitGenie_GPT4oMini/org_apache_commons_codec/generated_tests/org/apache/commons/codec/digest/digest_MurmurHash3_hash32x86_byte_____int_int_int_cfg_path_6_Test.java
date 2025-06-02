package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        // Test case parameters
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8}; // Sample data
        int offset = 0; // Starting from the beginning of the array
        int length = data.length; // Length of the data
        int seed = 42; // Sample seed value

        // Expected result calculation (this should be replaced with the actual expected value)
        int expectedHash = 123456789; // Replace with the actual expected hash value for the given input

        try {
            // Call the focal method
            int result = MurmurHash3.hash32x86(data, offset, length, seed);
            // Assert the result
            assertEquals(expectedHash, result);
        } catch (Exception e) {
            // Handle any exceptions that may occur
            e.printStackTrace();
        }
    }

}