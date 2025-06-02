package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.DumpArchiveSummary;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class archivers_dump_DumpArchiveSummary_isMetaDataOnly__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsMetaDataOnlyTrue() {
        // Setup
        byte[] dummyBytes = new byte[4]; // Dummy byte array for constructor, size adjusted
        DumpArchiveSummary summary = null;
        
        // Using reflection to set the private 'flags' field for testing
        try {
            summary = new DumpArchiveSummary(dummyBytes, null);
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 0x0100); // Setting flags to 256 to meet the condition in isMetaDataOnly()
            
            // Execute
            boolean result = summary.isMetaDataOnly();

            // Verify
            assertTrue(result);
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testIsMetaDataOnlyFalse() {
        // Setup
        byte[] dummyBytes = new byte[4]; // Dummy byte array for constructor, size adjusted
        DumpArchiveSummary summary = null;
        
        // Using reflection to set the private 'flags' field for testing
        try {
            summary = new DumpArchiveSummary(dummyBytes, null);
            java.lang.reflect.Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
            flagsField.setAccessible(true);
            flagsField.setInt(summary, 0); // Setting flags to 0 to not meet the condition in isMetaDataOnly()
            
            // Execute
            boolean result = summary.isMetaDataOnly();

            // Verify
            assertTrue(!result);
        } catch (NoSuchFieldException | IllegalAccessException | IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

}