package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ThrowsIllegalArgumentException_WhenSizeIsNullAndCompressedSizeIsNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            zipField.getLocalFileDataData();
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Zip64 extended information must contain both size values in the local file header.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ThrowsIllegalArgumentException_WhenCompressedSizeIsNullAndSizeIsNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            zipField.getLocalFileDataData();
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Zip64 extended information must contain both size values in the local file header.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ReturnsEmptyByteArray_WhenBothSizesAreNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        byte[] result = zipField.getLocalFileDataData();
        assertArrayEquals(new byte[0], result);
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ReturnsData_WhenBothSizesAreNotNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(1);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1);
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize);
        byte[] result = zipField.getLocalFileDataData();
        assertNotNull(result);
        assertEquals(8, result.length); // Assuming DWORD is 4, hence 2 * DWORD = 8
    }

}