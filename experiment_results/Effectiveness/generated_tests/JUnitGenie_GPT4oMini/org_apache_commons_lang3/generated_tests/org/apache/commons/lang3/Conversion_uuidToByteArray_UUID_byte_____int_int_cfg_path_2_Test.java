package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class Conversion_uuidToByteArray_UUID_byte_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUuidToByteArray_withValidInput() {
        UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 16;

        byte[] expected = uuidToBytes(uuid);
        byte[] result = Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testUuidToByteArray_withZeroNBytes() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 0;

        byte[] result = Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);

        assertArrayEquals(dst, result);
    }

    @Test(timeout = 4000)
    public void testUuidToByteArray_withExceedingNBytes() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 17;

        try {
            Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Exception expected
        }
    }

    private byte[] uuidToBytes(UUID uuid) {
        byte[] bytes = new byte[16];
        long mostSigBits = uuid.getMostSignificantBits();
        long leastSigBits = uuid.getLeastSignificantBits();
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (mostSigBits >> 8 * (7 - i));
            bytes[i + 8] = (byte) (leastSigBits >> 8 * (7 - i));
        }
        return bytes;
    }

}