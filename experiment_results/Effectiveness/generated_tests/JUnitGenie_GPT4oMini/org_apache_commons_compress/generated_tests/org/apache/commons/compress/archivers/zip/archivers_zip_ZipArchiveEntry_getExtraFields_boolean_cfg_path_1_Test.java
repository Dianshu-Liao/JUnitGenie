package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_getExtraFields_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetExtraFields_includeUnparseable() {
        try {
            ZipArchiveEntry zipEntry = new ZipArchiveEntry("test.zip");
            // Set up the necessary state or properties of zipEntry here if needed

            // Invoke focal method with includeUnparseable set to true
            ZipExtraField[] result = zipEntry.getExtraFields(true);
            
            // Validate the result
            assertNotNull("Expected non-null result", result);
            // Additional assertions can be made based on expected values
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while executing test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetExtraFields_excludeUnparseable() {
        try {
            ZipArchiveEntry zipEntry = new ZipArchiveEntry("test.zip");
            // Set up the necessary state or properties of zipEntry here if needed

            // Invoke focal method with includeUnparseable set to false
            ZipExtraField[] result = zipEntry.getExtraFields(false);
            
            // Validate the result
            assertNotNull("Expected non-null result", result);
            // Additional assertions can be made based on expected values
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown while executing test: " + e.getMessage());
        }
    }

}