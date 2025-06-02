package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        ZipEightByteInteger size = new ZipEightByteInteger(1); // Example value
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1); // Example value
        ZipEightByteInteger relativeHeaderOffset = new ZipEightByteInteger(1); // Example value
        ZipLong diskStart = new ZipLong(1); // Example value

        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize, relativeHeaderOffset, diskStart);

        // Act
        ZipShort result = null;
        try {
            result = zipField.getCentralDirectoryLength();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        int expectedLength = 8 + 0 + 0 + 0; // 8 from size, 0 from compressedSize, 0 from relativeHeaderOffset, 0 from diskStart
        assertEquals(expectedLength, result.getValue());
    }

}