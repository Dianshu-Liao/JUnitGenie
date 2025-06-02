package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class archivers_zip_ZipArchiveEntry_getExtraFields_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetExtraFieldsWithIncludeUnparseableFalse() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        boolean includeUnparseable = false;

        try {
            ZipExtraField[] extraFields = entry.getExtraFields(includeUnparseable);
            assertNotNull("Expected non-null extra fields when includeUnparseable is false", extraFields);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}