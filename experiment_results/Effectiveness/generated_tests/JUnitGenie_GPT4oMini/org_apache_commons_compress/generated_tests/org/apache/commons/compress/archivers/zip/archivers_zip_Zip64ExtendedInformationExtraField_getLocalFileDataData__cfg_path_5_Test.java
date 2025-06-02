package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_5_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testGetLocalFileDataData_ThrowsIllegalArgumentException_WhenOneSizeIsNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Use setter methods to set size and compressedSize
        zipField.setSize(new ZipEightByteInteger(1));
        zipField.setCompressedSize(null);

        try {
            zipField.getLocalFileDataData();
        } catch (IllegalArgumentException e) {
            // Verify the exception message
            assertEquals("Zip64 extended information must contain both size values in the local file header.", e.getMessage());
            throw e; // rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ReturnsData_WhenBothSizesAreNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Use setter methods to set both size and compressedSize
        zipField.setSize(new ZipEightByteInteger(1));
        zipField.setCompressedSize(new ZipEightByteInteger(2));

        byte[] result = zipField.getLocalFileDataData();
        byte[] expected = new byte[2 * 4]; // Assuming DWORD is 4 bytes

        // Verify that the result is as expected
        assertArrayEquals(expected, result);
    }


}