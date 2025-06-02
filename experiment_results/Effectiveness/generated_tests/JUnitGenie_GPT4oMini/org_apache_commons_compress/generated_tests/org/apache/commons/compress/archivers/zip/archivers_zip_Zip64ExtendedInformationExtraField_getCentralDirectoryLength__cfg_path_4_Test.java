package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_Zip64ExtendedInformationExtraField_getCentralDirectoryLength__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetCentralDirectoryLength() {
        // Arrange
        Zip64ExtendedInformationExtraField zipField = new Zip64ExtendedInformationExtraField();
        // Setting the private fields using reflection
        try {
            java.lang.reflect.Field sizeField = Zip64ExtendedInformationExtraField.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.set(zipField, new ZipEightByteInteger(8)); // Setting size to a non-null value

            java.lang.reflect.Field compressedSizeField = Zip64ExtendedInformationExtraField.class.getDeclaredField("compressedSize");
            compressedSizeField.setAccessible(true);
            compressedSizeField.set(zipField, new ZipEightByteInteger(8)); // Setting compressedSize to a non-null value

            java.lang.reflect.Field relativeHeaderOffsetField = Zip64ExtendedInformationExtraField.class.getDeclaredField("relativeHeaderOffset");
            relativeHeaderOffsetField.setAccessible(true);
            relativeHeaderOffsetField.set(zipField, new ZipEightByteInteger(8)); // Setting relativeHeaderOffset to a non-null value

            java.lang.reflect.Field diskStartField = Zip64ExtendedInformationExtraField.class.getDeclaredField("diskStart");
            diskStartField.setAccessible(true);
            diskStartField.set(zipField, new ZipLong(8)); // Setting diskStart to a non-null value

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        ZipShort result = zipField.getCentralDirectoryLength();

        // Assert
        assertEquals(new ZipShort(12), result); // Expecting the sum to be 12
    }

}