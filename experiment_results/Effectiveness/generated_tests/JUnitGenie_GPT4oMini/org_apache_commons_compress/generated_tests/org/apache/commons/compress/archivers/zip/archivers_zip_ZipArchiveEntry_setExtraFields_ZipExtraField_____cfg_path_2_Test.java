package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class archivers_zip_ZipArchiveEntry_setExtraFields_ZipExtraField_____cfg_path_2_Test {


    @Test(timeout = 4000)
    public void testSetExtraFieldsWithNull() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        entry.setExtraFields(null);

        // Validate that extraFields is set to EMPTY_ZIP_EXTRA_FIELD_ARRAY
        assertArrayEquals(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY, entry.getExtraFields());
    }

    @Test(timeout = 4000)
    public void testSetExtraFieldsWithEmptyArray() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");
        ZipExtraField[] fields = new ZipExtraField[0];

        entry.setExtraFields(fields);

        // Validate that extraFields is set to EMPTY_ZIP_EXTRA_FIELD_ARRAY
        assertArrayEquals(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY, entry.getExtraFields());
    }


}
