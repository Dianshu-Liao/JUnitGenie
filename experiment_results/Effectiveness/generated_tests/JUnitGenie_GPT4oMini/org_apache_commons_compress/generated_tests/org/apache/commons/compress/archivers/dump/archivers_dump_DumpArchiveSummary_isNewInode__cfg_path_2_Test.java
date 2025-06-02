package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveSummary;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.io.IOException;

public class archivers_dump_DumpArchiveSummary_isNewInode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNewInodeWhenFlagsIsNotSet() throws IOException {
        // Arrange
        byte[] dummyData = new byte[4]; // Dummy data for constructor, size adjusted to prevent ArrayIndexOutOfBoundsException
        DumpArchiveSummary summary = new DumpArchiveSummary(dummyData, null);
        
        // Set flags to 0 (not set)
        // Using reflection to set the private field 'flags' for testing
        try {
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        boolean result = summary.isNewInode();

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNewInodeWhenFlagsIsSet() throws IOException {
        // Arrange
        byte[] dummyData = new byte[4]; // Dummy data for constructor, size adjusted to prevent ArrayIndexOutOfBoundsException
        DumpArchiveSummary summary = new DumpArchiveSummary(dummyData, null);
        
        // Set flags to 2 (set)
        // Using reflection to set the private field 'flags' for testing
        try {
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        boolean result = summary.isNewInode();

        // Assert
        assertFalse(result);
    }

}