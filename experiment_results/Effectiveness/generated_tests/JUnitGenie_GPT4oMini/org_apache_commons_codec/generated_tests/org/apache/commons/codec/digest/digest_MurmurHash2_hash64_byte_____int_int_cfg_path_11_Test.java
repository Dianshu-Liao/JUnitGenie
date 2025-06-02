package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash2_hash64_byte_____int_int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        int length = data.length;
        int seed = 12345;

        long expectedHash = 123456789L; // Replace with the expected hash value for the given input
        long actualHash = MurmurHash2.hash64(data, length, seed);
        
        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithEmptyData() {
        byte[] data = new byte[0];
        int length = data.length;
        int seed = 12345;

        long expectedHash = 0L; // Replace with the expected hash value for the empty input
        long actualHash = MurmurHash2.hash64(data, length, seed);
        
        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithSingleByte() {
        byte[] data = new byte[] {42};
        int length = data.length;
        int seed = 12345;

        long expectedHash = 987654321L; // Replace with the expected hash value for the single byte input
        long actualHash = MurmurHash2.hash64(data, length, seed);
        
        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithLongData() {
        byte[] data = new byte[1000]; // Example of long data
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        int length = data.length;
        int seed = 12345;

        long expectedHash = 1122334455L; // Replace with the expected hash value for the long input
        long actualHash = MurmurHash2.hash64(data, length, seed);
        
        assertEquals(expectedHash, actualHash);
    }

}