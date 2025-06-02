package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveSummary;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.io.IOException;

public class archivers_dump_DumpArchiveSummary_isNewHeader__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNewHeaderWhenFlagsIsZero() {
        // Arrange
        byte[] dummyData = new byte[8]; // Adjusted size for constructor
        DumpArchiveSummary summary = null;
        try {
            summary = new DumpArchiveSummary(dummyData, null);
            // Directly setting the flags field for testing purposes
            // This assumes you have a way to set the private field, e.g., reflection or a setter method
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 0); // Set flags to 0

            // Act
            boolean result = summary.isNewHeader();

            // Assert
            assertFalse(result);
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

}