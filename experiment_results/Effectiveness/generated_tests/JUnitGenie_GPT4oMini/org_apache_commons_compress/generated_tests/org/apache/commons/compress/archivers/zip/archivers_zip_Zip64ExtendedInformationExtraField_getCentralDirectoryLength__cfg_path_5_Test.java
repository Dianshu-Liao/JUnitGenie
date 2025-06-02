package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(new ZipEightByteInteger(8)); // Using setter method to set size
        zipField.setCompressedSize(new ZipEightByteInteger(0)); // Set compressedSize to a valid value
        zipField.setRelativeHeaderOffset(new ZipEightByteInteger(0)); // Set relativeHeaderOffset to a valid value
        // Removed the setDiskStart method as it does not exist in Zip64ExtendedInformationExtraField

        // Act
        ZipShort result = null;
        try {
            result = zipField.getCentralDirectoryLength();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(new ZipShort(8), result); // Expecting the result to be 8
    }


}