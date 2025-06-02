package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;

public class Conversion_uuidToByteArray_UUID_byte_____int_int_cfg_path_3_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testUuidToByteArray_NBytesGreaterThan16() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        int dstPos = 0;
        int nBytes = 17; // This should trigger the exception

        try {
            Conversion.uuidToByteArray(uuid, dst, dstPos, nBytes);
        } catch (IllegalArgumentException e) {
            assertEquals("nBytes is greater than 16", e.getMessage());
            throw e; // Rethrow to satisfy the expected exception
        }
    }


}