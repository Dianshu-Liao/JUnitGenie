package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_MurmurHash3_hash64_byte_____int_int_int_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Sample data
        int offset = 0; // Sample offset
        int length = data.length; // Length of data
        int seed = 123456; // Sample seed

        try {
            long result = MurmurHash3.hash64(data, offset, length, seed);
            assertNotNull(result); // Assert that the result is not null
            // Add more assertions here as necessary based on expected output
        } catch (Exception e) {
            fail("Exception thrown during hash computation: " + e.getMessage());
        }
    }

}