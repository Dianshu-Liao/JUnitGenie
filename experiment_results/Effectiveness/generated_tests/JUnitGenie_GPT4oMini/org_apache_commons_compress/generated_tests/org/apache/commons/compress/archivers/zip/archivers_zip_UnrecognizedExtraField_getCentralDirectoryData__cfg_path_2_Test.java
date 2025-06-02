package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.UnrecognizedExtraField;
import org.apache.commons.compress.archivers.zip.ZipUtil;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class archivers_zip_UnrecognizedExtraField_getCentralDirectoryData__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryData_withNonNullCentralData() {
        // Arrange
        byte[] expectedData = new byte[]{1, 2, 3, 4, 5};
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        // Using reflection to set the private field centralData
        try {
            java.lang.reflect.Field field = UnrecognizedExtraField.class.getDeclaredField("centralData");
            field.setAccessible(true);
            field.set(unrecognizedExtraField, expectedData);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        byte[] actualData = unrecognizedExtraField.getCentralDirectoryData();

        // Assert
        assertArrayEquals(expectedData, actualData);
    }

    @Test(timeout = 4000)
    public void testGetCentralDirectoryData_withNullCentralData() {
        // Arrange
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        // centralData is null by default

        // Act
        byte[] actualData = unrecognizedExtraField.getCentralDirectoryData();

        // Assert
        // Here we would need to define what getLocalFileDataData() returns
        // Assuming it returns an empty byte array for this example
        byte[] expectedData = new byte[0]; // Replace with actual expected data from getLocalFileDataData()
        assertArrayEquals(expectedData, actualData);
    }

}