package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveOutputStream_addRawArchiveEntry_ZipArchiveEntry_InputStream_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAddRawArchiveEntry() {
        ZipArchiveOutputStream zipOutputStream = null;
        try {
            // Create a ZipArchiveEntry that meets the constraints
            ZipArchiveEntry entry = new ZipArchiveEntry("testEntry.txt");
            entry.setMethod(ZipArchiveEntry.STORED); // Set a valid compression method

            // Create a valid InputStream
            InputStream rawStream = new ByteArrayInputStream("test data".getBytes());

            // Create the ZipArchiveOutputStream
            zipOutputStream = new ZipArchiveOutputStream(System.out);

            // Call the focal method
            zipOutputStream.addRawArchiveEntry(entry, rawStream);
        } catch (IOException e) {
            fail("IOException was thrown: " + e.getMessage());
        } finally {
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    fail("Failed to close ZipArchiveOutputStream: " + e.getMessage());
                }
            }
        }
    }

}