package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.assertEquals;

public class Conversion_byteArrayToUuid_byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testByteArrayToUuid_ValidInput() {
        byte[] input = new byte[16];
        for (int i = 0; i < 16; i++) {
            input[i] = (byte) i;
        }
        UUID expectedUuid = new UUID(0x0000000000000000L, 0x000000000000000F);
        UUID result = Conversion.byteArrayToUuid(input, 0);
        assertEquals(expectedUuid, result);
    }

    @Test(timeout = 4000)
    public void testByteArrayToUuid_InsufficientBytes() {
        byte[] input = new byte[15]; // fewer than 16 bytes
        try {
            Conversion.byteArrayToUuid(input, 0);
        } catch (IllegalArgumentException e) {
            assertEquals("Need at least 16 bytes for UUID", e.getMessage());
        }
    }

}