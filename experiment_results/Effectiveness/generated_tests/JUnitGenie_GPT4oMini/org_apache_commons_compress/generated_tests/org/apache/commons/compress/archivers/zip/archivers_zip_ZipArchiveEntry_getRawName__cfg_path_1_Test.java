package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class archivers_zip_ZipArchiveEntry_getRawName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetRawNameWhenRawNameIsNotNull() {
        // Arrange
        byte[] expectedRawName = new byte[]{1, 2, 3, 4, 5};
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry");
        // Using reflection to set the private field rawName
        try {
            java.lang.reflect.Field field = ZipArchiveEntry.class.getDeclaredField("rawName");
            field.setAccessible(true);
            field.set(entry, expectedRawName);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        byte[] actualRawName = entry.getRawName();

        // Assert
        assertArrayEquals(expectedRawName, actualRawName);
    }

    @Test(timeout = 4000)
    public void testGetRawNameWhenRawNameIsNull() {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry");
        // Using reflection to set the private field rawName to null
        try {
            java.lang.reflect.Field field = ZipArchiveEntry.class.getDeclaredField("rawName");
            field.setAccessible(true);
            field.set(entry, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        byte[] actualRawName = entry.getRawName();

        // Assert
        assertArrayEquals(null, actualRawName);
    }

}