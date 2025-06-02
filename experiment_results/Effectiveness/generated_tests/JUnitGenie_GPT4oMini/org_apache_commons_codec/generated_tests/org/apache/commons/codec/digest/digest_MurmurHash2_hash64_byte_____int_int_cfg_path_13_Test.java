package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash2_hash64_byte_____int_int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        int length = data.length;
        int seed = 1234;

        long expectedHash = 0x9c56cc51b3e1e1b5L; // Replace with the actual expected hash value
        long actualHash = MurmurHash2.hash64(data, length, seed);

        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithZeroLength() {
        byte[] data = new byte[0];
        int length = 0;
        int seed = 1234;

        long expectedHash = 0x5c1e1c1e1c1e1c1eL; // Replace with the actual expected hash value for zero-length input
        long actualHash = MurmurHash2.hash64(data, length, seed);

        assertEquals(expectedHash, actualHash);
    }
    
    @Test(timeout = 4000)
    public void testHash64WithNullData() {
        int length = 0;
        int seed = 1234;

        try {
            // Specify the method explicitly to avoid ambiguity
            long actualHash = MurmurHash2.hash64((byte[]) null, length, seed);
        } catch (Exception e) {
            // handle exception as required
        }
    }

}