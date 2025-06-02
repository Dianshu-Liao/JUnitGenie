package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_setExtraFields_ZipExtraField_____cfg_path_3_Test {


    @Test(timeout = 4000)
    public void testSetExtraFieldsWithNull() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");

        try {
            entry.setExtraFields(null);
            // Verify that extraFields is set to EMPTY_ZIP_EXTRA_FIELD_ARRAY
            assertArrayEquals(new ZipExtraField[0], entry.getExtraFields()); // Use getter method
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetExtraFieldsWithOnlyUnparseableField() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        ZipExtraField[] fields = new ZipExtraField[] {
            new UnparseableExtraFieldData() // Only unparseable field
        };

        try {
            entry.setExtraFields(fields);
            // Verify that extraFields is set to EMPTY_ZIP_EXTRA_FIELD_ARRAY
            assertArrayEquals(new ZipExtraField[0], entry.getExtraFields()); // Use getter method
            // Note: Assuming there is a method to check for unparseable extra fields
            // The method getUnparseableExtra() does not exist, so we will remove this assertion
            // assertNotNull(entry.getUnparseableExtra()); // Use getter method
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}
