package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_setExtraTimeFields__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testSetExtraTimeFields() {
        try {
            // Create an instance of ZipArchiveEntry
            ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");

            // Set up the necessary conditions for the test
            // Simulate that the extra fields are empty to ensure getExtraField returns null
            // This is done by not adding any extra fields to the entry

            // Use reflection to access the private method setExtraTimeFields
            Method method = ZipArchiveEntry.class.getDeclaredMethod("setExtraTimeFields");
            method.setAccessible(true);

            // Invoke the method
            method.invoke(entry);

            // Verify that the method executed without throwing exceptions
            // Since we don't have a direct way to verify the internal state, we can only ensure no exceptions are thrown
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

}