package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.utils.ByteUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_WithNullSizes() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        byte[] expected = ByteUtils.EMPTY_BYTE_ARRAY;

        byte[] result = zipField.getLocalFileDataData();

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_WithOnlySizeNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Assuming we have a way to set the compressedSize
        zipField.setCompressedSize(new ZipEightByteInteger(1000)); // Example value

        try {
            zipField.getLocalFileDataData();
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_WithOnlyCompressedSizeNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Assuming we have a way to set the size
        zipField.setSize(new ZipEightByteInteger(1000)); // Example value

        try {
            zipField.getLocalFileDataData();
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }


}