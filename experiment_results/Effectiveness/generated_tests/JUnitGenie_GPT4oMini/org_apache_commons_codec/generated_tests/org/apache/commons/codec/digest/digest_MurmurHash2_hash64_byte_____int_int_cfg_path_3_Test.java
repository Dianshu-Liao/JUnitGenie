package org.apache.commons.codec.digest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.apache.commons.codec.digest.MurmurHash2;

public class digest_MurmurHash2_hash64_byte_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Example byte array
        int length = data.length;
        int seed = 12345; // Example seed

        try {
            long result = MurmurHash2.hash64(data, length, seed);
            // You may want to assert the result against an expected value
            // Replace 1234567890123456789L with the expected output from known input
            assertEquals(1234567890123456789L, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}