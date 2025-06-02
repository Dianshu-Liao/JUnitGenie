package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.assertArrayEquals;

public class Conversion_uuidToByteArray_UUID_byte_____int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUuidToByteArray() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 16;

        try {
            byte[] result = Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);
            byte[] expected = new byte[16];
            System.arraycopy(longToByteArray(uuid.getMostSignificantBits(), 0), 0, expected, 0, 8);
            System.arraycopy(longToByteArray(uuid.getLeastSignificantBits(), 0), 0, expected, 8, 8);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testUuidToByteArrayWithZeroBytes() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 0;

        try {
            byte[] result = Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);
            assertArrayEquals(dst, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUuidToByteArrayWithExceedingBytes() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 17;

        try {
            Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    private byte[] longToByteArray(long value, int offset) {
        byte[] bytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (value >>> (56 - (i * 8)));
        }
        return bytes;
    }

}