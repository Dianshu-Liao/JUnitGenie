package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class archivers_zip_ResourceAlignmentExtraField_getLocalFileDataData__cfg_path_2_Test {

    private static final int BASE_SIZE = 2; // Define BASE_SIZE with an appropriate value
    private static final int ALLOW_METHOD_MESSAGE_CHANGE_FLAG = 1; // Define ALLOW_METHOD_MESSAGE_CHANGE_FLAG with an appropriate value

    @Test(timeout = 4000)
    public void testGetLocalFileDataData() {
        // Arrange
        int padding = 2; // Example padding value
        boolean allowMethodChange = true; // Example flag value
        ResourceAlignmentExtraField resourceAlignmentExtraField = new ResourceAlignmentExtraField(padding, allowMethodChange);

        // Act
        byte[] result = resourceAlignmentExtraField.getLocalFileDataData();

        // Assert
        byte[] expectedContent = new byte[BASE_SIZE + padding];
        short alignment = (short) (32768 | (allowMethodChange ? ALLOW_METHOD_MESSAGE_CHANGE_FLAG : 0));
        ZipShort.putShort(alignment, expectedContent, 0);
        assertArrayEquals(expectedContent, result);
    }


}