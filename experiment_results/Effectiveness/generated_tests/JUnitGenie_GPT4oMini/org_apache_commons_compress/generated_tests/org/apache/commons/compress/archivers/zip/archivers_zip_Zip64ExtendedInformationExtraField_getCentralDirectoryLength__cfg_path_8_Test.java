package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(new ZipEightByteInteger(8)); // Using setter method for size
        zipField.setCompressedSize(new ZipEightByteInteger(8)); // Using setter method for compressedSize
        zipField.setRelativeHeaderOffset(new ZipEightByteInteger(8)); // Using setter method for relativeHeaderOffset
        // Removed the setDiskStart method as it does not exist in Zip64ExtendedInformationExtraField

        // Act
        ZipShort result = null;
        try {
            result = zipField.getCentralDirectoryLength();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(new ZipShort(20), result); // Expecting the sum to be 20
    }

}