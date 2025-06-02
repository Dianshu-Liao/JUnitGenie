package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_MurmurHash3_hash32x86_byte_____int_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHash32x86() {
        // Test case 1: Normal case
        byte[] data = new byte[] {1, 2, 3, 4, 5, 6, 7, 8};
        int offset = 0;
        int length = 8;
        int seed = 42;
        int expectedHash = MurmurHash3.hash32x86(data, offset, length, seed);
        int actualHash = MurmurHash3.hash32x86(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);

        // Test case 2: Edge case with minimum length
        byte[] data2 = new byte[] {1, 2, 3, 4};
        offset = 0;
        length = 4;
        seed = 0;
        expectedHash = MurmurHash3.hash32x86(data2, offset, length, seed);
        actualHash = MurmurHash3.hash32x86(data2, offset, length, seed);
        assertEquals(expectedHash, actualHash);

        // Test case 3: Edge case with length less than 4
        byte[] data3 = new byte[] {1, 2, 3};
        offset = 0;
        length = 3;
        seed = 0;
        expectedHash = MurmurHash3.hash32x86(data3, offset, length, seed);
        actualHash = MurmurHash3.hash32x86(data3, offset, length, seed);
        assertEquals(expectedHash, actualHash);

        // Test case 4: Edge case with length equal to 0
        byte[] data4 = new byte[] {};
        offset = 0;
        length = 0;
        seed = 0;
        expectedHash = MurmurHash3.hash32x86(data4, offset, length, seed);
        actualHash = MurmurHash3.hash32x86(data4, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

}