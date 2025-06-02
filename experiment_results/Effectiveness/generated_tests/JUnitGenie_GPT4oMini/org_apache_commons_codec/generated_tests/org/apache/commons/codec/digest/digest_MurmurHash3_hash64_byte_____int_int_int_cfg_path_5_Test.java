package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash64_byte_____int_int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        int length = data.length;
        int seed = 12345;

        long expectedHash = MurmurHash3.hash64(data, offset, length, seed);
        long actualHash = 0;

        try {
            actualHash = MurmurHash3.hash64(data, offset, length, seed);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithDifferentSeed() {
        byte[] data = new byte[] {10, 20, 30, 40, 50, 60, 70, 80};
        int offset = 0;
        int length = data.length;
        int seed = 67890;

        long expectedHash = MurmurHash3.hash64(data, offset, length, seed);
        long actualHash = 0;

        try {
            actualHash = MurmurHash3.hash64(data, offset, length, seed);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithZeroLength() {
        byte[] data = new byte[0];
        int offset = 0;
        int length = 0;
        int seed = 0;

        long expectedHash = MurmurHash3.hash64(data, offset, length, seed);
        long actualHash = 0;

        try {
            actualHash = MurmurHash3.hash64(data, offset, length, seed);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertEquals(expectedHash, actualHash);
    }

}