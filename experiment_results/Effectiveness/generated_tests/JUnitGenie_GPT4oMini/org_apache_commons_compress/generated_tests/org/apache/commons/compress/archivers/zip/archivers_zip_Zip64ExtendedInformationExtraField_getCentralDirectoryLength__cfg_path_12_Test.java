package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        ZipEightByteInteger size = new ZipEightByteInteger(8);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(8);
        ZipEightByteInteger relativeHeaderOffset = new ZipEightByteInteger(8);
        ZipLong diskStart = new ZipLong(4);
        
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField(size, compressedSize, relativeHeaderOffset, diskStart);
        
        // Act
        ZipShort result = null;
        try {
            result = zipField.getCentralDirectoryLength();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(new ZipShort(20), result);
    }

}