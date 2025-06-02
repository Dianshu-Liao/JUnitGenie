package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getLocalFileDataLength__cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength() {
        // Arrange
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        
        // Setting up external variables based on their private nature using reflection
        try {
            java.lang.reflect.Field bit0Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
            bit0Field.setAccessible(true);
            bit0Field.set(instance, true);

            java.lang.reflect.Field bit1Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
            bit1Field.setAccessible(true);
            bit1Field.set(instance, true);

            java.lang.reflect.Field accessTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("createTime");
            accessTimeField.setAccessible(true);
            accessTimeField.set(instance, null); // since we do not want to set createTime

            java.lang.reflect.Field bit2Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
            bit2Field.setAccessible(true);
            bit2Field.set(instance, false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            // handle the reflection exception
        }

        // Act
        ZipShort result = instance.getLocalFileDataLength();

        // Assert
        assertEquals(new ZipShort(5), result);
    }

}