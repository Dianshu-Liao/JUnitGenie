package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Setting all fields to null to ensure they contribute 0 to the length
        // Since they are private, we assume they are set to null by default in the constructor

        // Act
        ZipShort result = zipField.getCentralDirectoryLength();

        // Assert
        assertEquals(new ZipShort(0), result);
    }

}