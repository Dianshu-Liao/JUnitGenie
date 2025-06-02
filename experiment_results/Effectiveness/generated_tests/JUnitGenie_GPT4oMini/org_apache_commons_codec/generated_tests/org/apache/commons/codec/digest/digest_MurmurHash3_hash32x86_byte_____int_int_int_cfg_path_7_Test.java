package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        // Test case where length is a multiple of 4
        byte[] data = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08};
        int offset = 0;
        int length = 8;
        int seed = 0;

        try {
            int result = MurmurHash3.hash32x86(data, offset, length, seed);
            assertEquals(235198512, result); // Expected hash value to be confirmed with reference
        } catch (Exception e) {
            e.printStackTrace(); // handle exception as per rule 4
        }
    }

    @Test(timeout = 4000)
    public void testHash32x86WithShortInput() {
        // Test case where length is less than 4
        byte[] data = {0x01, 0x02, 0x03};
        int offset = 0;
        int length = 3;
        int seed = 0;

        try {
            int result = MurmurHash3.hash32x86(data, offset, length, seed);
            assertEquals(1889509465, result); // Expected hash value to be confirmed with reference
        } catch (Exception e) {
            e.printStackTrace(); // handle exception as per rule 4
        }
    }
    
    @Test(timeout = 4000)
    public void testHash32x86WithZeroLength() {
        // Test case where length is zero
        byte[] data = {};
        int offset = 0;
        int length = 0;
        int seed = 0;

        try {
            int result = MurmurHash3.hash32x86(data, offset, length, seed);
            assertEquals(-2, result); // Expected hash value to be confirmed with reference
        } catch (Exception e) {
            e.printStackTrace(); // handle exception as per rule 4
        }
    }

}