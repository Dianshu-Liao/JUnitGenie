package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;

public class archivers_zip_ZipArchiveEntry_setSize_long_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testSetSizeThrowsExceptionForNegativeSize() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        try {
            entry.setSize(-1); // This should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            // Exception is expected; no action needed
        }
    }

}