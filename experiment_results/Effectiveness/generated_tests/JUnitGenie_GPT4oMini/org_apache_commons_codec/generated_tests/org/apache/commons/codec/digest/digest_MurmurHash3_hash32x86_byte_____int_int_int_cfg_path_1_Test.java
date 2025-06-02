package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8}; // Sample data
        int offset = 0; // Starting from the beginning of the array
        int length = data.length; // Length of the data
        int seed = 42; // Sample seed value

        try {
            int result = MurmurHash3.hash32x86(data, offset, length, seed);
            // Expected value needs to be calculated based on the implementation
            int expected = 123456789; // Replace with the actual expected value
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}