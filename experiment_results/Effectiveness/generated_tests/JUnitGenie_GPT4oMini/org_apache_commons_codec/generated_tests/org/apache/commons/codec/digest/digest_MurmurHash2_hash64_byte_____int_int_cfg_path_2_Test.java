package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash2_hash64_byte_____int_int_cfg_path_2_Test {

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

    // Additional test cases can be added here to cover more scenarios

}