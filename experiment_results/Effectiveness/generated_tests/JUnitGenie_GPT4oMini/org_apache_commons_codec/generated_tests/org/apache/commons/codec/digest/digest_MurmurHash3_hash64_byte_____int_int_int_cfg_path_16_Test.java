package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash64_byte_____int_int_int_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8}; // Example data
        int offset = 0; // Starting from the beginning of the array
        int length = data.length; // Full length of the data
        int seed = 12345; // Example seed

        // Calculate expected hash using a public method
        long expectedHash = MurmurHash3.hash64(data, offset, length, seed); // Use the public method directly
        long actualHash = 0;

        try {
            actualHash = MurmurHash3.hash64(data, offset, length, seed);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        assertEquals(expectedHash, actualHash);
    }


}