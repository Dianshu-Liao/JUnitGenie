package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_setExtraFields_ZipExtraField_____cfg_path_4_Test {


    @Test(timeout = 4000)
    public void testSetExtraFieldsWithNullFields() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        entry.setExtraFields(null);

        // Validate that extraFields is set to EMPTY_ZIP_EXTRA_FIELD_ARRAY
        assertArrayEquals(new ZipExtraField[0], entry.getExtraFields()); // Use getter method
    }

    @Test(timeout = 4000)
    public void testSetExtraFieldsWithEmptyArray() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        entry.setExtraFields(new ZipExtraField[0]);

        // Validate that extraFields is set to EMPTY_ZIP_EXTRA_FIELD_ARRAY
        assertArrayEquals(new ZipExtraField[0], entry.getExtraFields()); // Use getter method
    }



}
