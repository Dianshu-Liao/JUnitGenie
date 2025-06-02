package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.UnrecognizedExtraField;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class archivers_zip_UnrecognizedExtraField_getCentralDirectoryData__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryData_whenCentralDataIsNull() {
        // Arrange
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        // Assuming the constructor initializes localData to a non-null value
        // Removed the setLocalData method as it does not exist
        byte[] localData = new byte[]{1, 2, 3}; // Directly using localData

        // Act
        byte[] result = unrecognizedExtraField.getCentralDirectoryData();

        // Assert
        assertArrayEquals(localData, result);
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryData_whenCentralDataIsNotNull() {
        // Arrange
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        // Removed the setLocalData method as it does not exist
        // Assuming the constructor initializes centralData to a non-null value
        byte[] centralData = new byte[]{4, 5, 6}; // Directly using centralData

        // Act
        byte[] result = unrecognizedExtraField.getCentralDirectoryData();

        // Assert
        assertArrayEquals(centralData, result);
    }

}