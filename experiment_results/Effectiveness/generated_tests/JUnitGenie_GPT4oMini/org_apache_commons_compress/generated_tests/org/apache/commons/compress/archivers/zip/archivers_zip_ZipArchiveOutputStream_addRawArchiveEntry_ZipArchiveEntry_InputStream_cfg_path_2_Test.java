package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveOutputStream_addRawArchiveEntry_ZipArchiveEntry_InputStream_cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testAddRawArchiveEntry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Using ByteArrayOutputStream instead of System.out
        ZipArchiveOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipArchiveOutputStream(outputStream);
            ZipArchiveEntry entry = new ZipArchiveEntry("testEntry.txt");
            InputStream rawStream = new ByteArrayInputStream("Sample content".getBytes());

            // Ensuring that the entry does not have Zip64 extra field
            entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
            
            // Invoke the focal method
            zipOutputStream.addRawArchiveEntry(entry, rawStream);
            zipOutputStream.finish(); // Ensure to finish the zip output stream
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        } finally {
            try {
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            } catch (IOException e) {
                fail("Failed to close ZipArchiveOutputStream: " + e.getMessage());
            }
        }
    }

}