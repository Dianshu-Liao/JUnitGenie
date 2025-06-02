package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class archivers_zip_Zip64ExtendedInformationExtraField_getLocalFileDataData__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataData_ThrowsIllegalArgumentException_WhenSizeIsNullAndCompressedSizeIsNotNull() {
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        try {
            // Use reflection to set private fields for testing
            java.lang.reflect.Field sizeField = Zip64ExtendedInformationExtraField.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.set(zipField, null); // Set size to null

            java.lang.reflect.Field compressedSizeField = Zip64ExtendedInformationExtraField.class.getDeclaredField("compressedSize");
            compressedSizeField.setAccessible(true);
            compressedSizeField.set(zipField, new ZipEightByteInteger(1000)); // Example value

            zipField.getLocalFileDataData();
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Zip64 extended information must contain both size values in the local file header.", e.getMessage());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection error: " + e.getMessage());
        }
    }


}