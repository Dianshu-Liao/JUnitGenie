package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_dump_DumpArchiveEntry_getSize__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetSizeWhenNotDirectory() {
        // Arrange
        DumpArchiveEntry entry = new DumpArchiveEntry("fileName", "filePath");
        // Assuming the constructor sets size to a specific value, e.g., 100
        // This is a placeholder for the actual size value you want to test
        long expectedSize = 100; 
        // Use reflection to set the private 'size' field
        try {
            java.lang.reflect.Field sizeField = DumpArchiveEntry.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            sizeField.setLong(entry, expectedSize);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        long actualSize = entry.getSize();

        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test(timeout = 4000)
    public void testGetSizeWhenIsDirectory() {
        // Arrange
        DumpArchiveEntry entry = new DumpArchiveEntry("dirName", "dirPath");
        // Use reflection to set the type to DIRECTORY
        try {
            java.lang.reflect.Field typeField = DumpArchiveEntry.class.getDeclaredField("type");
            typeField.setAccessible(true);
            typeField.set(entry, DumpArchiveEntry.TYPE.DIRECTORY);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        long actualSize = entry.getSize();

        // Assert
        assertEquals(DumpArchiveEntry.SIZE_UNKNOWN, actualSize);
    }

}