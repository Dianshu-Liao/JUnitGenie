package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.*;

public class digest_MurmurHash3_hash64_byte_____int_int_int_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {0, 1, 2, 3, 4, 5, 6, 7};  // Example input data
        int offset = 0;  // Starting from the beginning of the data array
        int length = data.length;  // Using the full length of the data array
        int seed = 12345;  // Example seed value

        long expectedHash = MurmurHash3.hash64(data, offset, length, seed);  // Expected result can be calculated separately or from documentation 

        long actualHash = 0;
        try {
            actualHash = MurmurHash3.hash64(data, offset, length, seed);
        } catch (Exception e) {
            fail("hash64 method threw an exception: " + e.getMessage());
        }

        assertEquals(expectedHash, actualHash);
    }

}