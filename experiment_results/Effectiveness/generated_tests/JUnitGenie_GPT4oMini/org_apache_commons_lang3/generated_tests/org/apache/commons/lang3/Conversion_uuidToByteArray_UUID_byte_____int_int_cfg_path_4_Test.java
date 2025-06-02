package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.assertArrayEquals;

public class Conversion_uuidToByteArray_UUID_byte_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testUuidToByteArray() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 16;

        // Call the focal method
        byte[] result = Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);

        // Verify the result
        assertArrayEquals(dst, result);
    }

    @Test(timeout = 4000)
    public void testUuidToByteArrayWithZeroBytes() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 0;

        // Call the focal method
        byte[] result = Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);

        // Verify the result
        assertArrayEquals(dst, result);
    }

    @Test(timeout = 4000)
    public void testUuidToByteArrayWithExceedingBytes() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 17; // This should throw an exception

        try {
            Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}