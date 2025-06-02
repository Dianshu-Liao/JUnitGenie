package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_dump_DumpArchiveInputStream_matches_byte_____int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMatchesWithValidBuffer() {
        byte[] buffer = new byte[1024]; // Satisfies length >= 1024
        buffer[0] = 0; // Just some arbitrary values
        buffer[1] = 0;
        buffer[2] = 0;
        buffer[3] = 0;
        // Ensure the conditions for the test are met
        buffer[20] = 0; // Not 12
        buffer[21] = 0; // Not 233

        boolean result = DumpArchiveInputStream.matches(buffer, 20);
        assertFalse(result); // Assuming verify will return false for this buffer
    }

    @Test(timeout = 4000)
    public void testMatchesWithBufferTooShort() {
        byte[] buffer = new byte[31]; // Length < 32
        boolean result = DumpArchiveInputStream.matches(buffer, 0);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithInvalidOffset() {
        byte[] buffer = new byte[1024]; // Satisfies length >= 1024
        buffer[0] = 0; // Just some arbitrary values
        buffer[1] = 0;
        buffer[2] = 0;
        buffer[3] = 0;
        buffer[20] = 0; // Not 12
        buffer[21] = 0; // Not 233

        boolean result = DumpArchiveInputStream.matches(buffer, 1020); // Out of bounds
        assertFalse(result); // Should handle out of bounds gracefully
    }

}