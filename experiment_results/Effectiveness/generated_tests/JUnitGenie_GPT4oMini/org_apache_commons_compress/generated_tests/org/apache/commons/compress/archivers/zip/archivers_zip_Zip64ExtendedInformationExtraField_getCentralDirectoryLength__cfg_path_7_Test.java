package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        zipField.setSize(new ZipEightByteInteger(8)); // Using setter method to set size
        zipField.setCompressedSize(new ZipEightByteInteger(8)); // Using setter method to set compressedSize
        zipField.setRelativeHeaderOffset(new ZipEightByteInteger(8)); // Using setter method to set relativeHeaderOffset
        // Removed the line that sets diskStart to null as it does not exist in the class

        // Act
        ZipShort result = null;
        try {
            result = zipField.getCentralDirectoryLength();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(new ZipShort(16), result); // Expecting the result to be 16
    }

}