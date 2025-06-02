package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataData() {
        // Arrange
        ZipEightByteInteger size = new ZipEightByteInteger(1000); // Example value
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(800); // Example value
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize);

        // Act
        byte[] result = zipField.getLocalFileDataData();

        // Assert
        byte[] expected = new byte[2 * 4]; // Assuming DWORD is 4
        // Here you would typically fill expected with the expected values based on the addSizes logic
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataDataThrowsException() {
        // Arrange
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(null, null);

        // Act
        try {
            zipField.getLocalFileDataData();
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("LFH_MUST_HAVE_BOTH_SIZES_MSG", e.getMessage());
            return; // Test passes if exception is thrown
        }
        // If we reach here, the test failed
        fail("Expected IllegalArgumentException was not thrown.");
    }


}