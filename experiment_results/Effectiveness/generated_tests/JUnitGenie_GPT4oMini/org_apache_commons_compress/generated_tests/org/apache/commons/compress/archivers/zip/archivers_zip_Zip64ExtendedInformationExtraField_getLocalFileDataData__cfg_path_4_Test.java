package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ThrowsIllegalArgumentException_WhenSizeIsNullAndCompressedSizeIsNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            zipField.setCompressedSize(new ZipEightByteInteger(1000)); // Set compressedSize using setter
            zipField.getLocalFileDataData(); // This should throw an exception
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Zip64 extended information must contain both size values in the local file header.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ThrowsIllegalArgumentException_WhenCompressedSizeIsNullAndSizeIsNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            zipField.setSize(new ZipEightByteInteger(1000)); // Set size using setter
            zipField.getLocalFileDataData(); // This should throw an exception
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Zip64 extended information must contain both size values in the local file header.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ReturnsData_WhenBothSizesAreNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(new ZipEightByteInteger(1000)); // Set size using setter
        zipField.setCompressedSize(new ZipEightByteInteger(1000)); // Set compressedSize using setter
        
        byte[] data = zipField.getLocalFileDataData();
        assertNotNull(data);
        assertEquals(8, data.length); // Assuming DWORD is 4, so 2 * DWORD = 8
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ReturnsEmptyArray_WhenBothSizesAreNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(null); // Set size to null using setter
        zipField.setCompressedSize(null); // Set compressedSize to null using setter
        
        byte[] data = zipField.getLocalFileDataData();
        assertNotNull(data);
        assertEquals(0, data.length); // Should return an empty byte array
    }


}