package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_setSize_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetSizeValid() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        long validSize = 100L;

        entry.setSize(validSize);

        // Verify that the size is set correctly using the getSize() method
        assertEquals(validSize, entry.getSize());
    }

    @Test(timeout = 4000)
    public void testSetSizeNegative() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        long invalidSize = -1L;

        try {
            entry.setSize(invalidSize);
            fail("Expected IllegalArgumentException for negative size");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid entry size", e.getMessage());
        }
    }


}