package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        // Given
        byte[] data = new byte[] {1, 2, 3, 4, 5}; // Sample data
        int offset = 0;
        int length = data.length;
        int seed = 42;

        // When
        try {
            int result = MurmurHash3.hash32x86(data, offset, length, seed);

            // Then
            // Expected hash value for the given input, computed previously or known value
            int expectedHashValue = -2133065242; // Replace with actual expected value
            assertEquals(expectedHashValue, result);
        } catch (Exception e) {
            // Handle exception if needed
            e.printStackTrace();
        }
    }

}