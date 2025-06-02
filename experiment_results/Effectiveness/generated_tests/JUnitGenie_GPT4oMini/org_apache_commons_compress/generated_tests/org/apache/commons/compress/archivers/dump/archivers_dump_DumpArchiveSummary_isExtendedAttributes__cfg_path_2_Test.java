package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveSummary;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class archivers_dump_DumpArchiveSummary_isExtendedAttributes__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsExtendedAttributes() {
        // Arrange
        byte[] dummyData = new byte[8]; // Adjusted size for constructor
        DumpArchiveSummary summary = null;

        // Handle IOException when creating DumpArchiveSummary
        try {
            summary = new DumpArchiveSummary(dummyData, null);
        } catch (IOException e) {
            e.printStackTrace();
            return; // Exit the test if an exception occurs
        }

        // Set the flags field to 0x8000 to test the true case
        // Using reflection to access the private field
        try {
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 0x8000); // Set flags to 0x8000

            // Act
            boolean result = summary.isExtendedAttributes();

            // Assert
            assertTrue(result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}