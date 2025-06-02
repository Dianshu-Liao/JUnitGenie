package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveUtil;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_dump_DumpArchiveInputStream_matches_byte_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMatchesWithValidBuffer() {
        byte[] buffer = new byte[32];
        // Setting the bytes to represent the little-endian encoding of 60012
        buffer[24] = 4; // 60012 in little-endian
        buffer[25] = 76;
        buffer[26] = (byte) 233; // Cast to byte to avoid lossy conversion error
        buffer[27] = 0;

        int length = buffer.length; // length is 32
        boolean result = DumpArchiveInputStream.matches(buffer, length);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithInsufficientLength() {
        byte[] buffer = new byte[31]; // length < 32
        int length = buffer.length;
        boolean result = DumpArchiveInputStream.matches(buffer, length);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithValidLengthButInvalidMagic() {
        byte[] buffer = new byte[32];
        // Setting the bytes to not represent the little-endian encoding of 60012
        buffer[24] = 0; // Not 60012
        buffer[25] = 0;
        buffer[26] = 0;
        buffer[27] = 0;

        int length = buffer.length; // length is 32
        boolean result = DumpArchiveInputStream.matches(buffer, length);
        assertFalse(result);
    }


}