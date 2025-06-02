package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash2_hash64_byte_____int_int_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testHash64() {
        byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Valid data of length 8
        int length = data.length; // Length is 8
        int seed = 12345; // Example seed

        long expectedHash = MurmurHash2.hash64(data, length, seed); // Expected hash value to compare against

        // Call the method under test
        long actualHash = MurmurHash2.hash64(data, length, seed);

        // Assert that the actual hash matches the expected hash
        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithDifferentSeed() {
        byte[] data = new byte[]{1, 2, 3, 4, 5, 6, 7, 8}; // Valid data of length 8
        int length = data.length; // Length is 8
        int seed = 67890; // Different seed

        long expectedHash = MurmurHash2.hash64(data, length, seed); // Expected hash value to compare against

        // Call the method under test
        long actualHash = MurmurHash2.hash64(data, length, seed);

        // Assert that the actual hash matches the expected hash
        assertEquals(expectedHash, actualHash);
    }

    @Test(timeout = 4000)
    public void testHash64WithNullData() {
        byte[] data = null; // Null data
        int length = 0; // Length is 0
        int seed = 12345; // Example seed

        try {
            MurmurHash2.hash64(data, length, seed);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testHash64WithInsufficientData() {
        byte[] data = new byte[]{1, 2, 3}; // Insufficient data (length < 8)
        int length = data.length; // Length is 3
        int seed = 12345; // Example seed

        try {
            MurmurHash2.hash64(data, length, seed);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}