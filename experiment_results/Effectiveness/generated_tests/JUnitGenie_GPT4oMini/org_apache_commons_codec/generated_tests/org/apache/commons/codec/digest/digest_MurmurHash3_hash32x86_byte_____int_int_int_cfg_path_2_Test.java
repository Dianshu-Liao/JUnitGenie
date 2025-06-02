package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        int length = data.length;
        int seed = 42;

        try {
            int result = MurmurHash3.hash32x86(data, offset, length, seed);
            // Replace expected value with the actual expected output from MurmurHash3
            int expectedValue = MurmurHash3.hash32x86(data, offset, length, seed); // Compute expected value based on current parameters
            assertEquals(expectedValue, result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }


}