package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash2_hash64_byte_____int_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        int length = data.length;
        int seed = 12345;

        long expectedHash = 123456789L; // Replace with the expected hash value for the given input
        long actualHash = 0;

        try {
            actualHash = MurmurHash2.hash64(data, length, seed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(expectedHash, actualHash);
    }

}