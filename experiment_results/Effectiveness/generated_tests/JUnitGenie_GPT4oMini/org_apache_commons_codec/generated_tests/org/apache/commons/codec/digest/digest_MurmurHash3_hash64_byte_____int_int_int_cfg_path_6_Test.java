package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash64_byte_____int_int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        int length = data.length;
        int seed = 12345;

        try {
            long result = MurmurHash3.hash64(data, offset, length, seed);
            // Expected value should be calculated based on the known output of the hash function
            long expected = 123456789L; // Replace with the actual expected value
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}