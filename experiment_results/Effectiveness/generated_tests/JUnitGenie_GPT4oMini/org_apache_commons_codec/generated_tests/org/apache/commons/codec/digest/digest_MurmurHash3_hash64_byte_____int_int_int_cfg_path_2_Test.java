package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash64_byte_____int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8}; // Example data
        int offset = 0; // Starting offset
        int length = data.length; // Length of the data
        int seed = 12345; // Example seed

        try {
            long result = MurmurHash3.hash64(data, offset, length, seed);
            // Expected value can be calculated or predefined based on the implementation
            long expected = 123456789L; // Replace with the actual expected value
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}